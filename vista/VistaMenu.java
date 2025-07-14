package vista;
import controlador.*;
import java.util.Scanner;


public class VistaMenu {
    private Scanner sc = new Scanner(System.in);


    public ControladorCliente controladorCliente;
    public VistaCliente vistaCliente;

    public ControladorProveedor controladorProvedor;
    public VistaProveedor vistaProvedor;

    public ControladorTecnico controladorTecnico;
    public VistaTecnico vistaTecnico;

    public ControladorServicio controladorServicio;
    public VistaServicio vistaServicio;
    public ControladorMenu controladorMenu;
    private ControladorFacturaEmpresa controladorFactura;
    private VistaFacturaEmpresa     vistaFactura;   
 

    public ControladorOrden controladorOrden;
    public VistaOrdenServicio vistaOrdenServicio;


    public VistaInsumo vistaInsumo ;

    public VistaReporte vistaReportes ;





    public VistaMenu(ControladorCliente controladorCliente,ControladorProveedor controladorProvedor,ControladorTecnico controladorTecnico,ControladorServicio controladorServicio,VistaInsumo vistaInsumo, ControladorFacturaEmpresa controladorFacturaEmpresa,ControladorOrden controladorOrden) {

        this.controladorCliente = controladorCliente;
        this.vistaCliente = new VistaCliente(this.controladorCliente); 

        this.controladorProvedor = controladorProvedor;
        this.vistaProvedor = new VistaProveedor(this.controladorProvedor);

        this.controladorTecnico = controladorTecnico;
        this.vistaTecnico = new VistaTecnico(this.controladorTecnico);
        this.controladorOrden = controladorOrden;

        this.controladorServicio = controladorServicio;
        this.vistaServicio = new VistaServicio(this.controladorServicio);

        this.vistaOrdenServicio = new VistaOrdenServicio(this.controladorOrden, this.controladorCliente, this.controladorServicio, this.controladorTecnico);

        this.vistaInsumo = new VistaInsumo(controladorProvedor);
         this.controladorFactura = new ControladorFacturaEmpresa(
                                      this.controladorCliente,
                                      this.controladorOrden);
        this.vistaFactura       = new VistaFacturaEmpresa(this.controladorFactura);
    this.vistaReportes = new VistaReporte(this.controladorOrden);
    
        
    }

    
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("====Bienvenido a TecnoCar====");
            System.out.println("1. Administrar Clientes"); 
            System.out.println("2. Administrar Proveedores");
            System.out.println("3. Administrar Técnicos");
            System.out.println("4. Administrar Servicios");
            System.out.println("5. Generar Orden de Servicios");
            System.out.println("6. Registrar Falta de Insumos");
            System.out.println("7. Generar Facturas a Empresas");
            System.out.println("8. Reporte de Ingresos por Servicios");
            System.out.println("9. Reporte de Atenciones por Técnico");
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

    


