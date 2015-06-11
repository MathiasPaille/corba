package rectorat;

import tools.Databases;
import tools.SQLConnexion;

/**
 *
 * @author Yvan
 */
public class RectoratDatabase extends SQLConnexion{
    private static final RectoratDatabase INSTANCE = new RectoratDatabase();
    
    public static RectoratDatabase getInstance(){
        return RectoratDatabase.INSTANCE;
    }

    private RectoratDatabase() {
        super(Databases.RECTORAT);
    }
}
