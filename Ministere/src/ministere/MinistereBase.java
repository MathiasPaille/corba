package ministere;

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
public class MinistereBase extends SQLConnexion {
    
    private static final MinistereBase INSTANCE = new MinistereBase();
    
    public static MinistereBase getInstance(){
        return MinistereBase.INSTANCE;
    }

    private MinistereBase() {
        super(Databases.MINISTERE);
    }
    
    public TreeMap<String, String> getDiplomes(){
        TreeMap<String, String> diplomes = new TreeMap<>();
        try {
            ResultSet res = this.makeRequest("select * from diplomes");
            while(res.next()){
                String id = res.getString("id");
                String libelle = res.getString("libellé");
                diplomes.put(id, libelle);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(MinistereBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diplomes;
    }
    
}
