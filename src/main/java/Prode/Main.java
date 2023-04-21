package Prode;

import Prode.Apuesta;
import Prode.Fase;
import Prode.Partido;
import Prode.TargetaProde;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Fase fase = new Fase();
        Apuesta jugada = new Apuesta();
        TargetaProde prode = new TargetaProde();
        Partido partido = new Partido();

        Path resultadosLocal = Paths.get("resultadosMundial2.csv");
        Path pronosticoLocal = Paths.get("pronosticosMundial.csv");


        Scanner lector = new Scanner(resultadosLocal);
        Scanner lector2 = new Scanner(pronosticoLocal);


        lector.useDelimiter("[;\\n\\r]+");
        lector2.useDelimiter("[;\\n\\r]+");

        while(lector.hasNextInt()){
            int nroPartido = lector.nextInt();
            int nroFase = lector.nextInt();
            String local = lector.next();
            if (local.equals("") || local.equals(" ")) local = lector.next();
            String visitante = lector.next();
            int golesLocal = lector.nextInt();
            int golesVisitante = lector.nextInt();

            partido = new Partido(nroFase,nroPartido , local, visitante,golesLocal, golesVisitante);

            fase.agregarPartido(partido);
        }
        while(lector2.hasNext()){
            String nombreApostador = lector2.next();
            if (nombreApostador.equals("") || nombreApostador.equals(" ")) nombreApostador = lector2.next();
            int nroPartido = lector2.nextInt();
            int nroFaseApuesta = lector2.nextInt();
            String equipoLocal = lector2.next();
            if (equipoLocal.equals("") || equipoLocal.equals(" ")) equipoLocal = lector2.next();
            String equipoVisitante = lector2.next();
            int apuesta = lector2.nextInt();

            jugada = new Apuesta(nombreApostador, equipoLocal,equipoVisitante,apuesta,nroPartido);

            prode.agregarApuesta(jugada);

            prode.calcularPuntaje(jugada,  fase.getPartidos());

        }

        for(Map.Entry<String, Integer> entry : prode.getParticipantes().entrySet()){
            String nombre = entry.getKey();
            int puntos = entry.getValue();
            System.out.println(nombre + " saco " + puntos + " puntos");
        }
    }
}
