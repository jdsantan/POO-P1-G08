package vista;

public class Main {
    public static void main(String[] args) {
        VistaServicio vista = new VistaServicio();
        vista.menuServicios();
        System.out.println(">>> Fin del módulo de técnicos.");
         VistaTecnico vistaTecnico = new VistaTecnico();
        vistaTecnico.menuTecnicos();
        System.out.println(">>> Fin del módulo de técnicos.");
    }
}