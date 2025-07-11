package controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;

public class ControladorFacturaEmpresa {
    private ArrayList<FacturasEmpresas> listaFacturas;
    private ArrayList<ClienteEmpresarial> listaClientesEmpresariales;
    private ControladorOrdenes controladorOrdenes;
    
    public static final double TARIFA_MENSUAL_EMPRESA = 50.0;
    
    public ControladorFacturaEmpresa(ControladorOrdenes controladorOrdenes) {
        this.listaFacturas = new ArrayList<>();
        this.listaClientesEmpresariales = new ArrayList<>();
        this.controladorOrdenes = controladorOrdenes;
        inicializarClientesEmpresariales();
    }
    
    private void inicializarClientesEmpresariales() {
        // Agregar algunos clientes empresariales de ejemplo
        listaClientesEmpresariales.add(new ClienteEmpresarial("C004", "María López", "0987654324", "Calle Real 101",true, "Grupo HG S.A", "EMP001"));
        listaClientesEmpresariales.add(new ClienteEmpresarial("C002", "Ana Gómez", "0987654322", "Av. Siempre Viva 456",true, "Transportes Unidos", "EMP002"));
    }
    
    public ClienteEmpresarial buscarClienteEmpresarial(String codigoEmpresa) {
        for (ClienteEmpresarial cliente : listaClientesEmpresariales) {
            if (cliente.getCodigoEmpresa().equalsIgnoreCase(codigoEmpresa)) {
                return cliente;
            }
        }
        return null;
    }
    
    public FacturasEmpresas generarFactura(String codigoEmpresa, int mes, int año) {
        ClienteEmpresarial cliente = buscarClienteEmpresarial(codigoEmpresa);
        if (cliente == null) {
            return null;
        }
        
        // Crear nueva factura
        FacturasEmpresas factura = new FacturasEmpresas(codigoEmpresa, cliente, LocalDate.now(), mes, año);
        
        // Buscar órdenes del período especificado
        ArrayList<OrdenServicio> ordenesPeriodo = buscarOrdenesPorPeriodo(codigoEmpresa, mes, año);
        
        // Calcular total
        double totalServicios = 0.0;
        ArrayList<Detalledelservicio> detallesFactura = new ArrayList<>();
        
        for (OrdenServicio orden : ordenesPeriodo) {
            for (Detalledelservicio detalle : orden.getDetalle()) {
                detallesFactura.add(detalle);
                totalServicios += detalle.getSubtotal();
            }
        }
        
        // Agregar tarifa mensual empresarial
        double totalFinal = totalServicios + TARIFA_MENSUAL_EMPRESA;
        
        factura.setOrdenes(detallesFactura);
        factura.setTotalPagar(totalFinal);
        
        listaFacturas.add(factura);
        return factura;
    }
    
    private ArrayList<OrdenServicio> buscarOrdenesPorPeriodo(String codigoEmpresa, int mes, int año) {
        ArrayList<OrdenServicio> ordenesPeriodo = new ArrayList<>();
        
        for (OrdenServicio orden : controladorOrdenes.getListaOrdenes()) {
            LocalDate fechaOrden = orden.getFecha();
            
            // Verificar si la orden pertenece al período y empresa
            if (fechaOrden.getMonthValue() == mes && 
                fechaOrden.getYear() == año &&
                esOrdenDeEmpresa(orden, codigoEmpresa)) {
                ordenesPeriodo.add(orden);
            }
        }
        
        return ordenesPeriodo;
    }
    
    private boolean esOrdenDeEmpresa(OrdenServicio orden, String codigoEmpresa) {
        return orden.getCliente().getId().startsWith(codigoEmpresa.substring(0, 3));
    }
    
    public ArrayList<ClienteEmpresarial> getListaClientesEmpresariales() {
        return listaClientesEmpresariales;
    }
    
    public String[] getNombresMeses() {
        return new String[]{
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
    }
}