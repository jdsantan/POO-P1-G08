package modelo;

public class Cliente {
    private String id,nombre,direccion;
    private String telefono;
    Boolean tipoCliente;
    public Cliente(String id, String nombre, String telefono, String direccion, Boolean tipoCliente){
        this.id = id;
        this.nombre= nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean  getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Boolean  tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
                + ", tipoCliente=" + tipoCliente + "]";
    }

  
    }
    

