package Prode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministadorDeConexiones {
   static private String dbUsuario;
   static private String dbPassword;
   static private String dbDriver;
   static private String url;

    public static Connection conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        dbDriver = "org.postgresql.Driver";
        dbUsuario = "postgres";
        dbPassword = "L4D3d10s";
        url = "jdbc:postgresql://localhost:5432/practico";
        Class.forName(dbDriver).newInstance();
        Connection conn = DriverManager.getConnection(url,dbUsuario,dbPassword);
        return conn;
    }

}
