package Prode;

public class Apuesta {
    private String nombreParticipante;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer apuesta;
    private Integer nroPartido;

    public Apuesta() {
    }

    public Apuesta(String nombreParticipante, String equipoLocal, String equipoVisitante, Integer apuesta, Integer nroPartido) {
        this.nombreParticipante = nombreParticipante;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.apuesta = apuesta;
        this.nroPartido = nroPartido;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }


    public String getEquipoLocal() {
        return equipoLocal;
    }


    public String getEquipoVisitante() {
        return equipoVisitante;
    }


    public Integer getApuesta() {
        return apuesta;
    }

    public Integer getNroPartido() {
        return nroPartido;
    }

}