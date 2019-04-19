/*
 
 */
package tallerreparacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReparacionData {
    
    private Connection con = null;
    

    public ReparacionData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }
    
    public void guardarReparacion(Reparacion reparacion){
        try {
            
            String sql = "INSERT INTO reparacion (aparato, estado) VALUES ( ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reparacion.getAparato().getId());
            ps.setString(2, reparacion.getEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                reparacion.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una reparacion");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar reparacion: " + ex.getMessage());
        }
    }
    
    public List<Reparacion> obtenerReparaciones(){
        List<Reparacion> reparaciones = new ArrayList<Reparacion>();
            
        try {
            String sql = "SELECT * FROM reparacion;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Reparacion reparacion;
            
            while(rs.next()){
                reparacion = new Reparacion();
                reparacion.setId(rs.getInt("id"));
               //Aparato a=buscarAparato(rs.getInt("idAparato"));
              //  reparacion.setAparato(a);
                reparacion.setEstado(rs.getString("estado"));
               
                           }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener reparaciones: " + ex.getMessage());
        }
        
        
        return reparaciones;
    }
    
    
    public Aparato buscarAparatoServicio(int id){
    Aparato aparato = null;
    Servicio servicio = null;
    try {
            
            String sql = "SELECT * FROM apaato WHERE descripcion = ? ;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, servicio.getId());
           
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                aparato = new Aparato();
                aparato.setNumserie(resultSet.getInt("numseie"));
                aparato.setTipo(resultSet.getString("tipo"));
             //   aparato.setFechaingreso(resultSet.getDate("fechaingreso"));
                //reparar tema fechas
             //   aparato.setFechaegreso(resultSet.getDate("fechaegreso"));
                
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al busca un aparato: " + ex.getMessage());
        }
        
        return aparato;
    }
    
    public Aparato buscarAparato(Date fechaingreso){
    Aparato aparato = null;
    try {
            
            String sql = "SELECT * FROM apaato WHERE fechaingreso = ? ;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, fechaingreso);
           
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                aparato = new Aparato();
                aparato.setNumserie(resultSet.getInt("numseie"));
                aparato.setTipo(resultSet.getString("tipo"));
          //      aparato.setFechaingreso(resultSet.getDate("fechaingreso"));
                
                //fechas!!!
               // aparato.setFechaegreso(resultSet.getDate("fechaegreso"));
                
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al busca un aparato: " + ex.getMessage());
        }
        
        return aparato;
    }
    
    
    public List<Aparato> obtenerAparatos(){
       List<Aparato> aparatos = new ArrayList<Aparato>();
           
        try {
            String sql = "SELECT * FROM Aparato;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Aparato aparato;
            while(resultSet.next()){
                aparato = new Aparato();
                aparato.setNumserie(resultSet.getInt("numserie"));
                aparato.setTipo(resultSet.getString("tipo"));
        //        aparato.setFechaingreso(resultSet.getDate("fechaingreso"));
                //fechas!!!
         //       aparato.setFechaegreso(resultSet.getDate("fechaegreso"));
                
                aparatos.add(aparato);
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener los aparatos: " + ex.getMessage());
        }
        
        return aparatos;
    }
    
   
    
}
