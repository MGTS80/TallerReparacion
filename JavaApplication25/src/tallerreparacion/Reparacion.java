package tallerreparacion;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;


public class Reparacion {
    
    private int id = 0;
    private Servicio servicio;
   // private List <Servicio> servicio;//varios servicios 
    private Aparato aparato;
    private boolean estadoRealizado;
    private LocalDate fechaReparacion;

    //public Reparacion(List<Servicio> servicio, Aparato aparato, String estadoRealizado) {
    public Reparacion (Servicio servicio, Aparato aparato ){
        this.servicio = servicio;
        this.aparato = aparato;
        this.estadoRealizado = false;
        this.fechaReparacion = LocalDate.now();//no se como guardar null
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

    public boolean getEstadoRealizado() {
        return estadoRealizado;
    }

    public void setEstadoRealizado(boolean estadoRealizado) {
        this.estadoRealizado = estadoRealizado;
    } 
    
    public LocalDate getfechaeparacion() {
        return fechaReparacion;
    }

    public void setfechaReparacion(LocalDate reparacion) {
        this.fechaReparacion = reparacion;
    }
    
}