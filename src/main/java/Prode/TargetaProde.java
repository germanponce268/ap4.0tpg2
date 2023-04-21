package Prode;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Data
public class TargetaProde {

    private HashMap<Integer, Integer> puntosFases;
    private ArrayList<Apuesta> apuestas;
    private HashMap<String, Integer> participantes;
    private Integer contadorFases;

    public TargetaProde() {
        this.apuestas = new ArrayList<>();
        this.contadorFases = 0;
        this.participantes = new HashMap<>();
        this.puntosFases = new HashMap<>();
    }

    public void agregarApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
    }

    public void calcularPuntaje(Apuesta apuesta, ArrayList<Partido> partidos){
        Integer apuestaValor = apuesta.getApuesta();
        Integer nroFase = apuesta.getFase();
        Integer nroPartidoApuesta = apuesta.getNroPartido();
        String nombre = apuesta.getNombreApostador();
       for(Partido partido : partidos){
           Integer nroPartido = partido.getNro();
           Integer resultado = partido.getResultado();
           if(nroPartidoApuesta.equals(nroPartido)){
               if(apuestaValor.equals(resultado)){
                   
                   this.contadorFases = 1 ;
                   Integer ultimoPuntaje = this.participantes.get(nombre);
                   if(ultimoPuntaje == null){
                       this.participantes.put(apuesta.getNombreApostador(), this.contadorFases);
                   }else{
                       this.participantes.put(apuesta.getNombreApostador(), this.contadorFases + ultimoPuntaje);
                   }
               }
           }
       }
    }

    public HashMap<String, Integer> getParticipantes() {
        return participantes;
    }

}
