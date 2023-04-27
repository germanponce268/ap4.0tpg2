package Prode;

import java.util.*;

public class Competicion {
    private HashMap<String, Integer> participantes;
    private ArrayList<Apuesta> apuestas;
    private Integer puntosGanados;

    public Competicion() {
        this.apuestas = new ArrayList<>();
        this.puntosGanados = 0;
        this.participantes = new HashMap<>();
    }

    public void agregarApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
    }
    public void calcularPuntaje(ArrayList<Apuesta> apuestas, ArrayList<Partido> partidos){

        for(Apuesta apuesta : apuestas){
            for(Partido partido : partidos){
                if(apuesta.getNroPartido().equals(partido.getNroPartido())){
                    if(apuesta.getApuesta().equals(partido.getResultado())){
                        this.puntosGanados = 1;
                        Integer ultimoPuntaje = this.participantes.get(apuesta.getNombreParticipante());
                        if(ultimoPuntaje == null){
                            this.participantes.put(apuesta.getNombreParticipante(), this.puntosGanados);
                        }else{
                            this.participantes.put(apuesta.getNombreParticipante(), ultimoPuntaje + this.puntosGanados);
                        }
                    }
                }
            }
        }
    }

    public void mostrarPuntajes() {
        String nombreMaximoPuntaje = null;
        int maximoPuntaje = 0;
        for (String nombreParticipante : participantes.keySet()) {
            int puntaje = participantes.get(nombreParticipante);
            if (puntaje > maximoPuntaje) {
                maximoPuntaje = puntaje;
                nombreMaximoPuntaje = nombreParticipante;
            }
        }
        System.out.println("El participante con más puntos es " + nombreMaximoPuntaje + " con " + maximoPuntaje + " puntos.");
    }
    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
}