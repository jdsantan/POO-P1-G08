package controlador;

import java.util.ArrayList;
import modelo.Servicio;

public class ControladorServicio {
    public ArrayList<Servicio>lista;
    public ControladorServicio(ArrayList<Servicio>lista){
        this.lista = lista;
    }

    public String agregarServicio(String codigo,String nombre,double precio){
        for(Servicio i : lista){
            if(i.getCodigo().equalsIgnoreCase(codigo)){
                return "Servicio ya existe";
            }
        }
         String nuevoCodigo;
        if (lista.isEmpty()) {
            nuevoCodigo = "S001";
        } else {
            String ultimoCodigo = lista.get(lista.size() - 1).getCodigo();  
            int numero = Integer.parseInt(ultimoCodigo.substring(1));
            numero++;
            nuevoCodigo = String.format("S%03d", numero);  
        }

        Servicio nuevo = new Servicio(nuevoCodigo, codigo, precio);
        lista.add(nuevo);

        return "Servicio agregado satisfactoriamente";
    }
    public String editarPrecio(String codigo, double nuevoPrecio) {
        for (Servicio s : lista) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                double viejo = s.getPrecio();
                s.setPrecio(nuevoPrecio);
                return String.format("Precio de %s (código %s) cambiado de %.2f a %.2f",
                                     s.getNombre(), s.getCodigo(), viejo, nuevoPrecio);
            }
        }
        return "No se encontró servicio con código " + codigo;
    }
    public Servicio buscarPorCodigo(String codigo){
        for(Servicio s : lista){
            if(codigo.equalsIgnoreCase(s.getCodigo())){
                return s;
            }
        }
        return null;
    }
public ArrayList<Servicio> getListaServicios() {
        return lista;
    }

}
