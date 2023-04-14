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
    static Fase fase = new Fase();
    static Apuesta jugada = new Apuesta();
    static TargetaProde prode = new TargetaProde();
    static Partido partido = new Partido();
    public static void main(String[] args) throws IOException {

        Path resultadosLocal = Paths.get("resultadosMundial.txt");
        Path pronosticoLocal = Paths.get("pronosticosMundial.csv");


        Scanner lector = new Scanner(resultadosLocal);
        Scanner lector2 = new Scanner(pronosticoLocal);


        lector.useDelimiter("[;\\r\\n]+");
        lector2.useDelimiter("[;\\r\\n]+");

        while(lector2.hasNext()){
            if(lector.hasNext()){
                String nroPartido = lector.next();
                if (nroPartido.equals("") || nroPartido.equals(" ")) nroPartido = lector.next();
                String nroFase = lector.next();
                String local = lector.next();
                if (local.equals("") || local.equals(" ")) local = lector.next();
                String visitante = lector.next();
                String golesLocal = lector.next();
                String golesVisitante = lector.next();

                partido = new Partido(Integer.parseInt(nroPartido),Integer.parseInt(nroPartido), local, visitante, Integer.parseInt(golesLocal), Integer.parseInt(golesVisitante));

                fase.agregarPartido(partido);
            }
            String nombreApostador = lector2.next();
            if (nombreApostador.equals("") || nombreApostador.equals(" ")) nombreApostador = lector2.next();
            String nroPartido = lector2.next();
            String nroFaseApuesta = lector2.next();
            String equipoLocal = lector2.next();
            if (equipoLocal.equals("") || equipoLocal.equals(" ")) equipoLocal = lector2.next();
            String equipoVisitante = lector2.next();
            String apuesta = lector2.next();

            jugada = new Apuesta(equipoLocal,equipoVisitante,Integer.parseInt(apuesta),Integer.parseInt(nroPartido));

            prode.agregarApuesta(jugada);

            prode.calcularPuntaje(fase.getPartidos(), nombreApostador);

        }

        for(Map.Entry<String, Integer> entry : prode.getParticipantes().entrySet()){
            String nombre = entry.getKey();
            int puntos = entry.getValue();
            System.out.println(nombre + " saco " + puntos);
        }
    }
}
