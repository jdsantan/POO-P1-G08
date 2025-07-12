package controlador;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteEmpresarial;
import modelo.Persona;
import modelo.Provedor;
import modelo.Servicio;
import modelo.Tecnico;


public class ControladorMenu {
    ArrayList<Tecnico> listaTecnicos;
    ArrayList<Servicio> listaServicios;
    ArrayList<Cliente> listaClientes;
    ArrayList<Provedor> listaProvedores;
    ArrayList<Persona> listaPersonas;

    public ControladorMenu(){
        listaClientes = new ArrayList<>();
        listaTecnicos = new ArrayList<>();
        listaServicios = new ArrayList<>();
        listaProvedores = new ArrayList<>();
        listaPersonas = new ArrayList<>();
    }
    public void Incializar() {

    listaPersonas.add(new Tecnico("0928497973","Juan Santana","0981124061","Mecánico"));
    listaPersonas.add(new Tecnico("0928497974","Pedro Pérez","0981124062","Electricista"));
    
    listaPersonas.add(new Provedor("POO1","Nankang","0974557","Proveedor de baterias"));
    listaPersonas.add(new Provedor("POO2","Pirelli","0974558","Proveedor de llantas"));

    listaPersonas.add(new Cliente("C001", "Carlos Pérez", "0987654321", "Florida 123", false));
    listaPersonas.add(new ClienteEmpresarial("C002", "Ana Gómez", "0987654322", "Av. Siempre Viva 456", true,"Nankang","E001"));
    listaPersonas.add(new Cliente("C003", "Luis Rodríguez", "0987654323", "Calle Falsa 789", false));
    listaPersonas.add(new ClienteEmpresarial("C004", "María López", "0987654324", "Calle Real 101", true,"MOTORS","E002"));



    listaServicios.add(new Servicio("S001", "Cambio de aceite", 25.00));
    listaServicios.add(new Servicio("S002", "Revisión de frenos", 30.00));
    listaServicios.add(new Servicio("S003", "Cambio de batería", 50.00));
    listaServicios.add(new Servicio("S004", "Alineación y balanceo", 40.00));
    listaServicios.add(new Servicio("S005", "Reparación de motor", 100.00));
    listaServicios.add(new Servicio("S006", "Cambio de amortiguadores", 80.00));


    /* 
    listaTecnicos.add(new Tecnico("0928497973","Juan Santana","0981124061","Mecánico"));
    listaTecnicos.add(new Tecnico("0928497974","Pedro Pérez","0981124062","Electricista"));

    listaProvedores.add(new Provedor("POO1","Nankang","0974557","Proveedor de baterias"));
    listaProvedores.add(new Provedor("POO2","Pirelli","0974558","Proveedor de llantas"));

    listaClientes.add(new Cliente("C001", "Carlos Pérez", "0987654321", "Florida 123", false));
    listaClientes.add(new Cliente("C002", "Ana Gómez", "0987654322", "Av. Siempre Viva 456", true));
    listaClientes.add(new Cliente("C003", "Luis Rodríguez", "0987654323", "Calle Falsa 789", false));
    listaClientes.add(new Cliente("C004", "María López", "0987654324", "Calle Real 101", true));

  
    }
    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }


    */}
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Provedor> getListaProvedores() {
        return listaProvedores;    
         
}
 
 public ArrayList<Persona> getListaPersonas(){
    return listaPersonas;
 }
public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

}
