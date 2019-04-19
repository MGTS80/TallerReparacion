/*
 
 */
package tallerreparacion;

/**
 
 */
public class Cliente {
    
    private int dni;
    private String nombre;
    private String domicilio;
    private int celular;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String domicilio, int celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente(String nombre, String domicilio, int celular) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

   
}

