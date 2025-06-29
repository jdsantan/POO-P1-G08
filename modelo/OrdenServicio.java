package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

import controlador.ControladorTecnico;
import controlador.ControladorServicio;


public class OrdenServicio {
    public static int contador =1;
    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private ArrayList<Detalledelservicio>detalle;
    private double total;
    public ControladorServicio controladorServicio = new ControladorServicio();


    public OrdenServicio(Cliente cliente, Vehiculo vehiculo, LocalDate fecha) {
        this.codigo = generarCodigo();
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.detalle = new ArrayList<>();
        this.total = 0;
    }

    private String generarCodigo(){
        return "ORD" + String.format("%03d", contador ++);
    }
    public void agregarDetalle(Servicio servicio, int cantidad) {
        Detalledelservicio ds = new Detalledelservicio(servicio,cantidad);
        detalle.add(ds);
        total += servicio.getPrecio();
    }


    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Detalledelservicio> getDetalle() {
        return detalle;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString(){
                return "Orden #" + codigo + " | Cliente: " + cliente.getNombre() +
                " | Vehículo: " + vehiculo.getPlaca() +
                " | Fecha: " + fecha +
                " | Total: $" + total;
    }

}
