package controlador;

import java.util.ArrayList;
import modelo.Servicio;

public class ControladorServicio {
    public ArrayList<Servicio>lista;
    public ControladorServicio(){
        lista = new ArrayList<>();
    }

    public String agregarServicio(String nombre,double precio){
        for(Servicio i : lista){
            if(i.getNombre().equalsIgnoreCase(nombre)){
                return "Servicio ya existe";
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

        Servicio nuevo = new Servicio(nuevoCodigo, nombre, precio);
        lista.add(nuevo);
    }
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
    public ArrayList<Servicio> getListaServicios() {
        return lista;
    }
    public ArrayList<Servicio> getServicios() {
        return lista;
}
}
