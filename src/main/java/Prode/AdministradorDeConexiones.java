package Prode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {
    static private String dbUsuario;
    static private String dbPassword;
    static private String dbDriver;
    static private String url;

    public AdministradorDeConexiones() {
    }

    public  Connection conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SQLException {

        dbDriver = "org.postgresql.Driver";
        dbUsuario = "postgres";
        dbPassword = "L4D3d10s";
        url = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName(dbDriver).newInstance();
        Connection conn = DriverManager.getConnection(url,dbUsuario,dbPassword);
        return conn;
    }
}
