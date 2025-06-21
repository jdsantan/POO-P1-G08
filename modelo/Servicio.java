package modelo;
import java.util.ArrayList;

public class Servicio {
    private String codigo, nombre;
    private double precio;
    private ArrayList<Double> historialPrecios = new ArrayList<>();

    public Servicio(String codigo, String nombre, double precioInicial) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precioInicial;
        historialPrecios.add(precioInicial);
    }
   
    public void setPrecio(double nuevoPrecio) {
        historialPrecios.add(nuevoPrecio);
        this.precio = nuevoPrecio;
    }
    public ArrayList<Double> getHistorialPrecios() {
        return historialPrecios;
    }
    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    }

