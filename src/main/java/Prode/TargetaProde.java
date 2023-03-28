package Prode;

import java.util.ArrayList;

public class TargetaProde {
    private ArrayList<Apuesta> apuestas;
    private Integer puntos;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
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

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
