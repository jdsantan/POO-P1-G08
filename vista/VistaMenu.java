package vista;
import controlador.*;
import java.util.Scanner;


public class VistaMenu {
    private Scanner sc = new Scanner(System.in);
    public ControladorProvedor controladorProvedor = new ControladorProvedor();
    public VistaProvedor vistaProvedor = new VistaProvedor(controladorProvedor);
    public VistaInsumo vistaInsumo = new VistaInsumo(controladorProvedor);
    public ControladorOrdenes controladorOrdenes = new ControladorOrdenes();
    public VistaOrdenServicio vistaOrdenServicio = new VistaOrdenServicio(controladorOrdenes);
    public VistaReportes vistaReportes = new VistaReportes(controladorOrdenes);
    public ControladorCliente controladorCliente = new ControladorCliente();
    public VistaCliente vistaCliente = new VistaCliente(controladorCliente);
    public VistaTecnico vistaTecnico = new VistaTecnico();
    public ControladorFacturaEmpresa controladorFactura = new ControladorFacturaEmpresa(controladorOrdenes);
    public VistaFacturaEmpresa vistaFactura = new VistaFacturaEmpresa(controladorFactura);

   
    
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Administrar Clietes"); 
            System.out.println("2. Administrar proveedores");
            System.out.println("3. Administrar técnicos");
            System.out.println("4. Administrar servicios");
            System.out.println("5. Generar orden de servicios");
            System.out.println("6. Registrar falta de insumos");
            System.out.println("7. Generar facturas a empresas");
            System.out.println("8. Reporte de ingresos por servicios");
            System.out.println("9. Reporte de atenciones por técnico");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    vistaCliente.mostrarMenuCliente();
                    break;
                case 2:
                    vistaProvedor.mostrarMenuProvedor();
                    break;
                case 3:
                    vistaTecnico.mostrarmenuTecnicos();
                    break;
                case 4:
                    new VistaServicio().mostrarmenuServicios();
                    break;
                case 5:
                    vistaOrdenServicio.generarOrden();
                    break;
                case 6:
                    vistaInsumo.registrarFaltaInsumos();
                    break;
                case 7:
                    vistaFactura.mostrarMenuFacturacion();
                    break;
                case 8:
                    vistaReportes.mostrarIngresosPorServicios();
                    break;
                case 9:
                    vistaReportes.mostrarIngresosPorTecnico();
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        } while (opcion != 0);
    }
}

    


