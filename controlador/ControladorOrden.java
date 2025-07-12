package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.OrdenServicio;
import modelo.Tecnico;
import modelo.Vehiculo;

public class ControladorOrden {
    private ArrayList<OrdenServicio> lista;

    public ControladorOrden(ArrayList<OrdenServicio> lista) {
        this.lista = lista;
    }
    public OrdenServicio crearOrden(Cliente cliente, Vehiculo vehiculo,LocalDate fecha,Tecnico tecnico){
        OrdenServicio nueva = new OrdenServicio(cliente,vehiculo,tecnico,fecha);
        lista.add(nueva);
        return nueva;
    }
    public void mostrarTodasOrdenes(){
        for(OrdenServicio o : lista){
            System.out.println(o);
        }
    }
    public ArrayList<OrdenServicio> getListaOrdenes(){
        return lista;
    }
}
