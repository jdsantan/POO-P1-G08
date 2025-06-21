package modelo;
import java.util.ArrayList;


public class ClienteEmpresarial {
 ArrayList<Detalledelservicio> lista;
 private Boolean esEmpresa;

    public ClienteEmpresarial(Boolean esEmpresa) {
        this.esEmpresa = esEmpresa;
        this.lista = new ArrayList<>();
    }

    public Boolean getEsEmpresa() {
        return esEmpresa;
    }
    public void setEsEmpresa(Boolean esEmpresa) {
        this.esEmpresa = esEmpresa;
    }
    public ArrayList<Detalledelservicio> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Detalledelservicio> lista) {
        this.lista = lista;
    }

}
