package tallerreparacion;

import java.sql.Date;
import java.time.LocalDate;

public class Aparato {

    private int id = 0;
    private int numserie;
    private String tipo;
    private Cliente cliente;
    private LocalDate fechaingreso;
   // private Date fechaegreso;
      private LocalDate fechaegreso;

    public Aparato() {
    }

    public Aparato(int numserie, String tipo, Cliente cliente, LocalDate fechaingreso, LocalDate fechaegreso) {
        this.numserie = numserie;
        this.tipo = tipo;
        this.cliente = cliente;
        this.fechaingreso = fechaingreso;
        this.fechaegreso = fechaegreso;
    }

    public Aparato(int numserie, String tipo, Cliente cliente) {
        this.numserie = numserie;
        this.tipo = tipo;
        this.cliente = cliente;
         this.fechaingreso = LocalDate.now();
        this.fechaegreso = LocalDate.now();
        
    }

    public Aparato(int numserie, String tipo) {
        this.numserie = numserie;
        this.tipo = tipo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumserie() {
        return numserie;
    }

    public void setNumserie(int numserie) {
        this.numserie = numserie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(LocalDate fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public LocalDate getFechaegreso() {
        return fechaegreso;
    }

    public void setFechaegreso(LocalDate fechaegreso) {
        this.fechaegreso = fechaegreso;
    }
    
}