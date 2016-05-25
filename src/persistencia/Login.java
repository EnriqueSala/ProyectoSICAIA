/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;
import model.Empleado;

/**
 *
 * @author Marco
 */
public class Login {
     Conexion conexion;
     
     public Login(){
         conexion = new Conexion();
     }
     
public Empleado verificarUsuario(String usuario, String contraseña){
    Empleado empleado=null;
    Connection accesoDB = conexion.getConexion();
    try{
        PreparedStatement ps = accesoDB.prepareStatement("select * from empleados where usuario=? and contraseña=?");
        ps.setString(1,usuario);
        ps.setString(2,contraseña);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            empleado = new Empleado();
            empleado.setNombre(rs.getString(1));
            empleado.setTelefono(rs.getString(2));
            empleado.setUsuario(rs.getString(3));
            empleado.setContraseña(rs.getString(4));
            empleado.setPrivilegio(rs.getString(5));
            return empleado;
            
        }
    }catch (Exception e){
    }return empleado;
    }

}
