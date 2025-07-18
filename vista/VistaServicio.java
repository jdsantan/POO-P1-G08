package vista;
import controlador.ControladorServicio;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Servicio;

public class VistaServicio {
    Scanner sc = new Scanner(System.in);
    ControladorServicio controladorServicio;
    public VistaServicio(ControladorServicio controladorServicio){
        this.controladorServicio = controladorServicio;

    }

     public void mostrarmenuServicios() {
        int opcion;
       do {
            ArrayList<Servicio> lista = controladorServicio.getListaServicios();
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
    } 
    
    
 public void agregarServicio(){
        System.out.println("Codigo de Servicio");
        String codigo = sc.nextLine();
        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.print("Precio inicial: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        String mensaje = controladorServicio.agregarServicio(codigo,nombre, precio);
        System.out.println(mensaje);
        
    }
    public void editarServicio(){
        System.out.print("Código del servicio a editar: ");
        String codigo = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();
        sc.nextLine();
        String mensaje = controladorServicio.editarPrecio(codigo, nuevoPrecio);
        System.out.println(mensaje);
        
    }
}
