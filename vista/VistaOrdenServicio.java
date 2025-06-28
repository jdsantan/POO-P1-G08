package vista;
import java.util.Scanner;

import modelo.OrdenServicio;
import modelo.Vehiculo;

import java.time.LocalDate;
public class VistaOrdenServicio {
    
    public void generarServicio(){
        Scanner sc = new Scanner(System.in);
        String id,tipoVehiculo,placa;
        LocalDate fecha;

        Vehiculo.TipoVehiculo tp = null; 
        

        System.out.println("Ingrese la identificacion del cliente: ");
        id = sc.nextLine();
        System.out.println("Ingrese la fecha del servicio (Formato AAAA-MM-DD): ");
        String entrada = sc.nextLine();
        fecha = LocalDate.parse(entrada);
        System.out.println("Ingrese el tipo de vehiculo 1.Automovil /n 2. Motocicletas /n 3. Bus: ");
        tipoVehiculo= sc.nextLine().toUpperCase();
        System.out.println("Ingrese la placa del vehiculo: ");
        placa= sc.nextLine();
        try {
            tp = Vehiculo.TipoVehiculo.valueOf(entrada);
            
        } catch (Exception e) {
            System.out.println("El tipo de vehiculo no se utiliza en nuestra empresa");
        }
        Vehiculo vehiculo = new Vehiculo(placa, tp);


        
        OrdenServicio orden = controladorOrdenes.crearOrden(id,vehiculo,fecha);

    }


}
