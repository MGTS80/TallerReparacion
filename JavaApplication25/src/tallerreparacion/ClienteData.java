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

public class ClienteData {
    
    private Connection con;
    
    public ClienteData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
        }
    
    
    public void guardarCliente(Cliente cliente){
        try {
            
            String sql = "INSERT INTO cliente ( dni, nombre, domicilio, celular) VALUES ( ? , ? , ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setInt(4, cliente.getCelular());
                  
            ps.executeUpdate();
            
            /*ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.setDni(rs.getInt(1));
                System.out.println("EN EL IF de insertar un cliente");
            } else {
                System.out.println("EN EL ELSE de insertar un cliente");
            }*/
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
    }
    
    public void actualizarCliente(Cliente cliente){
    
        try {
            
            String sql = "UPDATE cliente SET dni = ? , nombre = ?,  domicilio = ? , celular = ?";
                    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setInt(4, cliente.getCelular());
            
            ps.executeUpdate();
            
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el cliente: " + ex.getMessage());
        }
    }
    
    public Cliente buscarCliente(int dni){
    Cliente cliente = null;
    try {
            
            String sql = "SELECT * FROM cliente WHERE dni = ? ;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
           
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setDomicilio(resultSet.getString("domicilio"));
                cliente.setCelular(resultSet.getInt("celular"));

                
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al busca un cliente: " + ex.getMessage());
        }
        
        return cliente;
    }
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
           
        try {
            String sql = "SELECT * FROM Cliente;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Cliente cliente;
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setDomicilio(resultSet.getString("domicilio"));
                cliente.setCelular(resultSet.getInt("celular"));
                

                clientes.add(cliente);
            }      
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return clientes;
    }
    
    public void borrarCliente(int dni){
    try {
            String sql = "DELETE FROM cliente WHERE dni =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar cliente: " + ex.getMessage());
        }
    }
      
}

