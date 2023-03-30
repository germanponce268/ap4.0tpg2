package Prode;

import java.util.ArrayList;
import java.util.Collection;

public class TargetaProde {
    private ArrayList<Apuesta> apuestas;
    private Integer puntos;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
        this.puntos = 0;
    }

    public void agregarApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Integer getPuntos() {
        return puntos;
    }
    public void calcularPuntaje(Collection<Partido> ronda){
        for(Partido partido : ronda){
            if(partido.getResultado() == this.getApuestas().get(partido.getNro()-1).getApuesta()){
                this.puntos++;
            }
        }
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
