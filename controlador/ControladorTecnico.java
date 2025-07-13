package controlador;

import java.util.ArrayList;

import modelo.Persona;
import modelo.Tecnico;

public class ControladorTecnico {
    ArrayList<Persona>lista;
    public ControladorTecnico(ArrayList<Persona>lista){
        this.lista = lista;
    }

    public String agregarTecnico(Tecnico tecnico){
        for(Persona p : lista){
            if(p instanceof Tecnico){
                Tecnico i = (Tecnico)p;
                if(i.getId().equalsIgnoreCase(tecnico.getId())){
                    
                return "Tecnico ya existe";
                }
            }

        }
        lista.add(tecnico);
        
        return "Tecnico agregado satisfactoriamente";
    }

public String eliminarTecnico(String cedula){
        for(Persona p : lista){
            if(p instanceof Tecnico){
                Tecnico i = (Tecnico)p;
                if(i.getId().equalsIgnoreCase(cedula)){
                lista.remove(i);
                return "Tecnico eliminado satisfactoriamente";
                }
            }
        }
        return "Tecnico no encontrado";
    }
  public Tecnico buscarTecnico(String cedula) {
        for (Persona p : lista) {
            if(p instanceof Tecnico){
                Tecnico t = (Tecnico)p;
                if (t.getId().equalsIgnoreCase(cedula)) {
                return t;
                }
            }
        }
        return null;
    }
    
  public ArrayList<Persona> getListaTecnicos() {
        return lista;
    }
}
