package vista;
import controlador.ControladorServicio;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Servicio;

public class VistaServicio {
     public void menuServicios() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        ControladorServicio controlador = new ControladorServicio();
       do {
            ArrayList<Servicio> lista = controlador.getListaServicios();
            if (lista.isEmpty()) {
                System.out.println("\n>> No hay servicios registrados.");
            } else {
                System.out.println("\n>> Servicios registrados:");
                for (Servicio s : lista) {
                    System.out.printf("   %s | %s | %.2f%n",
                        s.getCodigo(), s.getNombre(),
                        s.getPrecio());
                }
            }

        do {
            System.out.println("\n=== MENÚ SERVICIOS ===");
            System.out.println("1) Agregar servicio");
            System.out.println("2) Editar precio de servicio");
            System.out.println("3) Regresar al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarServicio();
                    break;

                case 2:
                   editarServicio();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 3);
    }while (opcion != 3);
    sc.close();
    }
 public void agregarServicio(){
        Scanner sc = new Scanner(System.in);
        ControladorServicio controlador = new ControladorServicio();
        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.print("Precio inicial: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        String mensaje = controlador.agregarServicio(nombre, precio);
        System.out.println(mensaje);
        sc.close();
    }
    public void editarServicio(){
        Scanner sc = new Scanner(System.in);
        ControladorServicio controlador = new ControladorServicio();
        System.out.print("Código del servicio a editar: ");
        String codigo = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();
        sc.nextLine();
        String mensaje = controlador.editarPrecio(codigo, nuevoPrecio);
        System.out.println(mensaje);
        sc.close();
    }
}
