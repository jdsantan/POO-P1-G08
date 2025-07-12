package controlador;

import modelo.ClienteEmpresarial;
import modelo.FacturaEmpresa;
import modelo.OrdenServicio;

public class ControladorFacturaEmpresa {
    private ControladorCliente controladorCliente;
    private ControladorOrdenes controladorOrdenes;

    public ControladorFacturaEmpresa(ControladorCliente controladorCliente, ControladorOrdenes controladorOrdenes) {
        this.controladorCliente = controladorCliente;
        this.controladorOrdenes = controladorOrdenes;
    }

    public FacturaEmpresa generarFacturaEmpresa(String codigoEmpresa, int mes, int año) {
    ClienteEmpresarial cliente = controladorCliente.buscarClienteEmpresarial(codigoEmpresa);
    if (cliente == null) return null;
    FacturaEmpresa factura = new FacturaEmpresa(cliente, mes, año);
    for (OrdenServicio o : controladorOrdenes.getListaOrdenes()) {
        if (o.getCliente().equals(cliente) 
         && o.getFecha().getMonthValue()==mes
         && o.getFecha().getYear()==año) {
            factura.agregarOrden(o);
        }
    }
    return factura;
}
 public boolean existeClienteEmpresarial(String codigoEmpresa) {
        return controladorCliente.buscarClienteEmpresarial(codigoEmpresa) != null;
    }
}



