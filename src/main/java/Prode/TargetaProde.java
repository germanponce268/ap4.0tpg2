package Prode;

import java.util.*;

public class TargetaProde {
    private HashMap<String, Integer> participantes;
    private ArrayList<Apuesta> apuestas;
    private Integer puntosGanados;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
        this.puntosGanados = 0;
        this.participantes = new HashMap<>();
    }

    public void agregarApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
    }
    public void calcularPuntaje(Apuesta apuesta, ArrayList<Partido> partidos){
        for(Partido partido : partidos){
            if(apuesta.getNroPartido().equals(partido.getNroPartido())){
                if(apuesta.getApuesta().equals(partidos.get(partidos.size()-1).getResultado())){
                this.puntosGanados = 1;
                Integer ultimoPuntaje = this.participantes.get(apuesta.getNombreParticipante());
                if(ultimoPuntaje == null){
                    this.participantes.put(apuesta.getNombreParticipante(), this.puntosGanados);
                }else{
                    this.participantes.put(apuesta.getNombreParticipante(), this.puntosGanados+ultimoPuntaje);
                    }
                }
            }
        }
    }
    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
}
