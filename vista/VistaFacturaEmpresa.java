package vista;

import controlador.ControladorFacturaEmpresa;
import modelo.*;
import java.util.Scanner;

public class VistaFacturaEmpresa {
    private ControladorFacturaEmpresa controlador;
    private Scanner sc;
    
    public VistaFacturaEmpresa(ControladorFacturaEmpresa controlador) {
        this.controlador = controlador;
        this.sc = new Scanner(System.in);
    }
    
    public void mostrarMenuFacturacion() {
        int opcion;
        do {
            System.out.println("\n=== FACTURACIÓN EMPRESARIAL ===");
            System.out.println("1. Generar factura mensual");
            System.out.println("2. Ver clientes empresariales");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); 
            
            switch (opcion) {
                case 1:
                    generarFacturaMensual();
                    break;
                case 2:
                    mostrarClientesEmpresariales();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 3);
    }
    
    public void generarFacturaMensual() {
        System.out.println("\n--- Generar Factura Mensual ---");
        
        // Mostrar clientes empresariales disponibles
        mostrarClientesEmpresariales();
        
        System.out.print("Ingrese el código de la empresa: ");
        String codigoEmpresa = sc.nextLine().toUpperCase();
        
        // Verificar que existe el cliente
        ClienteEmpresarial cliente = controlador.buscarClienteEmpresarial(codigoEmpresa);
        if (cliente == null) {
            System.out.println("ERROR: No se encontró una empresa con el código: " + codigoEmpresa);
            return;
        }
        
        System.out.print("Ingrese el año (ejemplo: 2025): ");
        int año = sc.nextInt();
        
        System.out.print("Ingrese el mes (1-12): ");
        int mes = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        // Validar mes
        if (mes < 1 || mes > 12) {
            System.out.println("ERROR: El mes debe estar entre 1 y 12");
            return;
        }
        
        // Generar la factura
        FacturasEmpresas factura = controlador.generarFactura(codigoEmpresa, mes, año);
        
        if (factura == null) {
            System.out.println("ERROR: No se pudo generar la factura");
            return;
        }
        
        // Mostrar la factura
        mostrarFactura(factura);
    }
    
    private void mostrarFactura(FacturasEmpresas factura) {
        String[] nombresMeses = controlador.getNombresMeses();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    FACTURA EMPRESARIAL");
        System.out.println("=".repeat(60));
        System.out.println("Empresa: " + factura.getCliente().getNombreEmpresa());
        System.out.println("Código: " + factura.getCodigoEmpresa());
        System.out.println("Período de facturación: " + nombresMeses[factura.getMes()-1] + " " + factura.getAño());
        System.out.println("Fecha de generación: " + factura.getFechaFacturacion());
        System.out.println();
        
        System.out.println("Detalle de servicios:");
        System.out.println("-".repeat(80));
        System.out.printf("%-12s %-10s %-12s %-25s %-8s %10s%n", 
                         "#Placa", "Fecha", "Tipo", "Servicio", "Cantidad", "Total");
        System.out.println("-".repeat(80));
        
        double totalServicios = 0.0;
        
        if (factura.getOrdenes().isEmpty()) {
            System.out.println("No hay servicios registrados para este período.");
        } else {
            for (Detalledelservicio detalle : factura.getOrdenes()) {
                System.out.printf("%-12s %-10s %-12s %-25s %-8d %10.2f%n",
                                "XXX-000", 
                                "01-" + String.format("%02d", factura.getMes()), 
                                "Automóvil", 
                                detalle.getServicio().getNombre(),
                                detalle.getCantidad(),
                                detalle.getSubtotal());
                totalServicios += detalle.getSubtotal();
            }
        }
        
        System.out.println("-".repeat(80));
        System.out.printf("%-67s %10.2f%n", "Subtotal servicios:", totalServicios);
        System.out.printf("%-67s %10.2f%n", "Tarifa mensual empresarial:", ControladorFacturaEmpresa.TARIFA_MENSUAL_EMPRESA);
        System.out.println("-".repeat(80));
        System.out.printf("%-67s %10.2f%n", "TOTAL A PAGAR:", factura.getTotalPagar());
        System.out.println("=".repeat(80));
        
        System.out.println("\n✓ Factura generada exitosamente");
    }
    
    private void mostrarClientesEmpresariales() {
        System.out.println("\n--- Clientes Empresariales Registrados ---");
        System.out.println("-".repeat(50));
        System.out.printf("%-10s %-30s%n", "Código", "Nombre Empresa");
        System.out.println("-".repeat(50));
        
        for (ClienteEmpresarial cliente : controlador.getListaClientesEmpresariales()) {
            System.out.printf("%-10s %-30s%n", 
                            cliente.getCodigoEmpresa(), 
                            cliente.getNombreEmpresa());
        }
        System.out.println("-".repeat(50));
    }
}
