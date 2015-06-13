package ministere;

import gestionVoeu.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
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
    public String[] getListRectorats() {
        return MinistereDatabase.getInstance().getRectorats();
    }
}

public class MinistereServeur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Instancie et initialise l'ORB
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            MinistereImpl ministereImpl = new MinistereImpl();
            ministereImpl.setORB(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ministereImpl);

            Ministere href = MinistereHelper.narrow(ref);

            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new NameComponent("Ministere", "");
            // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
            nameRoot.rebind(nameToRegister, rootpoa.servant_to_reference(ministereImpl));

            System.out.println(" MinistereServer est prêt et attend une invocation de méthode");
            // mise en attente des invocations client
            orb.run();
        } catch (InvalidName | AdapterInactive | ServantNotActive | WrongPolicy | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(MinistereServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server Exiting ...");
    }

}
