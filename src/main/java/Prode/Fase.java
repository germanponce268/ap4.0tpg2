package Prode;

import java.util.Collection;
import java.util.HashMap;

public class Fase {
    private Integer nroFase;
    private HashMap<Integer,HashMap<Integer,Partido>>partidosfases;
    private HashMap<Integer, Partido> partidos;

    public Fase() {
        this.partidos = new HashMap<>();
        this.partidosfases = new HashMap<>();
    }

    public void agregarPartido(Integer fechaNro, Partido partido){
        this.partidos.put(fechaNro, partido);
    }

    public void agregarFasePartido(Integer fase, HashMap fasePartido){
        this.partidosfases.put(fase, fasePartido);
    }
    public HashMap<Integer, HashMap<Integer, Partido>> getPartidosfases() {
        return partidosfases;
    }

    public HashMap<Integer, Partido> getPartidos() {
        return partidos;
    }
    public Integer calcularResultado(Integer golesLocal, Integer golesVisitante){
        if(golesLocal > golesVisitante){
            return 1;
        } else if (golesVisitante > golesLocal) {
            return 3;
        } else  {
            return 2;
        }
    }

    public Integer getNroFase() {
        return nroFase;
    }

    public void setNroFase(Integer nroFase) {
        this.nroFase = nroFase;
    }
}
