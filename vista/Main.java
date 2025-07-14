package vista;


import controlador.ControladorCliente;
import controlador.ControladorFacturaEmpresa;
import controlador.ControladorMenu;
import controlador.ControladorOrden;
import controlador.ControladorProveedor;
import controlador.ControladorServicio;
import controlador.ControladorTecnico;


public class Main {
    public static void main(String[] args) {
        ControladorMenu controladorMenu = new ControladorMenu();
        controladorMenu.Incializar();

        ControladorCliente controladorCliente = new ControladorCliente(controladorMenu.getListaPersonas());
        ControladorProveedor controladorProveedor = new ControladorProveedor(controladorMenu.getListaPersonas());
        ControladorTecnico controladorTecnico = new ControladorTecnico(controladorMenu.getListaPersonas());
        ControladorServicio controladorServicio = new ControladorServicio(controladorMenu.getListaServicios());
        ControladorOrden controladorOrden = new ControladorOrden(controladorMenu.getOrdenServicios());
        ControladorFacturaEmpresa controladorFacturaEmpresa = new ControladorFacturaEmpresa(controladorCliente, controladorOrden);
        VistaInsumo vistaInsumo = new VistaInsumo(controladorProveedor);
       



        VistaMenu vistaMenu = new VistaMenu(controladorCliente,controladorProveedor,controladorTecnico,controladorServicio,vistaInsumo, controladorFacturaEmpresa,controladorOrden);
        vistaMenu.mostrarMenuPrincipal();
        
    }
}
