package Prode;

import lombok.Data;

@Data
public class Apuesta {
    private String nombreApostador;
    private Integer nroPartido;
    private Integer nroFaseApuesta;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer apuesta;

    /*public Apuesta(String nombreApostador, int equipoLocal, int equipoVisitante, String nroPartido, String apuesta, int nroFaseApuesta) {
    }
*/
    public Apuesta(String nombreApostador, Integer nroPartido,Integer nroFaseApuesta, String equipoLocal, String equipoVisitante,Integer apuesta) {
        this.nombreApostador = nombreApostador;
        this.nroPartido = nroPartido;
        this.nroFaseApuesta = nroFaseApuesta;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.apuesta = apuesta;

    }


    /*public Apuesta(String nombreApostador, Integer nroPartido, Integer nroFaseApuesta, String equipoLocal, String equipoVisitante, Integer apuesta) {
    }*/
}