package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteEmpresarial;
import modelo.Persona;

public class ControladorCliente {
    private ArrayList<Persona> lista;
    
    public ControladorCliente(ArrayList<Persona> lista){ // Se recibe la lista
        this.lista = lista; // Se asigna la lista recibida
    }


    public String agregarCliente(Cliente CLnuevo){
        for(Persona p : lista){
            if(p instanceof Cliente){
                Cliente c = (Cliente)p;
                if(c.getId().equalsIgnoreCase(CLnuevo.getId())){
                        System.out.printf("   %s | %s | %s | %s | %s%n",
                        c.getId(), c.getNombre(),
                        c.getTelefono(), c.getDireccion(),c.getTipoCliente());
                return ">>Usuario ya existe";
                }
            }
        }
        lista.add(CLnuevo);
        
        for(Persona p: lista){
            if(p instanceof Cliente){
                Cliente c1 = (Cliente)p;
                        System.out.printf("   %s | %s | %s | %s | %s%n",
                        c1.getId(), c1.getNombre(),
                        c1.getTelefono(), c1.getDireccion(),c1.getTipoCliente());
            }

        }
        return "Cliente agregado satisfactoriamente";

    }
 public ClienteEmpresarial buscarClienteEmpresarial(String codigoEmpresa) {
    for (Persona p : lista) {
        if (p instanceof ClienteEmpresarial) {
            ClienteEmpresarial ce = (ClienteEmpresarial)p;
            if (ce.getCodigoEmpresa().equalsIgnoreCase(codigoEmpresa)) {
                return ce;
            }
        }
    }
    return null;
}
    

    public Cliente buscarCliente(String id){
        for(Persona p: lista){
            if(p instanceof Cliente){
                Cliente c = (Cliente)p;
                if(id.equalsIgnoreCase(c.getId())){
                return c;
                }
            }
        }
        return null;
    } 

    public ArrayList<Persona> getListaCliente(){
        return lista;
    } 
}
