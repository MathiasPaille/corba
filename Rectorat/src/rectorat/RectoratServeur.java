package rectorat;

import gestionVoeu.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.SystemException;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
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
    public void redistribuerCandidature(int mandant, CandidatureDetail CD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class RectoratServeur {
    
    private static final RectoratServeur INSTANCE = new RectoratServeur();
    
    private String mandant;

    public static RectoratServeur getInstance() {
        return RectoratServeur.INSTANCE;
    }

    private RectoratServeur() {
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
        
        RectoratServeur.getInstance().setMandant(MandantDialog.getMandant());
        
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            RectoratImpl rectoratImpl = new RectoratImpl();
            rectoratImpl.setORB(orb);

            // get object reference from the servant
            
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(rectoratImpl);
            Universite href = UniversiteHelper.narrow(ref);
            
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new NameComponent(RectoratServeur.getInstance().getMandant(), "");
            // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
            nameRoot.rebind(nameToRegister, rootpoa.servant_to_reference(rectoratImpl));

            System.out.println(" RectoratServer " + RectoratServeur.getInstance().getMandant() + " est prêt et attend une invocation de méthode");
            // mise en attente des invocations client
            orb.run();
        } catch (org.omg.CORBA.ORBPackage.InvalidName | AdapterInactive | ServantNotActive | WrongPolicy | InvalidName | NotFound | CannotProceed ex) {
            Logger.getLogger(RectoratServeur.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Server Exiting ...");

    }
}
