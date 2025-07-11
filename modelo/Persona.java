package modelo;

public class Persona {
    private String id,nombre,telefono;

    Persona(String id, String nombre, String telefono){
        this.id = id;
        this.nombre= nombre;
        this.telefono = telefono;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return " id: " + id + ", nombre: " + nombre + ", telefono: " + telefono;
    }

}
