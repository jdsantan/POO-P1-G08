package vista;


import controlador.ControladorCliente;
import controlador.ControladorFacturaEmpresa;
import controlador.ControladorMenu;
import controlador.ControladorOrden;
import controlador.ControladorProvedor;
import controlador.ControladorServicio;
import controlador.ControladorTecnico;


public class Main {
    public static void main(String[] args) {
        ControladorMenu controladorMenu = new ControladorMenu();
        controladorMenu.Incializar();

        ControladorCliente controladorCliente = new ControladorCliente(controladorMenu.getListaPersonas());
        ControladorProvedor controladorProvedor = new ControladorProvedor(controladorMenu.getListaPersonas());
        ControladorTecnico controladorTecnico = new ControladorTecnico(controladorMenu.getListaPersonas());
        ControladorServicio controladorServicio = new ControladorServicio(controladorMenu.getListaServicios());
        ControladorOrden controladorOrden = new ControladorOrden(controladorMenu.getOrdenServicios());
        ControladorFacturaEmpresa controladorFacturaEmpresa = new ControladorFacturaEmpresa(controladorCliente, controladorOrden);
        VistaInsumo vistaInsumo = new VistaInsumo(controladorProvedor);



        VistaMenu vistaMenu = new VistaMenu(controladorCliente,controladorProvedor,controladorTecnico,controladorServicio,vistaInsumo, controladorFacturaEmpresa);
        vistaMenu.mostrarMenuPrincipal();
        
    }
}
