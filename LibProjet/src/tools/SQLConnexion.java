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

    public SQLConnexion(Databases database) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/ministere?"
                            + "user=localhost");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void finalize() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet makeRequest(String query) {
        ResultSet resultSet = null;
        try {
            // Statements allow to issue SQL queries to the database
            Statement statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
}
