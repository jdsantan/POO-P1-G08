package vista;

import controlador.ControladorProveedor;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Persona;
import modelo.Proveedor;


public class VistaProveedor {
    public ControladorProveedor control;
    Scanner sc;
    public VistaProveedor(ControladorProveedor control){
        this.control = control;
        sc= new Scanner(System.in);
    }
    public void mostrarMenuProveedor(){
            ArrayList<Persona> lista = control.getListaProveedores();
            if (lista.isEmpty()) {
                System.out.println("\n>> No hay Proveedores registrados.");
            } else {
                System.out.println("\n>> Proveedores registrados:");
                for (Persona p : lista) {
                    if(p instanceof Proveedor){
                        Proveedor t = (Proveedor)p;
                        System.out.printf("   %s | %s | %s | %s%n",
                        t.getId(), t.getNombre(),
                        t.getTelefono(), t.getDescripcion());
                    }
                }
            }      
        int opcion;
        do {
            System.out.println("\n=== MENÚ Proveedor ===");
            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Regresar al menu Principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    agregarProveedor();
                    break;
                 case 2:
                    System.out.println("Regresando al menu principal");
                    break;           
                default:
                    System.out.println("Opcion invalida");
            }            
        } while (opcion!=2);
        
        
    }
    
    public void agregarProveedor(){
        
        System.out.println("Ingrese la identificacion del proveedor: ");
        String id = sc.nextLine();
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el telefono del proveedor: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese la descripcion del proveedor: ");
        String descripcion = sc.nextLine();
        
        Proveedor p1 = new Proveedor(id, nombre, telefono, descripcion);
        String mensaje = control.agregarProveedor(p1);
        System.out.println(mensaje);  
             
    }
}
