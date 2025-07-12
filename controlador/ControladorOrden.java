package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.OrdenServicio;
import modelo.Tecnico;
import modelo.Vehiculo;

public class ControladorOrden {
    private ArrayList<OrdenServicio> listaOrden;

    public ControladorOrden() {
        listaOrden = new ArrayList<>();
    }
    public OrdenServicio crearOrden(Cliente cliente, Vehiculo vehiculo,LocalDate fecha,Tecnico tecnico){
        OrdenServicio nueva = new OrdenServicio(cliente,vehiculo,tecnico,fecha);
        listaOrden.add(nueva);
        return nueva;
    }
    public void mostrarTodasOrdenes(){
        for(OrdenServicio o : listaOrden){
            System.out.println(o);
        }
    }
    public ArrayList<OrdenServicio> getListaOrdenes(){
        return listaOrden;
    }
}
