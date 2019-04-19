/*
 
 */
package tallerreparacion;

/**
 
 */
public class Cliente {
    
    private int id = 0;
    private String nombre;
    private int dni;
    private String domicilio;
    private int celular;

    public Cliente(String nombre, int dni, String domicilio, int celular) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

