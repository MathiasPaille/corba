package rectorat;

import gestionVoeu.EtudiantDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Databases;
import tools.SQLConnexion;

/**
 *
 * @author Yvan
 */
public class RectoratDatabase extends SQLConnexion {

    private static final RectoratDatabase INSTANCE = new RectoratDatabase();

    public static RectoratDatabase getInstance() {
        return RectoratDatabase.INSTANCE;
    }

    private RectoratDatabase() {
        super(Databases.RECTORAT);
    }

    public EtudiantDetail getUnEtudiant(int mandant, int etu_ine) {
        EtudiantDetail e = null;
        try {
            ResultSet res = this.makeRequest("select * from etudiant where etudiant.mandant=" + mandant + " and etudiant.etu_ine="+ etu_ine);
            if (res != null) {
                while (res.next()) {
                    Integer res_etu_ine = res.getInt("etu_ine");
                    String res_etu_nom = res.getString("etu_nom");
                    String res_etu_prenom = res.getString("etu_prenom");
                    String res_etu_adresse = res.getString("etu_adresse");
                    Integer res_etu_universite = res.getInt("etu_universite");
                    Integer res_etu_license = res.getInt("etu_license");
                    String res_etu_notes = res.getString("etu_notes");
                    
                    //e = new EtudiantDetail(res_etu_ine, res_etu_nom, res_etu_prenom, res_etu_adresse, res_etu_universite, res_etu_license, res_etu_notes);
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RectoratDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}
