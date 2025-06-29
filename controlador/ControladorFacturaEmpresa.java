package controlador;
import modelo.Detalledelservicio;
import modelo.FacturasEmpresas;
import java.util.ArrayList;
import java.util.List;
public class ControladorFacturaEmpresa {
 private static final double CARGO_EMPRESARIAL = 50.0;
    private static final String[] NOMBRES_MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
 public void prepararFactura(FacturasEmpresas factura,
                                List<Detalledelservicio> todasLasOrdenes) {
        List<Detalledelservicio> filtradas = new ArrayList<>();

        // 1) Filtrar
        for (Detalledelservicio o : todasLasOrdenes) {
            if ( o.getCodigoEmpresa().equals(factura.getCodigoEmpresa())
              && o.getFecha().getYear() == factura.getAño()
              && o.getFecha().getMonthValue() == factura.getMes() ) {
                filtradas.add(o);
            }
        }

        // 2) Asignar al modelo
        factura.setOrdenes(filtradas);

        // 3) Calcular subtotal
        double subtotal = 0;
        for (Detalledelservicio o : filtradas) {
            subtotal += o.getCantidad() * o.getPrecioUnitario();
        }

        // 4) Total final con cargo fijo
        factura.setTotalPagar(subtotal + CARGO_EMPRESARIAL);
    }
 public String nombreMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            return NOMBRES_MESES[mes - 1];
        }
        return "Mes inválido";
    }

    public double getCargoFijo() {
        return CARGO_EMPRESARIAL;
    }
}

