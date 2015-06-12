package etudiant;

import gestionVoeu.DiplomeDetail;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Yvan
 */
public class Etudiant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //faire la connexion
        try {
            
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            // Recuperation du naming service
            org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            // Construction du nom a rechercher
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere","");
            // Recherche aupres du naming service
            org.omg.CORBA.Object distantMinistere = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + "Ministere" + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantMinistere));
            // Casting de l'objet CORBA au type convertisseur euro
            Ministere minist = MinistereHelper.narrow(distantMinistere);
            
            //get l'objet de liste
            DiplomeDetail[] diplomesDetails = minist.getListDiplomes();

            EtudiantChoice panel = new EtudiantChoice();
            for(int i = 0; i < diplomesDetails.length; i++){
                panel.afficherTexteOut("Clé : " + diplomesDetails[i].id + " - Diplôme : " + diplomesDetails[i].libelle);
            }
            JFrame frame = new JFrame();
            frame.add(panel);
            frame.setVisible(true);

        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
