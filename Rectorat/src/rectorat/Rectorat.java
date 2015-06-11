package rectorat;

import gestionVoeu.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
/**
 *
 * @author Mathias
 */
class RectoratImpl extends RectoratPOA {
    private ORB orb;
    
    public void setORB(ORB orb_val) {
        orb = orb_val;
    }
    
    //implement creerVoeux method
    public void creerVoeux(VoeuxDetail monVoeux) {
        
    }
    //implement  method
    //implement  method
    //implement  method
    //implement  method    
}

public class Rectorat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
