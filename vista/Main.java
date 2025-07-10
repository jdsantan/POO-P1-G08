package vista;


import controlador.ControladorMenu;

public class Main {
    public static void main(String[] args) {
        VistaMenu vistaMenu = new VistaMenu();
        ControladorMenu controladorMenu = new ControladorMenu();
        controladorMenu.Incializar();

        vistaMenu.mostrarMenuPrincipal();
        VistaServicio vistaServicio = new VistaServicio();
        
    }
}