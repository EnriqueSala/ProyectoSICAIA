/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Alumno;
import model.Empleado;

/**
 *
 * @author Marco
 */
public class RecuperarCorreos {
    Conexion conexion;
    
    public RecuperarCorreos(){
        conexion = new Conexion();
    }
    
    public String listarCorreos(String tutor){
       String Correo = new String();
       Empleado empleado;
       
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ps = accesoBD.prepareStatement("select * from empleados where nombre=" + "'"+tutor+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                empleado = new Empleado();
                
                empleado.setCorreo(rs.getString(6));
                Correo=empleado.getCorreo();
                
            }
        } catch (Exception e) {
        }
        return Correo;
    }
    
}
