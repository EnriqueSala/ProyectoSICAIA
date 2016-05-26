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
import model.Asistencia;

/**
 *
 * @author Marco
 */
public class RecuperarTutorAsistenciaHijo {
    Conexion conexion;
    
    public RecuperarTutorAsistenciaHijo(){
        conexion = new Conexion();
    }
    
    
    public ArrayList<Asistencia> listarAsistencia(String alumno){
       ArrayList listaAsistencia = new ArrayList();
       Asistencia asistencia;
       
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ps = accesoBD.prepareStatement("select * from asistencia where nombre="+"'"+alumno+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                asistencia = new Asistencia();
                asistencia.setNombre(rs.getString(1));
                asistencia.setApellidos(rs.getString(2));
                asistencia.setGrado(rs.getString(3));
                asistencia.setGrupo(rs.getString(4));
                asistencia.setAsignatura(rs.getString(5));
                asistencia.setAsistencia(rs.getString(6));
                asistencia.setDia(rs.getString(7));
                asistencia.setMes(rs.getString(8));
                asistencia.setAño(rs.getString(9));
                listaAsistencia.add(asistencia);
                
            }
        } catch (Exception e) {
        }
        return listaAsistencia;
    }
    
    
}
