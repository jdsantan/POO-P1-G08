package controlador;

import java.util.ArrayList;
import modelo.Tecnico;

public class ControladorTecnico {
ArrayList<Tecnico>lista;
    public ControladorTecnico(ArrayList<Tecnico>lista){
        this.lista = lista;
    }

    public String agregarTecnico(Tecnico tecnico){
        for(Tecnico i : lista){
            if(i.getNombre().equalsIgnoreCase(tecnico.getNombre())){
                return "Tecnico ya existe";
            }
        }
        lista.add(tecnico);
        return "Tecnico agregado satisfactoriamente";
    }

public String eliminarTecnico(String cedula){
        for(Tecnico i : lista){
            if(i.getCedula().equalsIgnoreCase(cedula)){
                lista.remove(i);
                return "Tecnico eliminado satisfactoriamente";
            }
        }
        return "Tecnico no encontrado";
    }
  public Tecnico buscarTecnico(String cedula) {
        for (Tecnico t : lista) {
            if (t.getCedula().equalsIgnoreCase(cedula)) {
                return t;
            }
        }
        return null;
    }
    
  public ArrayList<Tecnico> getListaTecnicos() {
        return lista;
    }
}
