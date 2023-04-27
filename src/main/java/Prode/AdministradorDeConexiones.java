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

        dbDriver = "com.mysql.cj.jdbc.Driver";
        dbUsuario = "root";
        dbPassword = "juancy23z";
        url = "jdbc:mysql://localhost/";
        Class.forName(dbDriver).newInstance();
        Connection conn = DriverManager.getConnection(url,dbUsuario,dbPassword);
        return conn;
    }
}