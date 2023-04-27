package Prode;

import java.util.ArrayList;

public class Fases {
    private ArrayList<Partido> partidos;


    public Fases() {

        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

}