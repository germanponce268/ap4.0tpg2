package Prode;

import lombok.Data;

@Data
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


    public Partido(Integer nroFase,Integer nroPartido, String local, String visitante, Integer golesLocal, Integer golesVisitante) {
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

}
