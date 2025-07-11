package controlador;

import java.util.ArrayList;

import modelo.Cliente;

public class ControladorCliente {
    private ArrayList<Cliente> listaCliente;
    
    public ControladorCliente(ArrayList<Cliente> listaInicialClientes){ // Se recibe la lista
        this.listaCliente = listaInicialClientes; // Se asigna la lista recibida
    }


    public String agregarCliente(Cliente CLnuevo){
        for(Cliente a : listaCliente){
            if(a.getId().equalsIgnoreCase(CLnuevo.getId())){
                System.out.println(a);
                return "Usuario ya existe";
            }
        }
        listaCliente.add(CLnuevo);
        
        for(Cliente c1: listaCliente){
            System.out.println(c1);
        }
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
