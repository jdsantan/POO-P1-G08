package vista;

import controlador.ControladorFacturaEmpresa;
import controlador.ControladorMenu;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Detalledelservicio;
import modelo.FacturaEmpresa;
import modelo.OrdenServicio;

public class VistaFacturaEmpresa {
    private ControladorFacturaEmpresa controladorFacturaEmpresa;

    public VistaFacturaEmpresa(ControladorFacturaEmpresa controladorFacturaEmpresa) {
        this.controladorFacturaEmpresa = controladorFacturaEmpresa;
    }

    public void generarFacturaEmpresa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== GENERACIÓN DE FACTURA EMPRESARIAL ===");
        
        System.out.print("Ingrese el código de la empresa: ");
        String codigoEmpresa = sc.nextLine();

        System.out.print("Ingrese el año: ");
        int año = sc.nextInt();

        System.out.print("Ingrese el mes (1-12): ");
        int mes = sc.nextInt();

        // Validar mes
        if (mes < 1 || mes > 12) {
            System.out.println("Mes no válido. Debe estar entre 1 y 12.");
            return;
        }

        // Generar factura
        FacturaEmpresa factura = controladorFacturaEmpresa.generarFacturaEmpresa(codigoEmpresa, mes, año, controladorFacturaEmpresa.getListaPersonas());

        if (factura == null) {
            System.out.println("No se encontró la empresa con código: " + codigoEmpresa);
            return;
        }

        if (factura.getOrdenes().isEmpty()) {
            System.out.println("No hay servicios registrados para la empresa " + factura.getNombreEmpresa() + 
                             " en " + factura.getNombreMes() + " " + factura.getAño());
            return;
        }

        // Mostrar factura
        mostrarFactura(factura);
    }

    private void mostrarFactura(FacturaEmpresa factura) {
        System.out.println("\n==================== FACTURA ====================");
        System.out.println("Empresa: " + factura.getNombreEmpresa());
        System.out.println("Periodo de facturación: " + factura.getNombreMes() + " " + factura.getAño());
        System.out.println("Detalle de servicios:");
        System.out.println("# Placa\t\tFecha\t\tTipo\t\tServicio\t\tCantidad\tTotal");
        System.out.println("================================================================");

        for (OrdenServicio orden : factura.getOrdenes()) {
            for (Detalledelservicio detalle : orden.getDetalle()) {
                System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%d\t\t%.2f\n",
                    orden.getVehiculo().getPlaca(),
                    orden.getFecha(),
                    orden.getVehiculo().getTipo(),
                    detalle.getServicio().getNombre(),
                    detalle.getCantidad(),
                    detalle.getSubtotal()
                );
            }
        }

        System.out.println("================================================================");
        System.out.printf("Subtotal servicios: \t\t\t\t\t\t\t$%.2f\n", factura.getTotalServicios());
        System.out.printf("Costo prioridad empresarial: \t\t\t\t\t\t$%.2f\n", FacturaEmpresa.getCostoPrioridad());
        System.out.printf("TOTAL A PAGAR: \t\t\t\t\t\t\t\t$%.2f\n", factura.getTotalFactura());
        System.out.println("================================================================");
    }
}