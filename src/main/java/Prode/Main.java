package Prode;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
        static Fase fase = new Fase();
        static TargetaProde prode = new TargetaProde();
        static Apuesta jugada = new Apuesta() ;
        static Persona jugador = new Persona("Jose", "Perez");
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        Connection con = AdministadorDeConexiones.conectar();

        Statement st  = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pronosticos");

        while(rs.next()){
            int nroPartido = rs.getInt("nro_partido");
            String equipoLocal = rs.getString("equipo_local");
            String equipoVisitante = rs.getString("equipo_visitante");
            int apuesta = rs.getInt("apuesta");

            System.out.println(nroPartido + " " + equipoLocal + " " + equipoVisitante + " " + apuesta);
        }

        if(con !=null){
            System.out.println("Exito!");
        }else{
            System.out.println("Fracaso");
        }
    }


}
