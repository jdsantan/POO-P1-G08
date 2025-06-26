package modelo;

public class FaltaInsumo {
    private String descripcion;
    private Provedor proveedor;

    public FaltaInsumo(String descripcion, Provedor proveedor) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Provedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return "Insumo: " + descripcion + " | Proveedor: " + proveedor.getNombre();
    }
}
