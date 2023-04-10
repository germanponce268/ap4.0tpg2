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

        Path resultadosLocal = Paths.get("src/resultados2.txt");
        Path pronosticoLocal = Paths.get("apuestas3.csv");


        Scanner lector = new Scanner(resultadosLocal);
        Scanner lector2 = new Scanner(pronosticoLocal);


        lector.useDelimiter("[,|\\r|\\n]");
        lector2.useDelimiter("[,\\r|\\n|]");

        while(lector2.hasNext()){
            if(lector.hasNext()){
                String nroFase = lector.next();
                if (nroFase.equals("") || nroFase.equals(" ")) nroFase = lector.next();
                int nroPartido = lector.nextInt();
                String local = lector.next();
                if (local.equals("") || local.equals(" ")) local = lector.next();
                String visitante = lector.next();
                int golesLocal = lector.nextInt();
                int golesVisitante = lector.nextInt();

                partido = new Partido(Integer.parseInt(nroFase),nroPartido, local, visitante, golesLocal, golesVisitante);

                fase.agregarPartido(partido);
            }
            String nombreApostador = lector2.next();
            if (nombreApostador.equals("") || nombreApostador.equals(" ")) nombreApostador = lector2.next();
            int nroFaseApuesta = lector2.nextInt();
            int nroPartidoApuesta = lector2.nextInt();
            String equipoLocalApuesta = lector2.next();
            if (equipoLocalApuesta.equals("") || equipoLocalApuesta.equals(" ")) equipoLocalApuesta = lector2.next();
            String equipoVisitanteApuesta = lector2.next();
            int apuesta = lector2.nextInt();

            jugada = new Apuesta(equipoLocalApuesta,equipoVisitanteApuesta,apuesta,nroPartidoApuesta);

            prode.agregarApuesta(jugada);
            prode.calcularPuntaje(fase.getPartidos(), nombreApostador);
            System.out.println(nroPartidoApuesta);
        }

        for(Map.Entry<String, Integer> entry : prode.getParticipantes().entrySet()){
            String nombre = entry.getKey();
            int puntos = entry.getValue();
            System.out.println(nombre + " saco " + puntos);
        }

        System.out.println("Anda " + fase.getPartidos().size() + " " + prode.getApuestas().size());
    }
}
