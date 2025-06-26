package vista;

import java.util.Scanner;
import modelo.FaltaInsumo;
import modelo.Provedor;
import controlador.ControladorProvedor;
import java.util.ArrayList;

public class VistaInsumo {
    private ControladorProvedor controladorProvedor;
    private Scanner scanner;

    public VistaInsumo(ControladorProvedor controladorProvedor) {
        this.controladorProvedor = controladorProvedor;
        scanner = new Scanner(System.in);
    }

    public void registrarFaltaInsumo() {
        System.out.println("=== REGISTRAR FALTA DE INSUMO ===");
        System.out.print("Descripción del insumo: ");
        String descripcion = scanner.nextLine();

        ArrayList<Provedor> provedores = controladorProvedor.getListaProvedores();
        if (provedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        System.out.println("Seleccione el proveedor:");
        for (int i = 0; i < provedores.size(); i++) {
            System.out.println((i + 1) + ". " + provedores.get(i).getNombre());
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion > 0 && opcion <= provedores.size()) {
            Provedor provedorSeleccionado = provedores.get(opcion - 1);
            FaltaInsumo falta = new FaltaInsumo(descripcion, provedorSeleccionado);
            System.out.println("Falta registrada correctamente:\n" + falta);
        } else {
            System.out.println("Opción inválida.");
        }
    }
}
