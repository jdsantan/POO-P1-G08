package modelo;

import java.time.LocalDate;

public class OrdenServicio {
    private Servicio servicio;
    private Tecnico tecnico;
    private double monto;
    private LocalDate fecha;

    public OrdenServicio(Servicio servicio, Tecnico tecnico, double monto, LocalDate fecha) {
        this.servicio = servicio;
        this.tecnico = tecnico;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
