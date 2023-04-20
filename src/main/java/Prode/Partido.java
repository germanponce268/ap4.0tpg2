package Prode;

import lombok.Data;

@Data
public class Partido {
    private Integer nro;
    private Integer fase;
   private String local;
   private String visitante;

   private Integer golesLocal;
   private Integer golesVisitante;
    private Integer resultado;

    public Partido() {
    }

    public Partido(Integer nro, String local, String visitante, Integer golesLocal, Integer golesVisitante,Integer fase) {
        this.nro = nro;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.resultado = obtenerResultado(golesLocal, golesVisitante);
        this.fase = fase;
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
