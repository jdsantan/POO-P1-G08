package modelo;

import java.util.ArrayList;

public class FacturaEmpresa extends ClienteEmpresarial {
    private int mes;
    private int año;
    private ArrayList<OrdenServicio> ordenes;
    private double totalServicios;
    private static final double COSTO_PRIORIDAD = 50.0;

    
    public FacturaEmpresa(ClienteEmpresarial cliente, int mes, int año) {
        super(cliente.getId(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(), true, cliente.getNombreEmpresa(), cliente.getCodigoEmpresa());
        this.mes = mes;
        this.año = año;
        this.ordenes = new ArrayList<>();
        this.totalServicios = 0.0;
    }
    public void agregarOrden(OrdenServicio orden) {
        ordenes.add(orden);
        totalServicios += orden.getTotal();
    }

    public double getTotalFactura() {
        return totalServicios + COSTO_PRIORIDAD;
    }

    // Getters y setters
    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    public double getTotalServicios() {
        return totalServicios;
    }

    public static double getCostoPrioridad() {
        return COSTO_PRIORIDAD;
    }

    public String getNombreMes() {
        String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                         "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes];
    }

    @Override
    public String toString() {
        return "FacturasEmpresas [" + super.toString() + ", mes=" + mes + ", año=" + año + 
               ", totalServicios=" + totalServicios + "]";
    }
}
