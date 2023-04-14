package Prode;

public class Persona {
    private String nombre;
    private TargetaProde targetaProde;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TargetaProde getTargetaProde() {
        return targetaProde;
    }

    public void setTargetaProde(TargetaProde targetaProde) {
        this.targetaProde = targetaProde;
    }

}
