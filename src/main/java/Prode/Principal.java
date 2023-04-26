package Prode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        LectorDeDatos lector = new LectorDeDatos();

        lector.leerPartidos("resultadosMundial2.csv");

        lector.leerApuestas("pronosticosMundial.csv");

        //lector.leerPartidosDB();

        //lector.leerApuestasDB();

        lector.obtenerPuntaje();

        lector.informar();
    }
}
