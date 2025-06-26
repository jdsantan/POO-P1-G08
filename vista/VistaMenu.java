package vista;
import java.util.Scanner;
import controlador.*;

public class VistaMenu {
    private Scanner sc = new Scanner(System.in);
    private ControladorProvedor controladorProvedor = new ControladorProvedor();
    private VistaInsumo vistaInsumo = new VistaInsumo(controladorProvedor);
    
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
                    controlador.mostrarMenuCliente();
                    break;
                case 2:
                    controlador.mostrarMenuProveedor();
                    break;
                case 3:
                    controlador.mostrarMenuTecnico();
                    break;
                case 4:
                    controlador.mostrarMenuServicio();
                    break;
                case 5:
                    controlador.generarOrdenServicio();
                    break;
                case 6:
                    vistaInsumo.registrarFaltaInsumos();
                    break;
                case 7:
                    controlador.generarFacturaEmpresa();
                    break;
                case 8:
                    controlador.reporteIngresosServicios();
                    break;
                case 9:
                    controlador.reporteAtencionServicios();
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

