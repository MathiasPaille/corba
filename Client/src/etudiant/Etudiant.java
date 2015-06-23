package etudiant;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.EtudiantDetail;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import gestionVoeu.Rectorat;
import gestionVoeu.RectoratDetail;
import gestionVoeu.RectoratHelper;
import gestionVoeu.Universite;
import gestionVoeu.UniversiteDetail;
import gestionVoeu.UniversiteHelper;
import gestionVoeu.VoeuxDetail;
import gestionVoeu.compteInconnu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tools.DistantObjectManager;

/**
 *
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
    
    public static Etudiant getInstance(){
        return INSTANCE;
    }
    
    private Etudiant(){
        this.details = null;
    }
    
    public void init(){
        String[] infosConnexion = ConnexionDialog.getConnexionDetails(false);
        
        try {
            
            this.rectorat = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(infosConnexion[0]));
            
            boolean connected = false;
            while(!connected){
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
            
            this.listeVoeux = this.rectorat.recupererVoeuxEtudiant(this.details.num_etudiant);
            
            this.ministere = MinistereHelper.narrow(DistantObjectManager.getInstance().getReference("Ministere"));
            this.rectorats = this.ministere.getListRectorats();
            
            this.diplomes = ministere.getListDiplomes();

        } catch (compteInconnu ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public UniversiteDetail[] getUniversitesList(String rect){
        Rectorat res = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(rect));
        return res.recupererUniversites();
    }
    
    public void ajoutVoeu(int master, String universite, String rectorat, int classement){
        this.rectorat.creerVoeux(new VoeuxDetail(master, universite, rectorat, classement, this.getDetails()));
    }
    
    public DiplomeDetail[] getFormationsList(String univ){
        Universite res = UniversiteHelper.narrow(DistantObjectManager.getInstance().getReference(univ));
        int[] diplomesReal = res.getAffiliations();
        DiplomeDetail[] diplomesRecu = new DiplomeDetail[diplomesReal.length];
        for(int i = 0; i < diplomesReal.length; i++){
            for(DiplomeDetail d : this.diplomes){
                if(d.id == diplomesReal[i]) diplomesRecu[i] = d;
            }
        }
        return diplomesRecu;
    }
    
    public String getFormationLibelle(int formationID){
        for(DiplomeDetail dd : this.diplomes){
            if(dd.id == formationID){
                return dd.libelle;
            }
        }
        return "Diplôme inconnu";
    }
    
    public String getUniversiteLibelle(String universiteID, String rectoratID){
        UniversiteDetail[] ud = this.getUniversitesList(rectoratID);
        for(UniversiteDetail u : ud){
            if(u.id == null ? universiteID == null : u.id.equals(universiteID)){
                return u.name;
            }
        }
        return "Universite Inconnue";
    }
    
    public String getRectoratLibelle(String rectoratID){
        for(RectoratDetail rd : this.rectorats){
            if(rd.id == null ? rectoratID == null : rd.id.equals(rectoratID)){
                return rd.name;
            }
        }
        return "Rectorat inconnu";
    }
    
    public void ajoutDetails(EtudiantDetail det){
        this.details = det;
    }
    
    public EtudiantDetail getDetails(){
        return this.details;
    }

    public RectoratDetail[] getRectorats() {
        return rectorats;
    }
    
    public CandidatureDetail[] getListeVoeux(){
        return listeVoeux;
    }

    /**
     * Launch the client
     */
    public static void main(String[] args) {
        Etudiant.getInstance().init();
        EtudiantChoice panel = new EtudiantChoice();            
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
