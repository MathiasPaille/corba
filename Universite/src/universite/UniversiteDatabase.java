package universite;

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
