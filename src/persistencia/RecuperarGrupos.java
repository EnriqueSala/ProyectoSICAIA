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
import model.Grupo;

/**
 *
 * @author Marco
 */
public class RecuperarGrupos {
    Conexion conexion;
    
    public RecuperarGrupos(){
        conexion = new Conexion();
    }
    
    public ArrayList<Grupo> listargrupos(String maestro){
       ArrayList listagrupos = new ArrayList();
       Grupo grupo;
       
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ps = accesoBD.prepareStatement("select * from grupos where maestro="+"'"+maestro+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                grupo = new Grupo();
                grupo.setGrado(rs.getString(1));
                grupo.setGrupo(rs.getString(2));
                grupo.setMaestro(rs.getString(3));
                grupo.setAsignatura(rs.getString(4));
                listagrupos.add(grupo);
                
            }
        } catch (Exception e) {
        }
        return listagrupos;
    }
}
