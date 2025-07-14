package controlador;

import java.util.ArrayList;
import modelo.Persona;
import modelo.Proveedor;

public class ControladorProveedor {
    private ArrayList<Persona> lista;
    public ControladorProveedor(ArrayList<Persona> lista){
        this.lista = lista;
    }

    public String agregarProveedor(Proveedor proveedor){
        for(Persona p : lista){
            if(p instanceof Proveedor){
                Proveedor i = (Proveedor)p;
                if(i.getId().equalsIgnoreCase(proveedor.getId())){
                        System.out.printf("   %s | %s | %s | %s%n",
                        i.getId(), i.getNombre(),
                        i.getTelefono(), i.getDescripcion());
                return "Provedor ya existe";
                }
            }

        }
        lista.add(proveedor);
        for(Persona p: lista){
            if(p instanceof Proveedor){
                Proveedor i = (Proveedor)p;
                        System.out.printf("   %s | %s | %s | %s%n",
                        i.getId(), i.getNombre(),
                        i.getTelefono(), i.getDescripcion());
            }
        }
        return "Proveedor agregado satisfactoriamente";
    }
    
    public ArrayList<Persona> getListaProveedores(){
        return lista;
    }

    public boolean crearOrden(){
        return true;
    }
}
