package Prode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        LectorDeDatos lector = new LectorDeDatos();

        lector.leerPartidos("resultadosMundial2.csv");

        lector.leerApuestas("pronosticosMundial.csv");

        lector.calcularPuntaje();

        lector.informar();
    }
}
