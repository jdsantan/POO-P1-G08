package vista;


import controlador.ControladorCliente;
import controlador.ControladorMenu;
import controlador.ControladorProvedor;
import controlador.ControladorServicio;
import controlador.ControladorTecnico;


public class Main {
    public static void main(String[] args) {
        ControladorMenu controladorMenu = new ControladorMenu();
        controladorMenu.Incializar();

        ControladorCliente controladorCliente = new ControladorCliente(controladorMenu.getListaClientes());
        ControladorProvedor controladorProvedor = new ControladorProvedor(controladorMenu.getListaProvedores());
        ControladorTecnico controladorTecnico = new ControladorTecnico(controladorMenu.getListaTecnicos());
        ControladorServicio controladorServicio = new ControladorServicio(controladorMenu.getListaServicios());


        VistaMenu vistaMenu = new VistaMenu(controladorCliente,controladorProvedor,controladorTecnico,controladorServicio);
        vistaMenu.mostrarMenuPrincipal();
        
    }
}