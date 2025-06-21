package vista;

import java.util.Scanner;

import modelo.Cliente;
import controlador.ControladorCliente;

public class VistaCliente {
    private ControladorCliente controlador;
    public VistaCliente(){
    controlador = new ControladorCliente();
    }
    public void mostrarMenu(){
        System.out.println("1. Agregar cliente");
        System.out.println("2. Regresar al menu Principal");
        System.out.print("Seleccione una opción: ");
    }
    
    public void agregarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la identificacion del cliente: ");
        String id = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la direccion del cliente: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el telefono del cliente: ");
        int telefono = sc.nextInt();
        sc.nextLine();
        System.out.println("clase del cliente: ");
        boolean tipoCliente = sc.nextBoolean();
        Cliente c1 = new Cliente(id,nombre,direccion,telefono,tipoCliente);

        String mensaje = controlador.agregarCliente(c1);
        System.out.println(mensaje);
    }
}
