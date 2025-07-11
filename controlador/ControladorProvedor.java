package controlador;

import java.util.ArrayList;

import modelo.Persona;
import modelo.Provedor;

public class ControladorProvedor {
    private ArrayList<Persona> lista;
    public ControladorProvedor(ArrayList<Persona>lista){
        this.lista = lista;
    }

    public String agregarProvedor(Provedor provedor){
        for(Persona p : lista){
            if(p instanceof Provedor){
                Provedor i = (Provedor)p;
                if(i.getId().equalsIgnoreCase(provedor.getId())){
                System.out.println(i);
                return "Provedor ya existe";
                }
            }

        }
        lista.add(provedor);
        for(Persona p: lista){
            if(p instanceof Provedor){
                Provedor i = (Provedor)p;
                System.out.println(i);
            }
        }
        return "Provedor agregado satisfactoriamente";
    }
    
    public ArrayList<Persona> getListaProvedores(){
        return lista;
    }

    public boolean crearOrden(){
        return true;
    }
}
