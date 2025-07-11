package controlador;

import java.util.ArrayList;
import modelo.Provedor;

public class ControladorProvedor {
    private ArrayList<Provedor> listaProvedores;
    public ControladorProvedor(){
        listaProvedores = new ArrayList<>();
    }

    public String agregarProvedor(Provedor provedor){
        for(Provedor i : listaProvedores){
            if(i.getId().equalsIgnoreCase(provedor.getId())){
                System.out.println(i);
                return "Provedor ya existe";
            }
        }
        listaProvedores.add(provedor);
        for(Provedor p: listaProvedores){
            System.out.println(p);
        }
        return "Provedor agregado satisfactoriamente";
    }
    
    public ArrayList<Provedor> getListaProvedores(){
        return listaProvedores;
    }

    public boolean crearOrden(){
        return true;
    }
}
