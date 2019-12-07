package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author APRENDIZ
 */
public class ConexionBD {

    private String driver, urlBD, userBD, passwordBD, bd;
    private Connection conexion;

    public ConexionBD() {

        driver = "com.mysql.jdbc.Driver";    
        userBD = "root";
        passwordBD = "";
        bd = "BD_Votaciones3";
        urlBD = "jdbc:mysql://localhost/BD_Votaciones3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

        try {

            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBD, userBD, passwordBD);
            System.out.println("¡Conexion Hecha!");

        } catch (Exception e) {
            System.out.println("Error al conectarse a la BD " + e.toString());
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args) {
        new ConexionBD();
    }
}
