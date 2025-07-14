package vista;

import controlador.ControladorProveedor;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.FaltaInsumo;
import modelo.Persona;
import modelo.Proveedor;

public class VistaInsumo {
    private ControladorProveedor controladorProveedor;
    private Scanner scanner;

    public VistaInsumo(ControladorProveedor controladorProveedor) {
        this.controladorProveedor = controladorProveedor;
        scanner = new Scanner(System.in);
    }

    public void registrarFaltaInsumos() {
        System.out.println("=== REGISTRAR FALTA DE INSUMO ===");
        System.out.print("Descripción del insumo: ");
        String descripcion = scanner.nextLine();

        ArrayList<Persona> proveedores = controladorProveedor.getListaProveedores();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        System.out.println("Seleccione el proveedor:");

        int i =0;
        for(Persona p : proveedores){
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
        for(int j =0; j<proveedores.size();j++){
            Persona p = proveedores.get(j);
            if(p instanceof Proveedor){
                contador++;
                if(opcion == contador){
                    indexReal = j;
                    break;
                }
            }
        }
        if (indexReal != -1) {
            Proveedor provedorSeleccionado = (Proveedor) proveedores.get(indexReal);
            FaltaInsumo falta = new FaltaInsumo(descripcion, provedorSeleccionado);
            System.out.println("Falta registrada correctamente:\n" + falta);
        } else {
            System.out.println("Opción inválida.");
        }

    }

}
