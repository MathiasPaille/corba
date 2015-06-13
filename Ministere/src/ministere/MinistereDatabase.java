package ministere;

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
public class MinistereDatabase extends SQLConnexion {

    private static final MinistereDatabase INSTANCE = new MinistereDatabase();

    public static MinistereDatabase getInstance() {
        return MinistereDatabase.INSTANCE;
    }

    private MinistereDatabase() {
        super(Databases.MINISTERE);
    }

    public DiplomeDetail[] getDiplomes() {
        DiplomeDetail[] dd = null;
        try {
            ResultSet res = this.makeRequest("select * from diplomes order by id");
            if (res != null) {
                int rowcount = 0;
                //récupération de la taille du resultSet
                if (res.last()) {
                    rowcount = res.getRow();
                    res.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
                }
                dd = new DiplomeDetail[rowcount];
                while (res.next()) {
                    Integer id = res.getInt("id");
                    String libelle = res.getString("libelle");
                    dd[res.getRow() - 1] = new DiplomeDetail(id, libelle);
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinistereDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (dd);
    }

}
