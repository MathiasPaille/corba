package rectorat;

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
 * @author Mathias
 */
//IMPLEMENTATION DE LA CLASSE RECTORAT POA /!\ CODE METIER
class RectoratImpl extends RectoratPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public VoeuxDetail[] recupererVoeuxMaster(int master) throws diplomeInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VoeuxDetail[] recupererVoeuxEtudiant(int num_etu) throws compteInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CandidatureDetail[] recupererEtatCandidatures(VoeuxDetail[] listeVoeux) throws voeuInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void creerVoeux(VoeuxDetail monVoeux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCandidatureEtat(CandidatureDetail maCandidature) throws malformedInformation {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class RectoratServeur {

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
            RectoratImpl rectoratImpl = new RectoratImpl();
            rectoratImpl.setORB(orb);

            // obtention d'une référence sur l'objet servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(rectoratImpl);
            // la méthode narrow "caste" la référence à l'objet CORBA obtenue 
            // en une référence dans son type propre
            Rectorat href = RectoratHelper.narrow(ref);

            // Obtention d'une référence générique pour le service de nommage
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // L'objet obtenu est un objet CORBA générique. Il est converti dans
            // son type propre grâce à la classe HelloHelper générée par le compilateur
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // création du nom symbolique de l'objet servant
            String nom = "Hello";
            NameComponent path[] = ncRef.to_name(nom);
            // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
            ncRef.rebind(path, href);

            System.out.println(" HelloServer est prêt et attend une invocation de méthode");
            // mise en attente des invocations client
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Server Exiting ...");

    }
}
