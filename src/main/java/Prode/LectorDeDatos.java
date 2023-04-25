package Prode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class LectorDeDatos {
    private Fases fases;
    private Competicion competicion;

    public LectorDeDatos(){

        this.fases = new Fases();
        this.competicion = new Competicion();
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
            if (nombreApostador.equals("") || nombreApostador.equals(" ")) nombreApostador = lector.next();
            int nroPartido = lector.nextInt();
            int nroFaseApuesta = lector.nextInt();
            String equipoLocal = lector.next();
            if (equipoLocal.equals("") || equipoLocal.equals(" ")) equipoLocal = lector.next();
            String equipoVisitante = lector.next();
            int apuesta = lector.nextInt();

            Apuesta apuestaObj = new Apuesta(nombreApostador,equipoLocal ,equipoVisitante ,apuesta,nroPartido);

            this.competicion.agregarApuesta(apuestaObj);
        }
    }
        public void calcularPuntaje(){
            this.competicion.calcularPuntaje2(this.competicion.getApuestas(), this.fases.getPartidos());
    }

        public void informar(){
            for(Map.Entry entry :this.competicion.getParticipantes().entrySet()){
                Object nombre = entry.getKey();
                Object puntaje = entry.getValue();

                System.out.println("El participante " + nombre + " saco " + puntaje);
            }
        }
}
