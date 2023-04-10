package Prode;

public class Persona {
    private String nombre;
    private String apellido;
    private TargetaProde targetaProde;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public TargetaProde getTargetaProde() {
        return targetaProde;
    }

    public void setTargetaProde(TargetaProde targetaProde) {
        this.targetaProde = targetaProde;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
