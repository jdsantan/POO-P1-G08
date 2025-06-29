package modelo;
import java.util.ArrayList;


public class ClienteEmpresarial   {
 ArrayList<Detalledelservicio> lista;
 private Boolean esEmpresa;
 private String nombreEmpresa;
 private String codigoEmpresa;

    public ClienteEmpresarial(Boolean esEmpresa,String nombreEmpresa, String codigoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.codigoEmpresa = codigoEmpresa;
        this.esEmpresa = esEmpresa;
        this.lista = new ArrayList<>();
    }

    public Boolean getEsEmpresa() {
        return esEmpresa;
    }
    public void setEsEmpresa(Boolean esEmpresa) {
        this.esEmpresa = esEmpresa;
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
        return "ClienteEmpresarial [esEmpresa=" + esEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", codigoEmpresa=" + codigoEmpresa + "]";
    }
}
