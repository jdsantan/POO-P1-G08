package controlador;

import modelo.OrdenServicio;
import java.util.ArrayList;

public class ControladorOrdenes {
    private ArrayList<OrdenServicio> listaOrdenes;

    public ControladorOrdenes() {
        listaOrdenes = new ArrayList<>();
    }

    public void agregarOrden(OrdenServicio orden) {
        listaOrdenes.add(orden);
    }

    public ArrayList<OrdenServicio> getListaOrdenes() {
        return listaOrdenes;
    }

    public 
}
