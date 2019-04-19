package tallerreparacion;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;


public class Reparacion {
    
    private int id = 0;
    private Servicio servicio;
   // private List <Servicio> servicio;//varios servicios 
    private Aparato aparato;
    private boolean estado;
    private LocalDate fechaReparacion;

    //public Reparacion(List<Servicio> servicio, Aparato aparato, String estado) {
    public Reparacion (Servicio servicio, Aparato aparato ){
        this.servicio = servicio;
        this.aparato = aparato;
        this.estado = false;
        this.fechaReparacion = null;
    }

   
    public Reparacion(Aparato aparato) {
        this.aparato = aparato;
    }

    public Reparacion() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   // public List<Servicio> getServicio() {
    public Servicio getServicio() {
        return servicio;
    }

    //public void setServicio(List<Servicio> servicio) {
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Aparato getAparato() {
        return aparato;
    }

    public void setAparato(Aparato aparato) {
        this.aparato = aparato;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    } 
    
    public LocalDate getfechaeparacion() {
        return fechaReparacion;
    }

    public void setfechaReparacion(LocalDate reparacion) {
        this.fechaReparacion = reparacion;
    }
    
}