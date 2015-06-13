package universite;

import gestionVoeu.DiplomeDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Databases;
import tools.SQLConnexion;

/**
 *
 * @author Yvan
 */
public class UniversiteDatabase extends SQLConnexion {
    private static final UniversiteDatabase INSTANCE = new UniversiteDatabase();
    
    public static UniversiteDatabase getInstance(){
        return UniversiteDatabase.INSTANCE;
    }

    private UniversiteDatabase() {
        super(Databases.UNIVERSITE);
    }
    
    /**
     * Cette méthode permet de récupérer les différentes affiliations de l'universitée courante
     * @return un ensemble d'entier correspondant aux affiliations
     */
    public int[] getAffiliations(){
        int[] aff = null;
        try {
            ResultSet res = this.makeRequest("select dip_id from universite_diplome where mandant = '" + UniversiteServeur.getInstance().getMandant() + "'");
            if (res != null) {
                int rowcount = 0;
                //récupération de la taille du resultSet
                if (res.last()) {
                    rowcount = res.getRow();
                    res.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
                }
                aff = new int[rowcount];
                while (res.next()) {
                    aff[res.getRow() - 1] = res.getInt("dip_id");
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversiteDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aff;
    }
}
