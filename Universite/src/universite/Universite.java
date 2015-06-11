package universite;

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
}

public class Universite {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
