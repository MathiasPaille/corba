package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yvan
 */
public abstract class SQLConnexion {

    private Connection connect = null;
    private Statement statement = null;

    public SQLConnexion(Databases database) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ministere?user=root");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void finalize() {
        try {
            statement.close();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet makeRequest(String query) {
        if(connect == null || statement == null) return null;
        try {
            // Result set get the result of the SQL query
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
