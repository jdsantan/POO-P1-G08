package modelo;

public class Provedor {
    private String id,nombre,descripcion;
    private String telefono;
    public Provedor(String id, String nombre, String telefono, String descripcion){
        this.id = id;
        this.nombre= nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDireccion(String descripcion){
        this.descripcion= descripcion;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
    this.telefono= telefono;
    }
    
}
