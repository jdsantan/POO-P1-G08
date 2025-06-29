package vista;
import java.util.Scanner;

import modelo.Cliente;
import modelo.OrdenServicio;
import modelo.Servicio;
import modelo.Vehiculo;
import controlador.ControladorCliente;
import controlador.ControladorOrdenes;
import controlador.ControladorServicio;

import java.time.LocalDate;
public class VistaOrdenServicio {
    private ControladorOrdenes controladorOrdenes;
    private ControladorCliente controladorCliente;
    private ControladorServicio controladorServicio;
    public VistaOrdenServicio(ControladorOrdenes controladorOrdenes){
        this.controladorOrdenes = controladorOrdenes;
    }

    
    
    public void generarOrden(){
        Scanner sc = new Scanner(System.in);
        String id,tipVehiculo,placa;
        LocalDate fecha;
        Vehiculo.TipoVehiculo tp = null; 
        

        System.out.println("Ingrese la identificacion del cliente: ");
        id = sc.nextLine();
        Cliente cliente = controladorCliente.buscarCliente(id);
        if(cliente == null){
            System.out.println("Cliente no encontrado");
        }

        System.out.println("Ingrese la placa del vehiculo: ");
        placa= sc.nextLine();
        
        System.out.println("Ingrese el tipo de vehiculo 1.Automovil /n 2. Motocicletas /n 3. Bus: ");
        tipVehiculo= sc.nextLine().toUpperCase();

        System.out.println("Ingrese la fecha del servicio (Formato YYYY-MM-DD): ");
        String entrada = sc.nextLine();
        fecha = LocalDate.parse(entrada);


        try {
            tp = Vehiculo.TipoVehiculo.valueOf(tipVehiculo);
            
        } catch (Exception e) {
            System.out.println("El tipo de vehiculo no se utiliza en nuestra empresa");
        }
        Vehiculo vehiculo = new Vehiculo(placa, tp);

        OrdenServicio orden = controladorOrdenes.crearOrden(cliente, vehiculo, fecha);

        System.out.println("Ingrese el codigo del servicio (-1 para terminar)");
        String codigo= sc.nextLine();

        while (!codigo.equals("-1")) {
            Servicio servicio = controladorServicio.buscarPorCodigo(codigo);
            if(servicio== null){
                System.out.println("Servicio no encontrado");
            }else{
                System.out.println("Ingrese la cantidad");
                int cantidad = sc.nextInt();
                sc.nextLine();
                orden.agregarDetalle(servicio, cantidad);
                System.out.println("Servicio agregado");
            }
            System.out.println("Ingrese el codigo del servicio (-1 para terminar)");
            codigo= sc.nextLine();

        }
        sc.close();
    }


}
