package Prode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TargetaProde {
    private ArrayList<Apuesta> apuestas;
    private HashMap<String, Integer> participantes;
    private Integer puntosGanados;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
        this.puntosGanados = 0;
        this.participantes = new HashMap<>();
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
    public void calcularPuntaje(ArrayList<Partido> ronda, String nombreApostador){
        for(Apuesta apuesta : this.apuestas){
            if(apuesta.getNroApuesta() <= ronda.get(ronda.size()-1).getNro()){
                if(apuesta.getNroApuesta().equals(ronda.get(ronda.size()-1).getNro()))
                    if(apuesta.getApuesta().equals(ronda.get(ronda.size()-1).getResultado())){
                        this.puntosGanados = 1;
                        Integer puntajeAnterior = this.participantes.get(nombreApostador);
                          if(this.participantes.get(nombreApostador) != null){
                              this.participantes.put(nombreApostador, this.puntosGanados + puntajeAnterior);
                          }else{
                            this.participantes.put(nombreApostador, this.puntosGanados);
                         }
                }
            }else{
                break;
            }
        }
    }

    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(HashMap<String, Integer> participantes) {
        this.participantes = participantes;
    }

    public Integer getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(Integer puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public void setPuntos(Integer puntos) {
        this.puntosGanados = puntos;
    }
}
