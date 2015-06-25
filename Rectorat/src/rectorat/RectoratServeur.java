package rectorat;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.EtatDecision;
import gestionVoeu.EtatInscription;
import gestionVoeu.EtatVoeu;
import gestionVoeu.EtudiantDetail;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import gestionVoeu.RectoratPOA;
import gestionVoeu.UniversiteDetail;
import gestionVoeu.VoeuxDetail;
import gestionVoeu.compteInconnu;
import gestionVoeu.diplomeInconnu;
import gestionVoeu.malformedInformation;
import org.omg.CORBA.ORB;
import tools.DistantObjectManager;
import tools.MandantDialog;

/**
 *
 * @author Mathias
 */
//IMPLEMENTATION DE LA CLASSE RECTORAT POA /!\ CODE METIER
class RectoratImpl extends RectoratPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public EtudiantDetail connexion(String num_etu, String pwd) throws compteInconnu {
        return RectoratDatabase.getInstance().verifierPassword(num_etu, pwd);
    }

    @Override
    public void creerVoeux(VoeuxDetail monVoeux) {
        RectoratDatabase.getInstance().creerVoeux(monVoeux);
    }

    @Override
    public CandidatureDetail[] recupererVoeuxMaster(String universite, int master) throws diplomeInconnu {
        return RectoratDatabase.getInstance().recupererVoeuxMaster(universite, master);
    }

    @Override
    public CandidatureDetail[] recupererVoeuxEtudiant(String num_etu) throws compteInconnu {
        return RectoratDatabase.getInstance().recupererVoeuxEtudiant(num_etu);
    }

    @Override
    public void modifierCandidatureEtat(CandidatureDetail maCandidature, EtatVoeu ev, EtatDecision ed, EtatInscription ei) throws malformedInformation {
        if(!maCandidature.etatVoeu.equals(ev)){
            switch(ev.value()){
                case EtatVoeu._NON_DEFINITIF :
                    this.nonDefinitif(maCandidature.voeuxDetail.etu.num_etudiant); break;
                case EtatVoeu._OUI_DEFINITIF :
                    this.ouiDefinitif(maCandidature); break;
                case EtatVoeu._OUI_MAIS : 
                    this.voeuMais(maCandidature, EtatVoeu.OUI_MAIS); break;
                case EtatVoeu._NON_MAIS :
                    this.voeuMais(maCandidature, EtatVoeu.NON_MAIS); break;
            }
        } else if(!maCandidature.etatDecision.equals(ed)) {
            this.decisionVoeu(maCandidature, ed);
        } else if(!maCandidature.etatInscription.equals(ei)){
            if(ei.equals(EtatInscription.CLOTURE)){
                maCandidature.etatInscription = ei;
                RectoratDatabase.getInstance().modifierCandidatureEtat(maCandidature);
            }
        }
    }
    
    /**
     * permet de modifier l'état de decision de la fac envers un voeux
     * @param candid candidature concerné par la modification
     * @param ed etat de decision a modifier
     */
    private void decisionVoeu(CandidatureDetail candid, EtatDecision ed){
        candid.etatDecision = ed;
        RectoratDatabase.getInstance().modifierCandidatureEtat(candid);
    }
    
    /**
     * Permet de setter a cloture et annuler les candidatures d'un classement inferieur au "mais" selectionné
     * @param candid candidature concernée par le mais
     * @param voeuMais etat voeu mais selectionné pour savoir si c'est un oui mais ou un non mais
     */
    private void voeuMais(CandidatureDetail candid, EtatVoeu voeuMais){
        CandidatureDetail[] cds = RectoratDatabase.getInstance().recupererVoeuxEtudiant(candid.voeuxDetail.etu.num_etudiant);
        for(CandidatureDetail cd : cds){
            if(cd.voeuxDetail.classement > candid.voeuxDetail.classement){
                cd.etatVoeu = EtatVoeu.NON_DEFINITIF;
                cd.etatInscription = EtatInscription.CLOTURE;
                RectoratDatabase.getInstance().modifierCandidatureEtat(cd);
            } else if(cd.voeuxDetail.classement == candid.voeuxDetail.classement) {
                cd.etatVoeu = voeuMais;
                RectoratDatabase.getInstance().modifierCandidatureEtat(candid);
            }
        }
    }
    
    /**
     * Permet de cloturer les inscriptions en cloturant tout les voeux et en n'en gardant qu'un a oui definitif
     * @param candid candidature concernée par le oui definitif
     */
    private void ouiDefinitif(CandidatureDetail candid){
        CandidatureDetail[] cds = RectoratDatabase.getInstance().recupererVoeuxEtudiant(candid.voeuxDetail.etu.num_etudiant);
        for(CandidatureDetail cd : cds){
            if(cd.equals(candid)){
                cd.etatVoeu = EtatVoeu.OUI_DEFINITIF;
            } else {
                cd.etatVoeu = EtatVoeu.NON_DEFINITIF;
            }
            cd.etatInscription = EtatInscription.CLOTURE;
            RectoratDatabase.getInstance().modifierCandidatureEtat(cd);
        }
    }
    
    /**
     * Permet de cloturer toutes les inscriptions et de les considérer toute comme refusées par l'étudiant
     * @param ine ine de l'étudiant qui n'a plus "d'avenir"
     */
    private void nonDefinitif(String ine){
        CandidatureDetail[] cds = RectoratDatabase.getInstance().recupererVoeuxEtudiant(ine);
        for(CandidatureDetail cd : cds){
            cd.etatVoeu = EtatVoeu.NON_DEFINITIF;
            cd.etatInscription = EtatInscription.CLOTURE;
            RectoratDatabase.getInstance().modifierCandidatureEtat(cd);
        }
    }

    @Override
    public UniversiteDetail[] recupererUniversites() {
        return RectoratDatabase.getInstance().getUniversites();
    }
}

public class RectoratServeur {
    
    private static final RectoratServeur INSTANCE = new RectoratServeur();
    
    private String mandant;
    private Ministere ministere;

    public static RectoratServeur getInstance() {
        return RectoratServeur.INSTANCE;
    }

    private RectoratServeur() {
        this.mandant = "";
        this.ministere = MinistereHelper.narrow(DistantObjectManager.getInstance().getReference("Ministere"));
    }
    
    public void setMandant(String m){
        this.mandant = m;
    }
    
    public String getMandant(){
        return this.mandant;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while ("".equals(RectoratServeur.getInstance().getMandant())){
            RectoratServeur.getInstance().setMandant(MandantDialog.getMandant());
        }
        
        RectoratImpl rectoratImpl = new RectoratImpl();
        rectoratImpl.setORB(DistantObjectManager.getInstance().getORB());
        DistantObjectManager.getInstance().ajoutReference(RectoratServeur.getInstance().getMandant(), rectoratImpl);
        System.out.println(" RectoratServer " + RectoratServeur.getInstance().getMandant() + " est prêt et attend une invocation de méthode");
        DistantObjectManager.getInstance().getORB().run();

        System.out.println("Server Exiting ...");

    }
}
