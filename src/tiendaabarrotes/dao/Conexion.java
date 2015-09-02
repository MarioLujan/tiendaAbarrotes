package tiendaabarrotes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mario Lujan
 */
public class Conexion {
    private static Conexion conn;
    private Connection c;

    private Conexion() {
        
    }
    
    public static Conexion getInstance(){
        if(conn == null){
            conn = new Conexion();
        }
        return conn;
    }
    
    public Connection getConexion(){
        if(c == null){
            String driver = "com.mysql.jdbc.Driver";
            String cadenaConexion = 
                    "jdbc:mysql://localhost:3306/bdprod";
            String user = "root";
            String password = "";
            try {
                Class.forName(driver);
                this.c = DriverManager.
                        getConnection(cadenaConexion, user, password);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Conexion.class.getName())
                        .log(Level.SEVERE, null, ex);

            }
        }
        return this.c;
    }
}