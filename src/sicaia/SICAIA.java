/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sicaia;

import controller.ControladorLogin;
import persistencia.Conexion;
import persistencia.Login;
import view.JFLogin;

/**
 *
 * @author Marco
 */
public class SICAIA {

    public static void main(String[] args) {
        JFLogin vistalogin = new JFLogin();
        Login usuariologin = new Login();
        ControladorLogin controladorlogin = new ControladorLogin(vistalogin, usuariologin);
        vistalogin.setVisible(true);
        vistalogin.setLocationRelativeTo(null);
    }
    
}
