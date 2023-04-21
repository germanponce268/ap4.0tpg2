package Prode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Fase fase = new Fase();
        TargetaProde prode = new TargetaProde();
        Apuesta jugada ;
        Partido partido;

        Connection con = AdministadorDeConexiones.conectar();
        Statement st  = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM prode.resultados");

        while(rs.next()){
            int nroPartido = rs.getInt("nro_partido");
            int nroFase = rs.getInt("fase");
            String equipoLocal = rs.getString("equipo_local");
            String equipoVisitante = rs.getString("equipo_visitante");
            int golesLocal = rs.getInt("goles_local");
            int golesVisitante = rs.getInt("goles_visitante");

            partido = new Partido(nroPartido,equipoLocal,equipoVisitante,golesLocal,golesVisitante, nroFase);

            fase.agregarPartido(partido);

        }

        ResultSet rsApuestas = st.executeQuery("SELECT * FROM prode.pronosticos");

        while(rsApuestas.next()){
            int nroApuesta = rsApuestas.getInt("nro_apuesta");
            int nroPartido = rsApuestas.getInt("nro_partido");
            int nroFase = rsApuestas.getInt("fase");
            String local = rsApuestas.getString("equipo_local");
            String visitante = rsApuestas.getString("equipo_visitante");
            int apuesta = rsApuestas.getInt("apuesta");
            String nombreApostador = rsApuestas.getString("nombre");

            jugada = new Apuesta(local, visitante, apuesta,nroApuesta, nroPartido, nombreApostador, nroFase);

            prode.agregarApuesta(jugada);

            prode.calcularPuntaje(jugada, fase.getPartidos());
        }


        for(Map.Entry<String, Integer> entry : prode.getParticipantes().entrySet()){
            String nombre = entry.getKey();
            int puntos = entry.getValue();
            System.out.println(nombre + " obtuvo " + puntos + " puntos");
        }

        st.close();
        con.close();


    }


}
