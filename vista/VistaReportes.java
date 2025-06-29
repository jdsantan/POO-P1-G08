package vista;

import modelo.*;
import controlador.ControladorOrdenes;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class VistaReportes {
    private ControladorOrdenes controladorOrdenes;
    private Scanner scanner;

    public VistaReportes(ControladorOrdenes controladorOrdenes) {
        this.controladorOrdenes = controladorOrdenes;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarIngresosPorServicios() {
        System.out.print("Ingrese el año (yyyy): ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        Map<String, Double> ingresosPorServicio = new HashMap<>();

        for (OrdenServicio orden : controladorOrdenes.getListaOrdenes()) {
            if (orden.getFecha().getYear() == anio && orden.getFecha().getMonthValue() == mes) {
                for (Detalledelservicio detalledelservicio : orden.getDetalle()){
                    String nombreServicio = detalledelservicio.getServicio().getNombre();
                ingresosPorServicio.put(nombreServicio,
                    ingresosPorServicio.getOrDefault(nombreServicio, 0.0) + orden.getTotal());                   
                }

            }
        }

        System.out.println("\nServicio\t\t\tTotal");
        ingresosPorServicio.forEach((servicio, total) ->
            System.out.printf("%-25s\t%.2f\n", servicio, total));
    }

    public void mostrarIngresosPorTecnico() {
        System.out.print("Ingrese el año (yyyy): ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        Map<String, Double> ingresosPorTecnico = new HashMap<>();

        for (OrdenServicio orden : controladorOrdenes.getListaOrdenes()) {
            if (orden.getFecha().getYear() == anio && orden.getFecha().getMonthValue() == mes) {
                String nombreTecnico = orden.getTecnico().getNombre();
                ingresosPorTecnico.put(nombreTecnico,
                    ingresosPorTecnico.getOrDefault(nombreTecnico, 0.0) + orden.getTotal());
            }
        }

        System.out.println("\nTécnico\t\t\t\tTotal");
        ingresosPorTecnico.forEach((tecnico, total) ->
            System.out.printf("%-25s\t%.2f\n", tecnico, total));
    }
}
