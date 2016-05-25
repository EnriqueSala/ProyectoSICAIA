/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class HoraConexiones {
    Conexion conexion;
    
    public HoraConexiones(){
        conexion = new Conexion();
    }
    
    public void AgregarConexion(String dia, String mes, String año, String hora, String minutos, String tutor){
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement pps = accesoBD.prepareStatement("INSERT INTO conexiones(dia,mes,año,hora,minutos,tutor)VALUES(?,?,?,?,?,?)");
            pps.setString(1, dia);
            pps.setString(2, mes);
            pps.setString(3, año);
            pps.setString(4, hora);
            pps.setString(5, minutos);
            pps.setString(6, tutor);
            pps.executeUpdate();
            
        } catch (SQLException ex) {
            
        }
    }
}
