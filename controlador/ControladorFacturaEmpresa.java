package controlador;

import java.util.ArrayList;
import modelo.Cliente;
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

    public FacturaEmpresa generarFacturaEmpresa(String codigoEmpresa, int mes, int año, ArrayList<Cliente> listaClientes) {
        // Buscar cliente empresarial
        ClienteEmpresarial cliente = buscarClienteEmpresarial(codigoEmpresa, listaClientes);
        if (cliente == null) {
            return null;
        }

        // Crear factura usando el constructor que recibe los datos requeridos
        FacturaEmpresa factura = new FacturaEmpresa(cliente, mes, año);
        // Buscar órdenes del mes y año especificado
        ArrayList<OrdenServicio> ordenesDelMes = buscarOrdenesPorMesYAño(cliente, mes, año);

        // Agregar órdenes a la factura
        for (OrdenServicio orden : ordenesDelMes) {
            factura.agregarOrden(orden);
        }

        return factura;
    }

    private ClienteEmpresarial buscarClienteEmpresarial(String codigoEmpresa, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente instanceof ClienteEmpresarial) {
                ClienteEmpresarial clienteEmp = (ClienteEmpresarial) cliente;
                if (clienteEmp.getCodigoEmpresa().equals(codigoEmpresa)) {
                    return clienteEmp;
                }
            }
        }
        return null;
    }

    private ArrayList<OrdenServicio> buscarOrdenesPorMesYAño(ClienteEmpresarial cliente, int mes, int año) {
        ArrayList<OrdenServicio> ordenesFiltradas = new ArrayList<>();
        
        for (OrdenServicio orden : controladorOrdenes.getListaOrdenes()) {
            if (orden.getCliente().equals(cliente) && 
                orden.getFecha().getMonthValue() == mes && 
                orden.getFecha().getYear() == año) {
                ordenesFiltradas.add(orden);
            }
        }
        
        return ordenesFiltradas;
    }

    public boolean existeClienteEmpresarial(String codigoEmpresa, ArrayList<Cliente> listaClientes) {
        return buscarClienteEmpresarial(codigoEmpresa, listaClientes) != null;
    }
}