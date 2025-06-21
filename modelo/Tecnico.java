package modelo;

public class Tecnico {
    private String cedula, nombre, telefono, especialidad;
    public Tecnico(String cedula, String nombre, String telefono, String especialidad) {
        this.cedula       = cedula;
        this.nombre       = nombre;
        this.telefono     = telefono;
        this.especialidad = especialidad;
    }
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public void   setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void   setTelefono(String telefono) { this.telefono = telefono; }
    public String getEspecialidad() { return especialidad; }
    public void   setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    @Override
    public String toString() {
        return cedula + " | " + nombre + " | " + telefono + " | " + especialidad;
    }
}

