package controlador;

import java.util.ArrayList;
import modelo.Provedor;

public class ControladorProvedor {
    ArrayList<Provedor>lista;
    public ControladorProvedor(){
        lista = new ArrayList<>();
    }

    public String agregarProvedor(Provedor provedor){
        for(Provedor i : lista){
            if(i.getId().equalsIgnoreCase(provedor.getId())){
                return "Cliente ya existe";
            }
        }
        lista.add(provedor);
        return "Provedor agregado satisfactoriamente";
    }
    
    public ArrayList<Provedor> getListaProvedores(){
        return lista;
    }

    public boolean crearOrden(){
        return true;
    }
}
