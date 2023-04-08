package Prode;

public class Apuesta {
    private String equipoLocal;
    private String equipoVisitante;
    private Integer apuesta;
    private Integer nroPartido;

    public Apuesta() {
    }

    public Apuesta(String equipoLocal, String equipoVisitante, Integer apuesta, Integer nroPartido) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.apuesta = apuesta;
        this.nroPartido = nroPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Integer getApuesta() {
        return apuesta;
    }

    public void setApuesta(Integer apuesta) {
        this.apuesta = apuesta;
    }

    public Integer getNroPartido() {
        return nroPartido;
    }

    public void setNroPartido(Integer nroPartido) {
        this.nroPartido = nroPartido;
    }
}