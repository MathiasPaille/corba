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
public class MinistereDatabase extends SQLConnexion {
    
    private static final MinistereDatabase INSTANCE = new MinistereDatabase();
    
    public static MinistereDatabase getInstance(){
        return MinistereDatabase.INSTANCE;
    }

    private MinistereDatabase() {
        super(Databases.MINISTERE);
    }
    
//    public TreeMap<Integer, String> getDiplomes(){
//        TreeMap<Integer, String> diplomes = new TreeMap<>();
//        try {
//            ResultSet res = this.makeRequest("select * from diplomes order by id");
//            if(res != null){
//                while(res.next()){
//                    Integer id = res.getInt("id");
//                    String libelle = res.getString("libellé");
//                    diplomes.put(id, libelle);
//                }
//                res.close();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MinistereBase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return diplomes;
//    }
    
}
