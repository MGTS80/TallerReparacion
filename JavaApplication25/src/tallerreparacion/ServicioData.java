/*

 */
package tallerreparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicioData {
    
    private Connection con;
    
    
    public ServicioData(Conexion conexion){
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }

    public void guardarServicio(Servicio servicio) {
        try {
            
            String sql = "INSERT INTO servicio ( nombre, descripcion, costo) VALUES ( ?, ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getCosto());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                servicio.setCodigo(rs.getInt(1));
            } else {
                System.out.println("error en guardarServicio");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un servicio: " + ex.getMessage());
        }
    }
    
    public void borrarServicio(int codigo){
    try {
            String sql = "DELETE FROM sevicio WHERE codigo =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un servicio: " + ex.getMessage());
        }
    }
    
    public void actualizarServicio(Servicio servicio){
    
        try {
            
            String sql = "UPDATE servicio SET codigo = ?, nombre = ? ,descripcion = ? , costo = ? ";
                    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, servicio.getCodigo());
            ps.setString(2, servicio.getNombre());
            ps.setString(3, servicio.getDescripcion());
            ps.setDouble(4, servicio.getCosto());
            
            ps.executeUpdate();
            
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el servicio: " + ex.getMessage());
        }
    }
    
    public Servicio buscarServicio(int codigo){
    Servicio servicio = null;
    try {
            
            String sql = "SELECT * FROM servcio WHERE codigo = ? ;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
           
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                servicio = new Servicio();
                servicio.setCodigo(resultSet.getInt("codigo"));
                servicio.setNombre(resultSet.getString("nombre"));
                servicio.setDescripcion(resultSet.getString("descripcion"));
                servicio.setCosto(resultSet.getDouble("costo"));
                 
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar un servicio: " + ex.getMessage());
        }
        
        return servicio;
    }
    
    public List<Servicio> obtenerServicios(){
       List<Servicio> servicios = new ArrayList<Servicio>();
           
        try {
            String sql = "SELECT * FROM Servicio;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Servicio servicio;
            while(resultSet.next()){
                servicio = new Servicio();
                servicio.setCodigo(resultSet.getInt("codigo"));
                servicio.setNombre(resultSet.getString("nombre"));
                servicio.setDescripcion(resultSet.getString("descripcion"));
                servicio.setCosto(resultSet.getDouble("costo"));
                
                servicios.add(servicio);
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener los servicios: " + ex.getMessage());
        }
        
        return servicios;
    }
    
}
