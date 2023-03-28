package Prode;

public class Apuesta {
    private Equipo equipoApostado;;
    private Integer apuesta;

    public Apuesta() {
    }

    public Apuesta(Equipo equipoApostado, Integer apuesta) {
        this.equipoApostado = equipoApostado;
        this.apuesta = apuesta;
    }

    public Equipo getEquipoApostado() {
        return equipoApostado;
    }

    public void setEquipoApostado(Equipo equipoApostado) {
        this.equipoApostado = equipoApostado;
    }

    public Integer getApuesta() {
        return apuesta;
    }

    public void setApuesta(Integer apuesta) {
        this.apuesta = apuesta;
    }
    public Equipo calcularEquipoApostado(Integer apuesta, String equipo1, String equipo2){
        if(apuesta > 2)
            return this.equipoApostado = new Equipo(equipo2);
        else if(apuesta < 2)
            return this.equipoApostado = new Equipo(equipo1);
        else
            return this.equipoApostado = new Equipo("EMPATE");
    }

    @Override
    public String toString() {
        return "Apuesta{" +
                "equipoApostado=" + equipoApostado +
                ", apuesta=" + apuesta +
                '}';
    }
}
