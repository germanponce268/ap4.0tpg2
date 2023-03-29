package Prode;

public class Partido {
    private Integer nro;
   private Equipo local;
   private Equipo visitante;

   private Integer golesLocal;
   private Integer golesVisitante;
    private Integer resultado;

    public Partido() {
    }

    public Partido(Integer nro, Equipo local, Equipo visitante, Integer golesLocal, Integer golesVisitante, Integer resultado) {
        this.nro = nro;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.resultado = resultado;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "nro=" + nro +
                ", local=" + local +
                ", visitante=" + visitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", resultado=" + resultado +
                '}';
    }
}
