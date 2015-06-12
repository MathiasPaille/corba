package ministere;

import java.util.TreeMap;

import gestionVoeu.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import org.omg.CORBA.SystemException;

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
    public void redistribuerCandidature(CandidatureDetail CD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redistribuerVoeux(VoeuxDetail VD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiplomeDetail[] getListDiplomes() {
        return MinistereDatabase.getInstance().getDiplomes();
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

            // obtention d'une référence sur le POA racine 
            // un adapteur d'objet est un mécanisme qui connecte une requête 
            // (utilisant une référence à un object) avec le code du service requis.
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // activation du gestionnaire de POA qui devient prêt à traiter une requête
            rootpoa.the_POAManager().activate();

            // Intancie le servant (l'objet requis) et l'enregistre auprès de l'ORB
            // Le servant est une instance de la classe HelloImpl
            // qui hérite de l'adaptateur d'objets portables sur différents ORB(classe HelloPOA)
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
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Server Exiting ...");
    }

}
