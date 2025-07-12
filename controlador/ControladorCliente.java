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
                System.out.println(c);
                return "Usuario ya existe";
                }
            }
        }
        lista.add(CLnuevo);
        
        for(Persona p: lista){
            if(p instanceof Cliente){
                Cliente c1 = (Cliente)p;
                System.out.println(c1);
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
