package Prode;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        static Fase fase = new Fase();
        static TargetaProde prode = new TargetaProde();
        static Apuesta jugada = new Apuesta() ;
        static Persona jugador = new Persona("Jose", "Perez");
    public static void main(String[] args) throws IOException {
        Path resultadosMundial = Paths.get("partidosmundial2.csv");
        Path pronosticosMundial = Paths.get("pronosticosMundial.csv");

        Scanner lector = new Scanner(resultadosMundial);
        Scanner lector2 = new Scanner(pronosticosMundial);


        lector.useDelimiter("[;|\\r|\\n]");
        lector2.useDelimiter("[;\\r|\\n|]");

        while(lector.hasNext()){


        String nroPartido = lector.next();
        if(nroPartido.equals("") || nroPartido.equals(" ")) nroPartido = lector.next();
        int nroFase = lector.nextInt();
        String local = lector.next();
        if(local.equals("")||local.equals(" ")) local = lector.next();
        String visitante = lector.next();
        int golesLocal = lector.nextInt();
        int golesVisitante = lector.nextInt();

        Partido partido = new Partido(Integer.parseInt(nroPartido),local,visitante,golesLocal, golesVisitante);

        fase.agregarPartido(partido);

        String fecha = lector2.next();
        if(fecha.equals("") || fecha.equals(" ")) fecha = lector2.next();
        int ronda = lector2.nextInt();
        String equipo1 = lector2.next();
        if(equipo1.equals("")||local.equals(" ")) equipo1 = lector2.next();
        String equipo2 = lector2.next();
        int apuesta = lector2.nextInt();

        jugada = new Apuesta(jugada.calcularEquipoApostado(apuesta, equipo1, equipo2),apuesta);

        prode.agregarApuesta(jugada);
        }

        prode.calcularPuntaje(fase.getPartidos());
        jugador.setTargetaProde(prode);

        System.out.println("El jugador " + jugador.getNombre()  + " saco " + prode.getPuntos()+ " puntos!!");

        JOptionPane.showMessageDialog(null,"El jugador" + jugador.getNombre() + " saco " + prode.getPuntos()+ " puntos!") ;
    }


}
