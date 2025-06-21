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
            if(a.getNombre().equalsIgnoreCase(CLnuevo.getNombre())){
                return "Usuario ya existe";
            }
        }
        listaCliente.add(CLnuevo);
        return "Cliente agregado satisfactoriamente";
    }  

    
}
