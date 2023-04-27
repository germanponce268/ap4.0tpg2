package Prode;

public class Partido {
   private Integer nroFase;
   private Integer nroPartido;
   private String local;
   private String visitante;
   private Integer golesLocal;
   private Integer golesVisitante;
   private Integer resultado;

    public Partido() {
    }
    public Partido(Integer nroFase,Integer nroPartido, String local, String visitante, int golesLocal, int golesVisitante) {
        this.nroPartido = nroPartido;
        this.nroFase = nroFase;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.resultado = obtenerResultado(golesLocal, golesVisitante);
    }
    private Integer obtenerResultado(Integer golesLocal, Integer golesVisitante) {
        if(golesLocal > golesVisitante){
            return 1;
        }else if(golesLocal == golesVisitante){
            return 2;
        }else{
            return 3;
        }
    }

    public void setNro(Integer nro) {
        this.nroPartido = nro;
    }
    public Integer getResultado() {
        return resultado;
    }
    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getVisitante() {
        return visitante;
    }
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    public Integer getNroFase() {
        return nroFase;
    }
    public void setNroFase(Integer nroFase) {
        this.nroFase = nroFase;
    }
    public Integer getNroPartido() {
        return nroPartido;
    }
    public void setNroPartido(Integer nroPartido) {
        this.nroPartido = nroPartido;
    }
    public Integer getGolesLocal() {
        return golesLocal;
    }
    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }
    public Integer getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "nro=" + nroPartido +
                ", local=" + local +
                ", visitante=" + visitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", resultado=" + resultado +
                '}';
    }
}
