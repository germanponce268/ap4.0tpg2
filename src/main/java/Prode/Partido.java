package Prode;

public class Partido {
    private Integer nro;
   private String local;
   private String visitante;

   private Integer golesLocal;
   private Integer golesVisitante;
    private Integer resultado;

    public Partido() {
    }

    public Partido(Integer nro, String local, String visitante, Integer golesLocal, Integer golesVisitante) {
        this.nro = nro;
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
