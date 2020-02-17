/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ta_o1
 */
public class Consultas extends Conexion{
    
    public boolean registrar(Contacto cont){
        PreparedStatement ps;
        Connection cn = conexion();
        
        String sql="Insert into agenda (nombre, apellido, correo, telefono) values (?, ?, ?, ?)";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cont.getNombre());
            ps.setString(2, cont.getApellido());
            ps.setString(3, cont.getCorreo());
            ps.setString(4, cont.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean buscar(Contacto cont){
        PreparedStatement ps;
        ResultSet rs;
        Connection cn = conexion();
        String sql = "Select * from agenda where nombre=?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cont.getNombre());
            rs = ps.executeQuery();
            
            if(rs.next()){
                cont.setNombre(rs.getString("nombre"));
                cont.setApellido(rs.getString("apellido"));
                cont.setCorreo(rs.getString("correo"));
                cont.setTelefono(rs.getString("telefono"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
    }
    
    public boolean actualizar(Contacto cont){
        PreparedStatement ps;
        Connection cn = conexion();
        
        String sql="Update agenda set apellido=?, correo=?, telefono=? where nombre=?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cont.getApellido());
            ps.setString(2, cont.getCorreo());
            ps.setString(3, cont.getTelefono());
            ps.setString(4, cont.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminar(Contacto cont){
        PreparedStatement ps;
        Connection cn = conexion();
        
        String sql="Delete from agenda where nombre = ?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cont.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
