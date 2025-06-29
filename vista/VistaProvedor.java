package vista;

import controlador.ControladorProvedor;
import java.util.Scanner;
import modelo.Provedor;

public class VistaProvedor {
    public ControladorProvedor control;
    public VistaProvedor(ControladorProvedor control){
        this.control = control;
    }
    public void mostrarMenuProvedor(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ Provedor ===");
            System.out.println("1. Agregar Provedor");
            System.out.println("2. Regresar al menu Principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarProvedor();
                    break;
                 case 2:
                    System.out.println("Regresando al menu principal");
                    break;           
                default:
                    System.out.println("Opcion invalida");;
            }            
        } while (opcion!=2);
        sc.close();
    }
    
    public void agregarProvedor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la identificacion del provedor: ");
        String id = sc.nextLine();
        System.out.println("Ingrese el nombre del provedor: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el telefono del provedor: ");
        String telefono = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese la descripcion del provedor: ");
        String descripcion = sc.nextLine();
        
        Provedor p1 = new Provedor(id, nombre, telefono, descripcion);
        String mensaje = control.agregarProvedor(p1);
        System.out.println(mensaje);  
        sc.close();     
    }
}
