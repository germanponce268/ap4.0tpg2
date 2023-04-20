package Prode;

import lombok.Data;

@Data
public class Apuesta {

    private Integer fase;
    private Integer nroApuesta;
    private Integer nroPartido;
    private String nombreEquipoApostado;
    private Integer apuesta;
    private String nombreApostador;

    public Apuesta() {
    }

    public Apuesta(String local, String visitante, Integer apuesta, Integer nroApuesta, Integer nroPartido, String nombreApostador, Integer fase) {
        this.nombreEquipoApostado = calcularEquipoApostado(apuesta, local,visitante);
        this.apuesta = apuesta;
        this.nroApuesta = nroApuesta;
        this.nroPartido = nroPartido;
        this.nombreApostador = nombreApostador;
        this.fase = fase;
    }

     private String calcularEquipoApostado(Integer apuesta, String equipo1, String equipo2){
        switch (apuesta){
            case 1:
                return this.nombreEquipoApostado = new String(equipo1);
            case 2:
                 return this.nombreEquipoApostado = new String("EMPATE");
            case 3:
                return this.nombreEquipoApostado = new String(equipo2);
            default:
                return null;

        }
    }

    @Override
    public String toString() {
        return "Apuesta{" +
                "equipoApostado=" + nombreEquipoApostado +
                ", apuesta=" + apuesta +
                '}';
    }
}
