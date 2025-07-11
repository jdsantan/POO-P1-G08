package vista;

import java.util.Scanner;
import modelo.FaltaInsumo;
import modelo.Persona;
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
            if(p instanceof Provedor){
                Provedor pr = (Provedor)p;
                System.out.println((i+1) + ". "+ pr.getNombre());
                i++;
            }
        }
        /* 
        for (int i = 0; i < provedores.size(); i++) {
            System.out.println((i + 1) + ". " + provedores.get(i).getNombre());
        }
         */

        int opcion = scanner.nextInt();
        scanner.nextLine();
        int contador = 0;
        int indexReal = -1;
        for(int j =0; j<provedores.size();j++){
            Persona p = provedores.get(j);
            if(p instanceof Provedor){
                contador++;
                if(opcion == contador){
                    indexReal = j;
                    break;
                }
            }
        }
        if (indexReal != -1) {
            Provedor provedorSeleccionado = (Provedor) provedores.get(indexReal);
            FaltaInsumo falta = new FaltaInsumo(descripcion, provedorSeleccionado);
            System.out.println("Falta registrada correctamente:\n" + falta);
        } else {
            System.out.println("Opción inválida.");
        }
/*
        if (opcion > 0 && opcion <= provedores.size()) {
            Provedor provedorSeleccionado = provedores.get(opcion - 1);
            FaltaInsumo falta = new FaltaInsumo(descripcion, provedorSeleccionado);
            System.out.println("Falta registrada correctamente:\n" + falta);
        } else {
            System.out.println("Opción inválida.");
        }
             */
    }

}
