package universite;

import gestionVoeu.*;
import java.util.logging.Level;
import java.util.logging.Logger;
// Importation du service de nommage.
import org.omg.CosNaming.*;
// Package contenant les exceptions lancées par le service de nommage.
import org.omg.CosNaming.NamingContextPackage.*;
// Classes necessaires à toute application CORBA.
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


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
    public CandidatureDetail[] consulterCandidatures() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCandidature(CandidatureDetail candidature, EtatDecision etatDecision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            UniversiteImpl universiteImpl = new UniversiteImpl();
            universiteImpl.setORB(orb);

            // get object reference from the servant
            
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(universiteImpl);
            Universite href = UniversiteHelper.narrow(ref);
            
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new NameComponent(UniversiteServeur.getInstance().getMandant(), "");
            // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
            nameRoot.rebind(nameToRegister, rootpoa.servant_to_reference(universiteImpl));

            System.out.println(" UniversiteServer " + UniversiteServeur.getInstance().getMandant() + " est prêt et attend une invocation de méthode");
            // mise en attente des invocations client
            orb.run();
        } catch (org.omg.CORBA.ORBPackage.InvalidName | AdapterInactive | ServantNotActive | WrongPolicy | InvalidName | NotFound | CannotProceed ex) {
            Logger.getLogger(UniversiteServeur.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Server Exiting ...");

    }
}
