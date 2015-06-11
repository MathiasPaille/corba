package universite;

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
public class UniversiteDatabase extends SQLConnexion {
    private static final UniversiteDatabase INSTANCE = new UniversiteDatabase();
    
    public static UniversiteDatabase getInstance(){
        return UniversiteDatabase.INSTANCE;
    }

    private UniversiteDatabase() {
        super(Databases.UNIVERSITE);
    }
}
