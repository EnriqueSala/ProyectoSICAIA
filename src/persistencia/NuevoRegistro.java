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
public class NuevoRegistro {
    
    Conexion conexion;
    
    public NuevoRegistro(){
        conexion = new Conexion();
    }
    
    public void AgregarRegistro(){
        
        try {
            Connection accesoBD = conexion.getConexion();
            PreparedStatement pps = accesoBD.prepareStatement("INSERT INTO usuario(Nombre,Apellidos,Edad,Correo)VALUES(?,?,?,?)");
            pps.setString(1, "Lo que vayan a dar de informacion");
            pps.setString(2, "Lo que vayan a dar de informacion");
            pps.setString(3, "Lo que vayan a dar de informacion");
            pps.setString(4, "Lo que vayan a dar de informacion");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Guardados");
        } catch (SQLException ex) {
            
        }
    }
    
    
    
}
