/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Marco
 */
public class NuevaAsistencia {
    Conexion conexion;
    
    public NuevaAsistencia(){
        conexion = new Conexion();
    }
    
    
    public void AgregarAsistencia(String nombre, String apellidos, String grado, String grupo, String asignatura, String asistencia, String dia, String mes, String año){
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement pps = accesoBD.prepareStatement("INSERT INTO asistencia(nombre,apellidos,grado,grupo,asignatura,asistencia,dia,mes,año)VALUES(?,?,?,?,?,?,?,?,?)");
            pps.setString(1, nombre);
            pps.setString(2, apellidos);
            pps.setString(3, grado);
            pps.setString(4, grupo);
            pps.setString(5, asignatura);
            pps.setString(6, asistencia);
            pps.setString(7, dia);
            pps.setString(8, mes);
            pps.setString(9, año);
            pps.executeUpdate();
            
        } catch (SQLException ex) {
            
        }
    }
    
}
