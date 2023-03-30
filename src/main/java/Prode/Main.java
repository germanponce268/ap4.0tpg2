package Prode;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
        static Fase fase = new Fase();
        static TargetaProde prode = new TargetaProde();
        static Apuesta jugada = new Apuesta() ;
        static Persona jugador = new Persona("Juan", "Perez");
        static int nro = 0;
    public static void main(String[] args) throws IOException {
        Path archivoResultados = Paths.get("src/resultados.txt");
        Path archivoPronostioco = Paths.get("src/pronostico.txt");

        Scanner lector = new Scanner(archivoResultados);
        Scanner lector2 = new Scanner(archivoPronostioco);


        lector.useDelimiter("[;|\\r|\\n|]");
        lector2.useDelimiter("[,|\\r|\\n|]");

        while(lector.hasNext()){

            //se leen los valores de resultados y se almacenan en variables
        String local = lector.next();
        if(local.equals("")||local.equals(" ")) local = lector.next();
        String visitante = lector.next();
        int golesLocal = lector.nextInt();
        int golesVisitante = lector.nextInt();

        //se instancia clase Partido asignando los valores por contructor
        nro++;
        Partido partido = new Partido(nro, new Equipo(local), new Equipo(visitante), golesLocal, golesVisitante, fase.calcularResultado(golesLocal,golesVisitante));

        //se almacena el partido en una coleccion de tipo HashMap a traves del metodo agregarPartido()
        fase.agregarPartido(partido.getNro(), partido);

        //se leen y almacenan en variables los valores de la apuesta
        String equipo1 = lector2.next();
            if(equipo1.equals("")||local.equals(" ")) equipo1 = lector2.next();
        String equipo2 = lector2.next();
        int apuesta = lector2.nextInt();

        //se caulcula el equipo apostado
        jugada = new Apuesta(jugada.calcularEquipoApostado(apuesta, equipo1, equipo2),apuesta);

        //se agrega la jugada al ArrayList de jugadas
        prode.agregarApuesta(jugada);
        }

        //se calcula el puntaje de la apuesta realizada
        prode.calcularPuntaje(fase.getPartidos().values());
        jugador.setTargetaProde(prode);

        System.out.println("El jugador " + jugador.getNombre()  + " saco " + prode.getPuntos()+ " puntos!!");

        JOptionPane.showMessageDialog(null,"El jugador" + jugador.getNombre() + " saco " + prode.getPuntos()+ " puntos!") ;
    }
}
