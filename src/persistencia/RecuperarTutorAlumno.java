/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Alumno;

/**
 *
 * @author Marco
 */
public class RecuperarTutorAlumno {
    Conexion conexion;
    
    public RecuperarTutorAlumno(){
        conexion = new Conexion();
    }
    
    
    public String listarTutorAlumno(String tutor){
       String nombre = new String();
       Alumno alumno;
       
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ps = accesoBD.prepareStatement("select * from gruposyalumnos where tutor=" + "'"+tutor+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setNombre(rs.getString(1));
                nombre=alumno.getNombre();
                
            }
        } catch (Exception e) {
        }
        return nombre       ;
    }
}
