package controlador;

import modelo.Cliente;
import modelo.OrdenServicio;
import modelo.Tecnico;
import modelo.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorOrdenes {
    private ArrayList<OrdenServicio> listaOrdenes;

    public ControladorOrdenes() {
        listaOrdenes = new ArrayList<>();
    }
    public OrdenServicio crearOrden(Cliente cliente, Vehiculo vehiculo,LocalDate fecha,Tecnico tecnico){
        OrdenServicio nueva = new OrdenServicio(cliente,vehiculo,tecnico,fecha);
        listaOrdenes.add(nueva);
        return nueva;
    }
    public void mostrarTodasOrdenes(){
        for(OrdenServicio o : listaOrdenes){
            System.out.println(o);
        }
    }
    public ArrayList<OrdenServicio> getListaOrdenes(){
        return listaOrdenes;
    }
}
