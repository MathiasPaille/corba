package rectorat;

import gestionVoeu.*;
import org.omg.CORBA.*;
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
    public CandidatureDetail[] recupererVoeuxMaster(int master) throws diplomeInconnu {
        return RectoratDatabase.getInstance().recupererVoeuxMaster(master);
    }

    @Override
    public CandidatureDetail[] recupererVoeuxEtudiant(String num_etu) throws compteInconnu {
        return RectoratDatabase.getInstance().recupererVoeuxEtudiant(num_etu);
    }

    @Override
    public void modifierCandidatureEtat(CandidatureDetail maCandidature) throws malformedInformation {
        RectoratDatabase.getInstance().modifierCandidatureEtat(maCandidature);
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
