/*
 */
package tallerreparacion;


public class Servicio {
    
    private int id;
    private String descripcion;
    private double costo;
  
   
    public Servicio() {
    }

    public Servicio(int id, String descripcio, double costo) {
        this.id = id;
        this.descripcion = descripcio;
        this.costo = costo;
    }

    public Servicio(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

       

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcio) {
        this.descripcion = descripcio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
  

}
