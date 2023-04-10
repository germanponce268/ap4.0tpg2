package Prode;

public class Apuesta {
    private String nombreEquipoApostado;
    private Integer apuesta;

    public Apuesta() {
    }

    public Apuesta(String equipoApostado, Integer apuesta) {
        this.nombreEquipoApostado = equipoApostado;
        this.apuesta = apuesta;
    }

    public String getNombreEquipoApostado() {
        return nombreEquipoApostado;
    }

    public void setNombreEquipoApostado(String nombreEquipoApostado) {
        this.nombreEquipoApostado = nombreEquipoApostado;
    }

    public Integer getApuesta() {
        return apuesta;
    }

    public void setApuesta(Integer apuesta) {
        this.apuesta = apuesta;
    }
    public String calcularEquipoApostado(Integer apuesta, String equipo1, String equipo2){
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
