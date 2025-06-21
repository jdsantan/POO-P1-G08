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
            if(i.getNombre().equalsIgnoreCase(provedor.getNombre())){
                return "Cliente ya existe";
            }
        }
        lista.add(provedor);
        return "Provedor agregado satisfactoriamente";
    }

}
