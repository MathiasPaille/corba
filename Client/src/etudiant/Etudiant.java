package etudiant;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.EtatVoeu;
import gestionVoeu.EtudiantDetail;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import gestionVoeu.Phase;
import gestionVoeu.Rectorat;
import gestionVoeu.RectoratDetail;
import gestionVoeu.RectoratHelper;
import gestionVoeu.Universite;
import gestionVoeu.UniversiteDetail;
import gestionVoeu.UniversiteHelper;
import gestionVoeu.VoeuxDetail;
import gestionVoeu.compteInconnu;
import gestionVoeu.malformedInformation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tools.DistantObjectManager;

/**
 * Code métier pour l'interface étudiant
 * @author Yvan
 */
public class Etudiant {

    private static final Etudiant INSTANCE = new Etudiant();

    private CandidatureDetail[] listeVoeux;
    private EtudiantDetail details;
    private Rectorat rectorat;
    private Ministere ministere;
    private RectoratDetail[] rectorats;
    private DiplomeDetail[] diplomes;

    public static Etudiant getInstance() {
        return INSTANCE;
    }

    private Etudiant() {
        this.details = null;
    }
    
    /**
     * Initialisation du client étudiant avec les infos de connexion récupérées sur le rectorat
     */
    public void init() {
        String[] infosConnexion = ConnexionDialog.getConnexionDetails(false);

        this.rectorat = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(infosConnexion[0]));
        boolean connected = false;
        while (!connected) {
            try {
                EtudiantDetail et = this.rectorat.connexion(infosConnexion[1], infosConnexion[2]);
                this.ajoutDetails(et);
                connected = true;
            } catch (compteInconnu ex) {
                JOptionPane.showMessageDialog(null, ex.raison, "Problème de connexion", JOptionPane.ERROR_MESSAGE);
                String[] newInfosConnexion = ConnexionDialog.getConnexionDetails(true);
                infosConnexion[1] = newInfosConnexion[1];
                infosConnexion[2] = newInfosConnexion[2];
            }
        }
        this.refreshListVoeux();
        this.ministere = MinistereHelper.narrow(DistantObjectManager.getInstance().getReference("Ministere"));
        this.rectorats = this.ministere.getListRectorats();
        this.diplomes = ministere.getListDiplomes();
    }

    /**
     * permet de rafraichir la liste des voeux
     */
    public void refreshListVoeux() {
        try {
            this.listeVoeux = this.rectorat.recupererVoeuxEtudiant(this.details.num_etudiant);
        } catch (compteInconnu ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Permet de récupérer la liste des universitées, utile pour selectionner les formations en fonction des universitées
     * @param rect rectorat des universitées concernées
     * @return liste d'universitées
     */
    public UniversiteDetail[] getUniversitesList(String rect) {
        Rectorat res = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(rect));
        return res.recupererUniversites();
    }

    /**
     * Permet d'envoyer le mecanisme d'ajout de voeux en base de données
     * @param master numéro du master
     * @param universite identifiant de l'université (par exemple : universite1)
     * @param rectorat identifiant du rectorat (par exemple : rectorat1)
     * @param classement classement du voeux selectionné
     */
    public void ajoutVoeu(int master, String universite, String rectorat, int classement) {
        this.rectorat.creerVoeux(new VoeuxDetail(master, universite, rectorat, classement, this.getDetails()));
        this.refreshListVoeux();
    }

    /**
     * permet de retourner la liste des formations EN FONCTION DE LA LICENSE DE L'ETUDIANT : ne retourne pas les master dont l'étudiant n'a pas les prérequis
     * @param univ universite de laquelle on veut les formations
     * @return liste de formation trié avec les prerequis
     */
    public DiplomeDetail[] getFormationsList(String univ) {
        this.refreshListVoeux();
        Universite res = UniversiteHelper.narrow(DistantObjectManager.getInstance().getReference(univ));
        int[] diplomesReal = res.getAffiliations();
        //DiplomeDetail[] diplomesRecu = new DiplomeDetail[diplomesReal.length];
        ArrayList<DiplomeDetail> ArrayListDiplomesLesVrais = new ArrayList();
        for (int i = 0; i < diplomesReal.length; i++) {
            for (DiplomeDetail d : this.diplomes) {
                //ICI ON TRI LA LISTE POUR AFFICHER UNIQUEMENT LES FORMATIONS DESTINES A UN ETUDIANT
                if (d.id == diplomesReal[i]) {
                    boolean monBoul = false;
                    for (String listeDip : d.listeDip) {
                        if (listeDip.equals(this.details.license)) {
                            monBoul = true;
                        }
                    }
                    if (monBoul) {
                        ArrayListDiplomesLesVrais.add(d);
                    }
                }
            }
        }
        return this.ArrayListDiplomesToTableau(ArrayListDiplomesLesVrais);
    }
    
    /**
     * Methode permettant la transformation d'une array list de DiplomeDetail en diplomedetail[]
     * @param ddl c'est la arraylist de diplomes
     * @return le tableau de diplome detail
     */
    public DiplomeDetail[] ArrayListDiplomesToTableau(ArrayList<DiplomeDetail> ddl) {
        return (DiplomeDetail[]) ddl.toArray(new DiplomeDetail[ddl.size()]);
    }

    /**
     * Get le libellé d'une formation avec l'id de la formation
     * @param formationID l'id de la formation
     * @return le libellé de la formation
     */
    public String getFormationLibelle(int formationID) {
        for (DiplomeDetail dd : this.diplomes) {
            if (dd.id == formationID) {
                return dd.libelle;
            }
        }
        return "Diplôme inconnu";
    }

    /**
     * récupérer le libelle de l'universite
     * @param universiteID id de l'universite
     * @param rectoratID id du rectorat
     * @return 
     */
    public String getUniversiteLibelle(String universiteID, String rectoratID) {
        UniversiteDetail[] ud = this.getUniversitesList(rectoratID);
        for (UniversiteDetail u : ud) {
            if (u.id == null ? universiteID == null : u.id.equals(universiteID)) {
                return u.name;
            }
        }
        return "Universite Inconnue";
    }

    /**
     * récupérer le libelle du rectorat
     * @param rectoratID id du rectorat
     * @return le libelle du rectorat
     */
    public String getRectoratLibelle(String rectoratID) {
        for (RectoratDetail rd : this.rectorats) {
            if (rd.id == null ? rectoratID == null : rd.id.equals(rectoratID)) {
                return rd.name;
            }
        }
        return "Rectorat inconnu";
    }

    public void ajoutDetails(EtudiantDetail det) {
        this.details = det;
    }

    public EtudiantDetail getDetails() {
        return this.details;
    }

    public RectoratDetail[] getRectorats() {
        return rectorats;
    }

    public CandidatureDetail[] getListeVoeux() {
        return listeVoeux;
    }

    public Phase getPhase() {
        return this.ministere.getPhase();
    }
    
    public void faireVoeu(CandidatureDetail cd, EtatVoeu ev){
        try {
            this.rectorat.modifierCandidatureEtat(cd, ev, cd.etatDecision, cd.etatInscription);
        } catch (malformedInformation ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Launch the client
     *
     * @param args paramêtres du programme
     */
    public static void main(String[] args) {
        Etudiant.getInstance().init();
        EtudiantChoice panel = new EtudiantChoice();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
