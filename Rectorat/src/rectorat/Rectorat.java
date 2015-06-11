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

public class Rectorat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
