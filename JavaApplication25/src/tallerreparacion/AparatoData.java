                                                                     
                                                                     
                                             
package tallerreparacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AparatoData {
    
    private Connection con;
    
    
    public AparatoData(Conexion conexion){
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }

    public void guardarAparato(Aparato aparato) {
        try {
            
            String sql = "INSERT INTO aparato (numserie, tipo, cliente, fechaingreso, fechaegreso) VALUES ( ? , ? , ? , ? , ?);";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, aparato.getNumserie());
            ps.setString(2, aparato.getTipo());
            ps.setInt(3, aparato.getCliente().getDni());
            ps.setDate(4, Date.valueOf(aparato.getFechaIngreso()));
           
           // ps.setDate(5, aparato.getFechaegreso());
            ps.setDate(5, Date.valueOf(aparato.getFechaEgreso()));
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("en el IF de insertar un aparato");
                aparato.setNumserie(rs.getInt(1));
            } else {
                System.out.println("en el ELSE de insertar un aparato");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un aparato: " + ex.getMessage());
        }
    }
    
    
    
    public void actualizAraparato(Aparato aparato){
    
        try {
            
            String sql = "UPDATE aparato SET  numserie = ? , tipo = ? , cliente = ? , fechaingreso = ? , fechaegreso = ? " +  "WHERE id = ?;";
                    
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, aparato.getNumserie());
            ps.setString(2, aparato.getTipo());
            ps.setString(3, aparato.getCliente().getNombre());
            ps.setDate(4, Date.valueOf(aparato.getFechaIngreso()));
          //  ps.setDate(5, aparato.getFechaegreso());
            ps.setDate(5, Date.valueOf(aparato.getFechaEgreso()));
            
            ps.executeUpdate();
            
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el aparato por dueño: " + ex.getMessage());
        }
    }
    
    public Aparato buscarAparato(int id){
    
        Aparato aparato=null;
    try {
            
            String sql = "SELECT * FROM aparato WHERE id =?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                aparato = new Aparato();
                aparato.setId(rs.getInt("id"));
                aparato.setNumserie(rs.getInt("numserie"));
                aparato.setTipo(rs.getString("tipo"));
              //  aparato.setCliente(rs.getInt.("cliente");//
              
            }      
            ps.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return aparato;
    } 
    
    public List<Aparato> obtenerAparatos(){
        List<Aparato> aparatos = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM aparato;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Aparato aparato;
            Cliente cliente; 
            while(resultSet.next()){
                aparato = new Aparato();
                aparato.setId(resultSet.getInt("id"));
                aparato.setNumserie(resultSet.getInt("numserie"));
                aparato.getCliente().setDni(resultSet.getInt("cliente"));
               // aparato.setFechaingreso(resultSet.getDate("fechaingreso"));
               //arreglar tema fechas
             //   aparato.setFechaegreso(resultSet.getDate("fechaegreso"));

                aparatos.add(aparato);
            }      
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return aparatos;
    }
       
}