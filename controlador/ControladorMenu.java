package controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteEmpresarial;
import modelo.OrdenServicio;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Servicio;
import modelo.Tecnico;
import modelo.Vehiculo;

public class ControladorMenu {
    ArrayList<Tecnico> listaTecnicos;
    ArrayList<Servicio> listaServicios;
    ArrayList<Cliente> listaClientes;
    ArrayList<Proveedor> listaProvedores;
    ArrayList<Persona> listaPersonas;
    ArrayList<OrdenServicio> listaOrdenes;

    public ControladorMenu(){
        listaClientes = new ArrayList<>();
        listaTecnicos = new ArrayList<>();
        listaServicios = new ArrayList<>();
        listaProvedores = new ArrayList<>();
        listaPersonas = new ArrayList<>();
        listaOrdenes = new ArrayList<>();
    }
    public void Incializar() {

    listaPersonas.add(new Tecnico("T001","Juan Peña","0981124063","Mecánico"));
    listaPersonas.add(new Tecnico("T002","Pedro Pérez","0981124062","Electricista"));
    
    listaPersonas.add(new Proveedor("POO1","Nankang","0974557","Proveedor de baterias"));
    listaPersonas.add(new Proveedor("POO2","Pirelli","0974558","Proveedor de llantas"));

    listaPersonas.add(new Cliente("C001", "Carlos Pérez", "0987654321", "Florida 123", false));
    listaPersonas.add(new ClienteEmpresarial("C002", "Ana Gómez", "0987654322", "Av. Siempre Viva 456", true,"Agro","E001"));
    listaPersonas.add(new Cliente("C003", "Luis Rodríguez", "0987654323", "Calle Falsa 789", false));
    listaPersonas.add(new ClienteEmpresarial("C004", "María López", "0987654324", "Calle Real 101", true,"MOTORS","E002"));



    listaServicios.add(new Servicio("S001", "Cambio de aceite", 25.00));
    listaServicios.add(new Servicio("S002", "Revisión de frenos", 30.00));
    listaServicios.add(new Servicio("S003", "Cambio de batería", 50.00));
    listaServicios.add(new Servicio("S004", "Alineación y balanceo", 40.00));
    listaServicios.add(new Servicio("S005", "Reparación de motor", 100.00));
    listaServicios.add(new Servicio("S006", "Cambio de amortiguadores", 80.00));
    listaOrdenes.add(new OrdenServicio((Cliente) listaPersonas.get(7), new Vehiculo("V001", Vehiculo.TipoVehiculo.AUTOMOVIL), (Tecnico) listaPersonas.get(0), LocalDate.parse("2025-01-01")));
    listaOrdenes.add(new OrdenServicio((Cliente) listaPersonas.get(4), new Vehiculo("V002", Vehiculo.TipoVehiculo.AUTOMOVIL), (Tecnico) listaPersonas.get(0), LocalDate.parse("2025-01-02")));
    listaOrdenes.add(new OrdenServicio((Cliente) listaPersonas.get(5), new Vehiculo("V003", Vehiculo.TipoVehiculo.MOTOCICLETA), (Tecnico) listaPersonas.get(1), LocalDate.parse("2025-01-03")));
    listaOrdenes.add(new OrdenServicio((Cliente) listaPersonas.get(6), new Vehiculo("V004", Vehiculo.TipoVehiculo.BUS), (Tecnico) listaPersonas.get(1), LocalDate.parse("2025-01-04")));
    
    OrdenServicio orden = listaOrdenes.get(0);
    OrdenServicio orden1 = listaOrdenes.get(1);
    OrdenServicio orden2 = listaOrdenes.get(2);
    OrdenServicio orden3 = listaOrdenes.get(3);

    orden.agregarDetalle(listaServicios.get(0), 2);
    orden1.agregarDetalle(listaServicios.get(1), 1);
    orden2.agregarDetalle(listaServicios.get(2), 1);
    orden3.agregarDetalle(listaServicios.get(3), 1);
    orden.agregarDetalle(listaServicios.get(1), 2);
    orden1.agregarDetalle(listaServicios.get(2), 1);
    orden2.agregarDetalle(listaServicios.get(3), 1);
    orden3.agregarDetalle(listaServicios.get(4), 1);

   
    }
    public ArrayList<Proveedor> getListaProvedores() {
        return listaProvedores;    
         
}
 
 public ArrayList<Persona> getListaPersonas(){
    return listaPersonas;
 }
public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }
public ArrayList<OrdenServicio> getOrdenServicios(){
    return listaOrdenes;
}

}
