package Prode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Fase {
    private ArrayList<Partido> partidos;

    private HashMap<Integer, ArrayList<Partido>> fases;



    public Fase() {
        this.partidos = new ArrayList<>();
        this.fases= new HashMap<>();
    }

    public void agregarPartido(Partido partido){
            this.partidos.add(partido);
            this.fases.put(partido.getFase(), this.partidos);
    }


    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

}
