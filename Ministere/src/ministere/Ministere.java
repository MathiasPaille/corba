package ministere;

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
        public affiliationMaster[] getAffiliations() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
}

public class Ministere {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
