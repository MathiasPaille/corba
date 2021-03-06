package ministere;

import com.google.gson.Gson;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.RectoratDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Databases;
import tools.SQLConnexion;

/**
 *
 * @author Yvan
 */
public class MinistereDatabase extends SQLConnexion {

    private final Gson gson = new Gson();
    private static final MinistereDatabase INSTANCE = new MinistereDatabase();

    public static MinistereDatabase getInstance() {
        return MinistereDatabase.INSTANCE;
    }

    private MinistereDatabase() {
        super(Databases.MINISTERE);
    }

    /**
     * Methode de ministere pour récuperer tout les diplomes
     * @return retourne la liste de diplomes
     */
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
                    String diplomes = res.getString("dip_prerequis");
                    
                    //Initialisation d'une liste et récupération d'un json pour savoir les prérequis
                    DiplomeJson dj = gson.fromJson(diplomes, DiplomeJson.class);
                    int lenghtOfListe = dj.requis.size();
                    String listDip[] = new String[lenghtOfListe];
                    System.arraycopy(dj.requis.toArray(), 0, listDip, 0, lenghtOfListe);                    
                    dd[res.getRow() - 1] = new DiplomeDetail(id, libelle, listDip);
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinistereDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (dd);
    }
    
     /**
     * Permet de récupérer la liste des rectorats
     * @return la liste totale et complète des rectorats.
     */
    public RectoratDetail[] getRectorats(){
        RectoratDetail[] ss = null;
        try {
            ResultSet res = this.makeRequest("select * from rectorats");
            if (res != null) {
                int rowcount = 0;
                //récupération de la taille du resultSet
                if (res.last()) {
                    rowcount = res.getRow();
                    res.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
                }
                ss = new RectoratDetail[rowcount];
                while (res.next()) {
                    String id = res.getString("rectorats_id");
                    String name = res.getString("rectorats_name");
                    ss[res.getRow() - 1] = new RectoratDetail(id, name);
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinistereDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ss;
    }

    public class DiplomeJson{
        public ArrayList<String> requis;
        
        public DiplomeJson(int index){
            requis = new ArrayList<>();
        }
        
        public String getTheDipl(int index){
            return requis.get(index);
        }
    }

}
