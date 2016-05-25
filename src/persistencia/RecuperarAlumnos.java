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

/**
 *
 * @author Marco
 */
public class RecuperarAlumnos {
    Conexion conexion;
    
    public RecuperarAlumnos(){
        conexion = new Conexion();
    }
    
    public ArrayList<Alumno> listaralumnos(String grado, String grupo, String asignatura){
       ArrayList listaalumnos = new ArrayList();
       Alumno alumno;
       
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ps = accesoBD.prepareStatement("select * from gruposyalumnos where grado=" + "'"+grado+"'" + "and grupo="+"'"+grupo+"'" + "and asignatura="+"'"+asignatura+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setNombre(rs.getString(1));
                alumno.setApellidos(rs.getString(2));
                alumno.setGrado(rs.getString(3));
                alumno.setGrupo(rs.getString(4));
                alumno.setAsignatura(rs.getString(5));
                alumno.setTutor(rs.getString(6));
                listaalumnos.add(alumno);
                
            }
        } catch (Exception e) {
        }
        return listaalumnos;
    }
    
}
