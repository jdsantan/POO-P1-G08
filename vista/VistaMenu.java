package vista;
import controlador.*;
import java.util.Scanner;


public class VistaMenu {
    private Scanner sc = new Scanner(System.in);


    public ControladorCliente controladorCliente;
    public VistaCliente vistaCliente;

    public ControladorProvedor controladorProvedor;
    public VistaProvedor vistaProvedor;

    public ControladorTecnico controladorTecnico;
    public VistaTecnico vistaTecnico;

    public ControladorServicio controladorServicio;
    public VistaServicio vistaServicio;
    public ControladorMenu controladorMenu;
    private ControladorFacturaEmpresa controladorFactura;
    private VistaFacturaEmpresa     vistaFactura;   
 

    public ControladorOrdenes controladorOrdenes = new ControladorOrdenes();
    public VistaOrdenServicio vistaOrdenServicio;


    public VistaInsumo vistaInsumo = new VistaInsumo(controladorProvedor);

    public VistaReportes vistaReportes = new VistaReportes(controladorOrdenes);





    public VistaMenu(ControladorCliente controladorCliente,ControladorProvedor controladorProvedor,ControladorTecnico controladorTecnico,ControladorServicio controladorServicio,VistaInsumo vistaInsumo){

        this.controladorCliente = controladorCliente;
        this.vistaCliente = new VistaCliente(this.controladorCliente); 

        this.controladorProvedor = controladorProvedor;
        this.vistaProvedor = new VistaProvedor(this.controladorProvedor);

        this.controladorTecnico = controladorTecnico;
        this.vistaTecnico = new VistaTecnico(this.controladorTecnico);

        this.controladorServicio = controladorServicio;
        this.vistaServicio = new VistaServicio(this.controladorServicio);

        this.vistaOrdenServicio = new VistaOrdenServicio(this.controladorOrdenes, this.controladorCliente, this.controladorServicio, this.controladorTecnico);

        this.vistaInsumo = new VistaInsumo(controladorProvedor);
         this.controladorFactura = new ControladorFacturaEmpresa(
                                      this.controladorCliente,
                                      this.controladorOrdenes);
        this.vistaFactura       = new VistaFacturaEmpresa(this.controladorFactura);
    
    }

    
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
                    vistaServicio.mostrarmenuServicios();
                    break;
                case 5:
                    vistaOrdenServicio.generarOrden();
                    break;
                case 6:
                    vistaInsumo.registrarFaltaInsumos();
                    break;
                case 7:
                    vistaFactura.generarFacturaEmpresa();
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

    


