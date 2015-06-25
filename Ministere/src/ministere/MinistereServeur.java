package ministere;

import gestionVoeu.*;
import org.omg.CORBA.*;
import tools.DistantObjectManager;

/**
 *
 * @author Yvan
 */
//IMPLEMENTATION DE LA CLASSE MINISTERE POA /!\ CODE METIER
class MinistereImpl extends MinisterePOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public DiplomeDetail[] getListDiplomes() {
        return MinistereDatabase.getInstance().getDiplomes();
    }

    @Override
    public RectoratDetail[] getListRectorats() {
        return MinistereDatabase.getInstance().getRectorats();
    }

    @Override
    public Phase getPhase() {
        return MinistereServeur.getInstance().getPhaseActuelle();
    }
}

public class MinistereServeur {
    
    private static final MinistereServeur INSTANCE = new MinistereServeur();
    
    private Phase phaseActuelle;
    
    private MinistereServeur(){
        this.phaseActuelle = Phase.PHASE_1;
    }
    
    public static MinistereServeur getInstance(){
        return INSTANCE;
    }
    
    public Phase getPhaseActuelle(){
        return this.phaseActuelle;
    }

    public void setPhaseActuelle(Phase phaseActuelle) {
        this.phaseActuelle = phaseActuelle;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PhaseFrame pf = new PhaseFrame();
        MinistereImpl ministereImpl = new MinistereImpl();
        ministereImpl.setORB(DistantObjectManager.getInstance().getORB());
        DistantObjectManager.getInstance().ajoutReference("Ministere", ministereImpl);
        System.out.println("Serveur Ministere est pret et attend une invocation de méthode...");
        DistantObjectManager.getInstance().getORB().run();
        System.out.println("Server Exiting ...");
    }

}
