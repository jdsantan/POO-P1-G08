package controlador;

import java.util.ArrayList;

import modelo.Cliente;

public class ControladorCliente {
    private ArrayList<Cliente> listaCliente;
    public ControladorCliente(){
        listaCliente = new ArrayList<>();
    }


    public String agregarCliente(Cliente CLnuevo){
        for(Cliente a : listaCliente){
            if(a.getId().equalsIgnoreCase(CLnuevo.getId())){
                return "Usuario ya existe";
            }
        }
        listaCliente.add(CLnuevo);
        return "Cliente agregado satisfactoriamente";
    }
    public Cliente buscarCliente(String id){
        for(Cliente c: listaCliente){
            if(id.equalsIgnoreCase(c.getId())){
                return c;
            }
        }
        return null;
    } 
}
