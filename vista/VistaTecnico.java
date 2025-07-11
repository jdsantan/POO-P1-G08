package vista;
import controlador.ControladorTecnico;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Persona;
import modelo.Tecnico;

public class VistaTecnico {
    private ControladorTecnico ctrl;
    private Scanner sc;

    public VistaTecnico(ControladorTecnico controladorTecnico) {
        ctrl = controladorTecnico;
        sc = new Scanner(System.in);
    }

    public void mostrarmenuTecnicos() {
        int opcion;
        do {
            ArrayList<Persona> lista = ctrl.getListaTecnicos();
            if (lista.isEmpty()) {
                System.out.println("\n>> No hay técnicos registrados.");
            } else {
                System.out.println("\n>> Técnicos registrados:");
                for (Persona p : lista) {
                    if(p instanceof Tecnico){
                        Tecnico t = (Tecnico)p;
                        System.out.printf("   %s | %s | %s | %s%n",
                        t.getId(), t.getNombre(),
                        t.getTelefono(), t.getEspecialidad());
                    }
                }
            }

            // 1) Submenú
            System.out.println("\n--- Menú Técnicos ---");
            System.out.println("1) Agregar técnico");
            System.out.println("2) Eliminar técnico");
            System.out.println("3 ) Regresar al menú principal");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    System.out.print("Cédula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = sc.nextLine();
                    String msgAg = ctrl.agregarTecnico(
                        new Tecnico(ced, nom, tel, esp));
                    System.out.println(">> " + msgAg);
                    break;

              
                case 2:
                    // Eliminar
                    System.out.print("Cédula del técnico a eliminar: ");
                    String cedDel = sc.nextLine();
                    Tecnico toDelete = ctrl.buscarTecnico(cedDel);
                    if (toDelete == null) {
                        System.out.println(">> Técnico no encontrado");
                        break;
                    }
                    System.out.println(">> Datos: " + toDelete);
                    System.out.print("¿Confirma eliminación? (S/N): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("S")) {
                        System.out.println(">> " + ctrl.eliminarTecnico(cedDel));
                    } else {
                        System.out.println(">> Eliminación cancelada.");
                    }
                    break;

                case 3:
                    System.out.println(">> Volviendo al menú principal...");
                    break;

                default:
                    System.out.println(">> Opción inválida.");
            }

        } while (opcion != 3);
    }

}