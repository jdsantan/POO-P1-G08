package controlador;

import java.util.ArrayList;
import modelo.Provedor;

public class ControladorProvedor {
    ArrayList<Provedor>lista;
    public ControladorProvedor(ArrayList<Provedor>lista){
        this.lista = lista;
    }

    public String agregarProvedor(Provedor provedor){
        for(Provedor i : lista){
            if(i.getId().equalsIgnoreCase(provedor.getId())){
                System.out.println(i);
                return "Provedor ya existe";
            }
        }
        lista.add(provedor);
        for(Provedor p: lista){
            System.out.println(p);
        }
        return "Provedor agregado satisfactoriamente";
    }
    
    public ArrayList<Provedor> getListaProvedores(){
        return lista;
    }

    public boolean crearOrden(){
        return true;
    }
}
