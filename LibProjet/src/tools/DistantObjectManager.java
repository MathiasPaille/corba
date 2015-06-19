package tools;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.Servant;

/**
 *
 * @author Yvan
 */
public class DistantObjectManager {
    private static final DistantObjectManager INSTANCE = new DistantObjectManager();
    
    private ORB orb;
    private POA rootPOA;
    private org.omg.CosNaming.NamingContext nameRoot;
    
    private TreeMap<String, org.omg.CORBA.Object> references;
    
    private DistantObjectManager(){
        this.references = new TreeMap<>();
        
        String[] args = new String[0];
        // Intialisation de l'orb
        this.orb = org.omg.CORBA.ORB.init(args,null);
        
        try {
            // Recuperation du naming service
            this.rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            this.rootPOA.the_POAManager().activate();
            this.nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
        } catch (InvalidName | AdapterInactive ex) {
            Logger.getLogger(DistantObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DistantObjectManager getInstance(){
        return INSTANCE;
    }
    
    /**
     * Renvoit la référence d'un objet CORBA distant
     * @param name nom distant de l'objet
     * @return objet CORBA
     */
    public org.omg.CORBA.Object getReference(String name){
        if(!this.references.containsKey(name)){
            try {
                //recherche du rectorat
                NameComponent[] objectToFind = new NameComponent[1];
                objectToFind[0] = new NameComponent(name, "");
                org.omg.CORBA.Object distantObject = this.nameRoot.resolve(objectToFind);
                this.references.put(name, distantObject);
            } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                Logger.getLogger(DistantObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return this.references.get(name);
    }
    
    /**
     * Ajoute un objet au NamingService
     * @param name nom de l'objet
     * @param servant objet servant (implémentation)
     */
    public void ajoutReference(String name, Servant servant){
        try {
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new NameComponent(name, "");
            // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
            this.nameRoot.rebind(nameToRegister, this.rootPOA.servant_to_reference(servant));
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive | WrongPolicy ex) {
            Logger.getLogger(DistantObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public org.omg.CORBA.ORB getORB(){
        return this.orb;
    }
}
