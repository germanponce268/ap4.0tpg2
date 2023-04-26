package Prode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LectorDeDatos {
    private Fases fases;
    private Competicion competicion;
    private AdministradorDeConexiones admConexion;

    public LectorDeDatos(){

        this.fases = new Fases();
        this.competicion = new Competicion();
        this.admConexion = new AdministradorDeConexiones();
    }

    public void leerPartidos(String ruta) throws IOException {
        Path path = Paths.get(ruta);

        Scanner lector = new Scanner(path);

        lector.useDelimiter("[;\\n\\r]+");

        while(lector.hasNextInt()){
            int nroPartido = lector.nextInt();
            int nroFase = lector.nextInt();
            String local = lector.next();
            if (local.equals("") || local.equals(" ")) local = lector.next();
            String visitante = lector.next();
            int golesLocal = lector.nextInt();
            int golesVisitante = lector.nextInt();

            Partido partido = new Partido(nroFase,nroPartido, local, visitante,golesLocal ,golesVisitante );

            this.fases.agregarPartido(partido);
        }
    }
    public void leerApuestas(String ruta) throws IOException {
        Path path = Paths.get(ruta);

        Scanner lector = new Scanner(path);

        lector.useDelimiter("[;\\n\\r]+");

        while (lector.hasNext()) {
            String nombreApostador = lector.next();
            int nroPartido = lector.nextInt();
            int nroFaseApuesta = lector.nextInt();
            String equipoLocal = lector.next();
            String equipoVisitante = lector.next();
            int apuesta = lector.nextInt();

            Apuesta apuestaObj = new Apuesta(nombreApostador,equipoLocal ,equipoVisitante ,apuesta,nroPartido);

            this.competicion.agregarApuesta(apuestaObj);
        }
    }

    public void leerApuestasDB() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn = this.admConexion.conectar();

        Statement st  = conn.createStatement();
        ResultSet rsApuestas = st.executeQuery("SELECT * FROM prode.pronosticos");

        while(rsApuestas.next()){
            //int nroApuesta = rsApuestas.getInt("nro_apuesta");
            int nroPartido = rsApuestas.getInt("nro_partido");
           // int nroFase = rsApuestas.getInt("fase");
            String local = rsApuestas.getString("equipo_local");
            String visitante = rsApuestas.getString("equipo_visitante");
            int apuesta = rsApuestas.getInt("apuesta");
            String nombreApostador = rsApuestas.getString("nombre");

            Apuesta apuestaObj = new Apuesta(nombreApostador,local ,visitante ,apuesta, nroPartido);

            this.competicion.agregarApuesta(apuestaObj);
        }

    }
    public void leerPartidosDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection conn = this.admConexion.conectar();
        Statement st  = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM prode.resultados");

        while(rs.next()){
            int nroPartido = rs.getInt("nro_partido");
            int nroFase = rs.getInt("fase");
            String equipoLocal = rs.getString("equipo_local");
            String equipoVisitante = rs.getString("equipo_visitante");
            int golesLocal = rs.getInt("goles_local");
            int golesVisitante = rs.getInt("goles_visitante");

            Partido partido = new Partido(nroFase, nroPartido, equipoLocal,  equipoVisitante,  golesLocal, golesVisitante);

            this.fases.agregarPartido(partido);
        }

    }
        public void obtenerPuntaje(){
            this.competicion.calcularPuntaje(this.competicion.getApuestas(), this.fases.getPartidos());
    }

        public void informar(){
            Integer mayor = 0;
            String ganador = null;
            for(Map.Entry entry :this.competicion.getParticipantes().entrySet()){
                Object nombre = entry.getKey();
                Object puntaje = entry.getValue();

                if((Integer)puntaje > mayor){
                    mayor = (Integer)puntaje;
                    ganador = (String)nombre;
                }
                System.out.println("El participante " + nombre + " saco " + puntaje);
            }
            System.out.println("\n El ganador es " + ganador + " con " + mayor + " puntos");
        }
}
