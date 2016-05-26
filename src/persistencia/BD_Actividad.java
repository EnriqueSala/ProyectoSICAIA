/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Actividad;
import java.util.ArrayList;
/**
 *
 * @author Kike
 */
public class BD_Actividad {
    Conexion conexion;
    public BD_Actividad() {
    conexion=new Conexion();
}
    public void Insertaractividad(String nombre, String valor, String descripcion, String fecha){
        try{
        Connection accesoBD = conexion.getConexion();
        PreparedStatement pps = accesoBD.prepareStatement("INSERT INTO"
                + " actividad(Nombre,Valor,Descripcion,Fecha_entrega)VALUES(?,?,?,?)");
            pps.setString(1, nombre);
            pps.setString(2, valor);
            pps.setString(3, descripcion);
            pps.setString(4, fecha);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error " + ex);
        
    }
    }
    public ArrayList<Actividad> MostrarActividades(String fecha){
        ArrayList<Actividad> listaActividades= new ArrayList<Actividad>();
        Actividad actividad;
        try{
            Connection accesoBD = conexion.getConexion();
            PreparedStatement ppsalta = accesoBD.prepareStatement("SELECT * FROM"+
                    " actividad WHERE Fecha_entrega BETWEEN "+ "'"+fecha+" 00:00:00.000000"+"' AND '"+fecha+" 23:59:59.999999'");
                    ResultSet rs = ppsalta.executeQuery();
                    while(rs.next()){
                        actividad = new Actividad();
                        actividad.setNombre(rs.getString(1));
                        actividad.setValor(rs.getString(2));
                        actividad.setDescripcion(rs.getString(3));
                        actividad.setCalificacion(rs.getInt(4));
                        actividad.setRetroalimentacion(rs.getString(5));
                        actividad.setFecha_entrega(rs.getString(7));
                        listaActividades.add(actividad);
                    }
                    
        } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error " + ex);
        }
        return listaActividades;
    }
}
