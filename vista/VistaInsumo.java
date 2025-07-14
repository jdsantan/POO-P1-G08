package vista;

import controlador.ControladorProveedor;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.FaltaInsumo;
import modelo.Persona;
import modelo.Proveedor;

public class VistaInsumo {
    private ControladorProveedor controladorProvedor;
    private Scanner scanner;

    public VistaInsumo(ControladorProveedor controladorProvedor) {
        this.controladorProvedor = controladorProvedor;
        scanner = new Scanner(System.in);
    }

    public void registrarFaltaInsumos() {
        System.out.println("=== REGISTRAR FALTA DE INSUMO ===");
        System.out.print("Descripción del insumo: ");
        String descripcion = scanner.nextLine();

        ArrayList<Persona> provedores = controladorProvedor.getListaProvedores();
        if (provedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        System.out.println("Seleccione el proveedor:");

        int i =0;
        for(Persona p : provedores){
            if(p instanceof Proveedor){
                Proveedor pr = (Proveedor)p;
                System.out.println((i+1) + ". "+ pr.getNombre());
                i++;
            }
        }
       
        int opcion = scanner.nextInt();
        scanner.nextLine();
        int contador = 0;
        int indexReal = -1;
        for(int j =0; j<provedores.size();j++){
            Persona p = provedores.get(j);
            if(p instanceof Proveedor){
                contador++;
                if(opcion == contador){
                    indexReal = j;
                    break;
                }
            }
        }
        if (indexReal != -1) {
            Proveedor provedorSeleccionado = (Proveedor) provedores.get(indexReal);
            FaltaInsumo falta = new FaltaInsumo(descripcion, provedorSeleccionado);
            System.out.println("Falta registrada correctamente:\n" + falta);
        } else {
            System.out.println("Opción inválida.");
        }

    }

}
