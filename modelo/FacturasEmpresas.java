package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class FacturasEmpresas {
private String codigoEmpresa;
private ClienteEmpresarial cliente;
private LocalDate fechaFacturacion;
private int mes;
private int año;
private ArrayList<Detalledelservicio> ordenes;

public FacturasEmpresas(String codigoEmpresa, ClienteEmpresarial cliente, LocalDate fechaFacturacion, int mes, int año) {
    this.codigoEmpresa = codigoEmpresa;
    this.cliente = cliente;
    this.fechaFacturacion = LocalDate.now();
    this.mes = mes;
    this.año = año;
    this.ordenes = new ArrayList<>();

}

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public ClienteEmpresarial getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEmpresarial cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(LocalDate fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if(mes < 1 || mes > 12) {
           System.out.println("mes no valido: debe estar entre 1 y 12");
           return;
        }
        this.mes = mes;
    }

    public int getAño() { 
        return año;
    }

    public void setAño(int año) {
         if(año < 1900){
            System.out.println("Año no válido: debe ser mayor o igual a 1900");
            return ; 
        }
        this.año = año;
    }

    public ArrayList<Detalledelservicio> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Detalledelservicio> ordenes) {
        this.ordenes = ordenes;
    }

}
