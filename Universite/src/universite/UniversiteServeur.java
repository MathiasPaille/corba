package universite;

import tools.MandantDialog;
import gestionVoeu.*;
import org.omg.CORBA.*;
import tools.DistantObjectManager;


/**
 *
 * @author Yvan
 */
//IMPLEMENTATION DE LA CLASSE MINISTERE POA /!\ CODE METIER
class UniversiteImpl extends UniversitePOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }
    
    @Override
    public int[] getAffiliations() {
        return UniversiteDatabase.getInstance().getAffiliations();
    }
}

public class UniversiteServeur {

    private static final UniversiteServeur INSTANCE = new UniversiteServeur();
    
    private String mandant;

    public static UniversiteServeur getInstance() {
        return UniversiteServeur.INSTANCE;
    }

    private UniversiteServeur() {
        this.mandant = "";

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
        
        UniversiteServeur.getInstance().setMandant(MandantDialog.getMandant());
        
        UniversiteImpl universiteImpl = new UniversiteImpl();
        universiteImpl.setORB(DistantObjectManager.getInstance().getORB());
        DistantObjectManager.getInstance().ajoutReference(UniversiteServeur.getInstance().getMandant(), universiteImpl);
        System.out.println(" UniversiteServer " + UniversiteServeur.getInstance().getMandant() + " est prêt et attend une invocation de méthode");
        DistantObjectManager.getInstance().getORB().run();

        System.out.println("Server Exiting ...");

    }
}
