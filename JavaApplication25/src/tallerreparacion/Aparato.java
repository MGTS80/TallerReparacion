package tallerreparacion;

import java.sql.Date;
import java.time.LocalDate;

public class Aparato {

    private int id = 0;
    private int numserie;
    private String tipo;
    private Cliente cliente;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;

    public Aparato() {
    }

    public Aparato(int numserie, String tipo, Cliente cliente) {
        this.numserie = numserie;
        this.tipo = tipo;
        this.cliente = cliente;
        this.fechaIngreso = LocalDate.now();
        this.fechaEgreso = null;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    
}