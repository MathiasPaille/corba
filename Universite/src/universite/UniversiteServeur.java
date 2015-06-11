package universite;

import gestionVoeu.*;
// Importation du service de nommage.
import org.omg.CosNaming.*;
// Package contenant les exceptions lancées par le service de nommage.
import org.omg.CosNaming.NamingContextPackage.*;
// Classes necessaires à toute application CORBA.
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class UniversiteServeur {

    private static final UniversiteServeur INSTANCE = new UniversiteServeur();

    public static UniversiteServeur getInstance() {
        return UniversiteServeur.INSTANCE;
    }

    private UniversiteServeur() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting ...");

            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Server Exiting ...");

    }
}
