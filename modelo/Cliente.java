package modelo;

public class Cliente extends Persona{
    private String direccion;
    private Boolean tipoCliente;
    public Cliente(String id, String nombre, String telefono, String direccion, Boolean tipoCliente){
        super(id,nombre,telefono);
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
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

    @Override
    public String toString() {
        return "Cliente: "+ super.toString() +", Direccion: " + direccion +  ", Es Cliente empreserial: "+ tipoCliente;
    }

  
    }
    

