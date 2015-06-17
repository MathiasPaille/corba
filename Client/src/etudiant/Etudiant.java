package etudiant;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.EtudiantDetail;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import gestionVoeu.Rectorat;
import gestionVoeu.RectoratHelper;
import gestionVoeu.compteInconnu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Yvan
 */
public class Etudiant {
    
    private static final Etudiant INSTANCE = new Etudiant();
    
    private CandidatureDetail[] listeVoeux;
    private EtudiantDetail details;
    private ORB orb;
    private org.omg.CosNaming.NamingContext nameRoot;
    private Rectorat rectorat;
    private Ministere ministere;
    private String[] rectorats;
    
    public static Etudiant getInstance(){
        return INSTANCE;
    }
    
    private Etudiant(){
        this.details = null;
    }
    
    public void init(){
        String[] infosConnexion = ConnexionDialog.getConnexionDetails(false);
        
        try {
            
            String[] args = new String[0];
            // Intialisation de l'orb
            this.orb = org.omg.CORBA.ORB.init(args,null);
            // Recuperation du naming service
            this.nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
                     
            //recherche du rectorat
            NameComponent[] rectoratToFind = new NameComponent[1];
            rectoratToFind[0] = new NameComponent(infosConnexion[0], "");
            org.omg.CORBA.Object distantRectorat = this.nameRoot.resolve(rectoratToFind);
            this.rectorat = RectoratHelper.narrow(distantRectorat);
            
            boolean connected = false;
            while(!connected){
                try {
                    EtudiantDetail et = this.rectorat.connexion(infosConnexion[1], infosConnexion[2]);
                    this.ajoutDetails(et);
                    connected = true;
                } catch (compteInconnu ex) {
                    JOptionPane.showMessageDialog(null, ex.raison, "Problème de connexion", JOptionPane.ERROR_MESSAGE);
                    String[] newInfosConnexion = ConnexionDialog.getConnexionDetails(true);
                    infosConnexion[1] = newInfosConnexion[1];
                    infosConnexion[2] = newInfosConnexion[2];
                }
            }
            
            this.listeVoeux = this.rectorat.recupererVoeuxEtudiant(this.details.num_etudiant);
            
            //recherche du rectorat
            NameComponent[] ministereToFind = new NameComponent[1];
            ministereToFind[0] = new NameComponent("ministere", "");
            org.omg.CORBA.Object ministereRectorat = this.nameRoot.resolve(ministereToFind);
            this.ministere = MinistereHelper.narrow(ministereRectorat);
            this.rectorats = this.ministere.getListRectorats();

        } catch (org.omg.CORBA.ORBPackage.InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | compteInconnu ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void ajoutDetails(EtudiantDetail det){
        this.details = det;
    }
    
    public EtudiantDetail getDetails(){
        return this.details;
    }

    public String[] getRectorats() {
        return rectorats;
    }
    
    public CandidatureDetail[] getListeVoeux(){
        return listeVoeux;
    }

    /**
     * Launch the client
     */
    public static void main() {
        Etudiant.getInstance().init();
        EtudiantChoice panel = new EtudiantChoice();            
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
