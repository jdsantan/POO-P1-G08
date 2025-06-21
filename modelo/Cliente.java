package modelo;

public class Cliente {
    private String id;
    private String nombre,direccion;
    private int telefono;
    private boolean tipoCliente;
    public Cliente(String id, String nombre,String direccion,int telefono,boolean tipoCliente){
        this.id = id;
        this.nombre= nombre;
        this.direccion= direccion;
        this.telefono=telefono;
        this.tipoCliente=tipoCliente;

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
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion= direccion;
    }
    public boolean getTipoCliente(){
        return tipoCliente;
    }
    public void setTipoCliente(boolean tipoCliente){
        this.tipoCliente= tipoCliente;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
    this.telefono= telefono;
    }
    
    

}
