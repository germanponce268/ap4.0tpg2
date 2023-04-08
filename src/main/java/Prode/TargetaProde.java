package Prode;

import java.util.*;

public class TargetaProde {
    private HashMap<String, Integer> participantes;
    private ArrayList<Apuesta> apuestas;
    private Integer puntosGanados;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
        this.puntosGanados = 0;
        this.participantes = new HashMap<String, Integer>();
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
        return puntosGanados;
    }
    public void calcularPuntaje(ArrayList<Partido> partidos, String nombreApostador){
        for(Partido partido : partidos){
             if(partido.getNroPartido().equals(this.apuestas.get(this.apuestas.size()-1).getNroPartido())){
                if(partido.getResultado().equals(this.apuestas.get(this.apuestas.size()-1).getApuesta())){
                    this.puntosGanados = 1;
                    Integer puntajeAnterior = this.participantes.get(nombreApostador);
                    if(this.participantes.get(nombreApostador)!= null){
                        this.participantes.put(nombreApostador, puntajeAnterior + this.puntosGanados);
                    }else{
                        this.participantes.put(nombreApostador, this.puntosGanados);
                    }
                }
            }
        }
    }
    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(HashMap<String, Integer> participantes) {
        this.participantes = participantes;
    }

    public void setPuntos(Integer puntos) {
        this.puntosGanados = puntos;
    }
}
