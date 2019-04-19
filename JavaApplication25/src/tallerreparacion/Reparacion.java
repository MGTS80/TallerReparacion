package tallerreparacion;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class Reparacion {
    
    private int id = 0;
    private Servicio servicio;
   // private List <Servicio> servicio;//varios servicios 
    private Aparato aparato;
    private String estado;

    //public Reparacion(List<Servicio> servicio, Aparato aparato, String estado) {
    public Reparacion (Servicio servicio, Aparato aparato, String estado ){
        this.servicio = servicio;
        this.aparato = aparato;
        this.estado = estado;
    }

    public Reparacion(Aparato aparato, String estado , Servicio servicio) {
        this.servicio= servicio;
        this.aparato = aparato;
        this.estado = estado;
    }

    public Reparacion(Aparato aparato) {
        this.aparato = aparato;
        this.servicio= servicio;
       // this.servicio= new ArrayList <Servicio>();
        this.estado="pendiente";
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    


    
}