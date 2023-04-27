package Prode;

import java.util.*;
import java.util.stream.Collectors;

public class Competicion {
    private HashMap<String, Integer> participantes;
    private ArrayList<Apuesta> apuestas;
    private Integer puntosGanados;

    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }
    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
    public Competicion() {
        this.apuestas = new ArrayList<>();
        this.puntosGanados = 0;
        this.participantes = new HashMap<>();
    }
        public void agregarApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
    }
        public void calcularPuntaje(ArrayList<Apuesta> apuestas, ArrayList<Partido> partidos) {
        for (Apuesta apuesta : apuestas) {
            for (Partido partido : partidos) {
                if (apuesta.getNroPartido().equals(partido.getNroPartido())) {
                    if (apuesta.getApuesta().equals(partido.getResultado())) {
                        actualizarPuntaje(apuesta.getNombreApostador(), 1);
                    }
                }
            }
        }
    }
        public void actualizarPuntaje(String nombreParticipante, int puntosGanados) {
        Integer ultimoPuntaje = participantes.get(nombreParticipante);
        if (ultimoPuntaje == null) {
            participantes.put(nombreParticipante, puntosGanados);
        } else {
            participantes.put(nombreParticipante, puntosGanados + ultimoPuntaje);
        }
    }
    public void fasesyganador(ArrayList<Apuesta> apuestas, ArrayList<Partido> partidos){
        // inicializar el mapa de participantes con puntajes en cero para todas las fases
        Map<String, Map<Integer, Integer>> puntajesPorFase = new HashMap<>();
        for (String participante : this.participantes.keySet()) {
            puntajesPorFase.put(participante, new HashMap<>());
        }
        // iterar sobre todas las apuestas
        for (Apuesta apuesta : apuestas) {
            // filtrar los partidos por fase y número de partido
            List<Partido> partidosFase = partidos.stream()
                    .filter(p -> p.getNroFase().equals(apuesta.getNroFaseApuesta()) && p.getNroPartido().equals(apuesta.getNroPartido()))
                    .collect(Collectors.toList());
            // verificar si hay un partido que cumple las condiciones de la apuesta
            Optional<Partido> partidoGanado = partidosFase.stream()
                    .filter(p -> p.getResultado().equals(apuesta.getApuesta()))
                    .findFirst();
            // si se encontró un partido ganado, actualizar el puntaje del participante correspondiente
            if (partidoGanado.isPresent()) {
                String participante = apuesta.getNombreApostador();
                Integer fase = apuesta.getNroFaseApuesta();
                Integer ultimoPuntaje = puntajesPorFase.get(participante).getOrDefault(fase, 0);
                puntajesPorFase.get(participante).put(fase, ultimoPuntaje + 1);
            }
        }
        // imprimir los puntajes por participante y fase
        for (String participante : this.participantes.keySet()) {
            System.out.println("Puntajes de " + participante + " por fase:");
            Map<Integer, Integer> puntajesPorFaseDelParticipante = puntajesPorFase.get(participante);
            for (Integer fase : puntajesPorFaseDelParticipante.keySet()) {
                System.out.println("  Fase " + fase + ": " + puntajesPorFaseDelParticipante.get(fase));
            }
        }
        // encontrar al participante con mayor puntaje total
        String mejorParticipante = "";
        int mejorPuntaje = -1;
        for (String participante : this.participantes.keySet()) {
            int puntajeTotal = puntajesPorFase.get(participante).values().stream().mapToInt(Integer::intValue).sum();
            if (puntajeTotal > mejorPuntaje) {
                mejorParticipante = participante;
                mejorPuntaje = puntajeTotal;
            }
        }
        System.out.println("El participante con mayor puntaje total es " + mejorParticipante + " con " + mejorPuntaje + " puntos.");
    }


        /*public void mostrarPuntajes() {
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
        }*/

}
