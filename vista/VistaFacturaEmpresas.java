package vista;
import modelo.ClienteEmpresarial;
import modelo.Detalledelservicio;
import modelo.FacturasEmpresas;
import controlador.ControladorFacturaEmpresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class VistaFacturaEmpresas {
 private FacturaEmpresasController controller = new FacturaEmpresasController();
// 1) Pedir datos al usuario
    public FacturasEmpresas solicitarDatos(ClienteEmpresarial cliente) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código empresa: ");
        String codigo = sc.nextLine();
        System.out.print("Año (YYYY): ");
        int año = sc.nextInt();
        System.out.print("Mes (1-12): ");
        int mes = sc.nextInt();
        return new FacturasEmpresas(codigo, cliente, LocalDate.now(), mes, año);
    }

    // 2) Cargar datos de ejemplo
    public List<Detalledelservicio> cargarOrdenesPrueba() {
        List<Detalledelservicio> lista = new ArrayList<>();
        lista.add(new Detalledelservicio(
            "EMP-001", LocalDate.of(2025,5,4),
            "Automóvil", "Cambio de aceite",
            1, 20.00, "GST-0984"
        ));
        lista.add(new Detalledelservicio(
            "EMP-001", LocalDate.of(2025,5,9),
            "Bus", "Cambio de filtro",
            1, 15.00, "GNW-087"
        ));
        return lista;
    }

    // 3) Mostrar factura
    public void mostrarFactura(FacturasEmpresas factura) {
        String mesNombre = controlador.nombreMes(factura.getMes());
        System.out.println("\nEmpresa: " + factura.getCliente().getNombre());
        System.out.println("Periodo de facturación: " + mesNombre + " " + factura.getAño());
        System.out.println("Detalle de servicios:");
        System.out.printf("%-10s %-8s %-12s %-20s %8s %10s%n",
            "#Placa","Fecha","Tipo","Servicio","Cantidad","Total");
        for (Detalledelservicio o : factura.getOrdenes()) {
            String fecha = String.format("%02d-%02d",
                o.getFecha().getDayOfMonth(), o.getFecha().getMonthValue());
            double totalServ = o.getCantidad() * o.getPrecioUnitario();
            System.out.printf("%-10s %-8s %-12s %-20s %8d %10.2f%n",
                o.getPlacaVehiculo(), fecha,
                o.getTipoVehiculo(), o.getDescripcionServicio(),
                o.getCantidad(), totalServ);
        }
        System.out.println();
        System.out.printf("Cargo empresarial fijo: %10.2f%n", controller.getCargoFijo());
        System.out.printf("Total a pagar:          %10.2f%n", factura.getTotalPagar());
    }
}
// 4) Generar factura
    public void generarFactura() {
        Scanner sc = new Scanner(System.in);
        ClienteEmpresarial cliente = new ClienteEmpresarial("EMP-001", "Empresa XYZ");
        FacturasEmpresas factura = solicitarDatos(cliente);
        List<Detalledelservicio> ordenes = cargarOrdenesPrueba();
        controller.prepararFactura(factura, ordenes);
        mostrarFactura(factura);
    }

