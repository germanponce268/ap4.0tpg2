package Prode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Fase {
    private ArrayList<Partido> partidos;

    public Fase() {
        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }


    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

}
