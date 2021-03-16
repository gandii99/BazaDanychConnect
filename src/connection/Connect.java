package connection;

import java.sql.*;

public class Connect {

    private String driver = "org.postgresql.Driver";
    private String host = "195.150.230.210";
    private String port = "5434";//wymagane kiedy nie jest domyślny dla bazy
    private String dbname = "2021_urban_radoslaw";
    private String user = "2021_urban_radoslaw";
    private String url = "jdbc:postgresql://" + host+":"+port + "/" + dbname;
    private String pass = "33209";
    private Connection connection;

    public Connect (String host, String port, String dbname, String user, String password) {
        this.host = host;
        this.port = port;
        this.dbname = dbname;
        this.user = user;
        this.pass = pass;

        connection = makeConnection();
    }

    public Connection getConnection(){
        return(connection);
    }

    public void close() {
        try {
            connection.close(); }

        catch (SQLException sqle){
            System.err.println("Blad przy zamykaniu polaczenia: " + sqle);

        }
    }

    public Connection makeConnection(){
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass); return(connection);

        }
        catch(ClassNotFoundException cnfe) {
            System.err.println("Blad ladowania sterownika: " + cnfe);

            return(null);
        }
        catch(SQLException sqle) {
            System.err.println("Blad przy nawiązywaniu polaczenia: " + sqle);

            return(null);
        }
    }
}