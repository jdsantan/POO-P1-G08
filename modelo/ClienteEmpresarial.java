package modelo;
import java.util.ArrayList;


public class ClienteEmpresarial extends Cliente  {
 ArrayList<Detalledelservicio> lista;
 private String nombreEmpresa;
 private String codigoEmpresa;

    public ClienteEmpresarial(String id, String nombre, String telefono, String direccion, Boolean tipoCliente, String nombreEmpresa, String codigoEmpresa) {
        super(id, nombre, telefono, direccion, true);
        this.nombreEmpresa = nombreEmpresa;
        this.codigoEmpresa = codigoEmpresa;
        this.lista = new ArrayList<>();
    }

    public  ArrayList<Detalledelservicio> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Detalledelservicio> lista) {
        this.lista = lista;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    @Override
    public String toString() {
        return "ClienteEmpresarial [esEmpresa=" + getTipoCliente() + ", nombreEmpresa=" + nombreEmpresa + ", codigoEmpresa=" + codigoEmpresa + "]";
    }
}
