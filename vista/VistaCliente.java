package vista;

import controlador.ControladorCliente;
import java.util.Scanner;
import modelo.Cliente;

public class VistaCliente {
    private ControladorCliente controlador;
    private Scanner sc = new Scanner(System.in);
    public VistaCliente(ControladorCliente controlador){
    this.controlador = controlador;
    }
    public void mostrarMenuCliente(){
        int opcion;
        do {
            System.out.println("\n=== MENÚ Cliente ===");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Regresar al menu Principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    System.out.println("Regresando al menu principal");
                    break;                   
                default:
                    System.out.println("Opcion invalida");
        }
        } while (opcion !=2);
        

    }
    
    public void agregarCliente(){
        
        System.out.println("Ingrese la identificacion del cliente: ");
        String id = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la direccion del cliente: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el telefono del cliente: ");
        String telefono = sc.nextLine();
        System.out.println("El cliente es premiun? (true/false) : ");
        boolean tipoCliente = sc.nextBoolean();
        sc.nextLine();
        Cliente c1 = new Cliente(id,nombre,telefono,direccion,tipoCliente);

        String mensaje = controlador.agregarCliente(c1);
        System.out.println(mensaje);
       
    }
}
