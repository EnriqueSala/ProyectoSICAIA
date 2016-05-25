/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;
/**
 *
 * @author Marco
 */
public class Conexion {
    
    public Conexion(){    
    }
    
    public Connection getConexion(){
        Connection con=null;
        try{
            /*Carga|Registra el driver JDBC */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Obtener la conexion*/
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sicaia","root","");
        }catch(SQLException ex){
        }catch(Exception e){
        }
        return con;
    }
}
