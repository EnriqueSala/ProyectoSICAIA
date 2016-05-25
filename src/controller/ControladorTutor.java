/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Empleado;
import persistencia.Login;
import view.JFMaestro;
import view.JFTutor;

/**
 *
 * @author Marco
 */
public class ControladorTutor implements ActionListener{
    JFTutor vistatutor= new JFTutor();
    Login usuariotutor= new Login();
    Empleado empleado = new Empleado();
    String usuario,contraseña,privilegio;
    
    public ControladorTutor(JFTutor vistatutor, Login usuariotutor){
        this.vistatutor=vistatutor;
        this.usuariotutor=usuariotutor;
       
    }
    
    public void Inicializartutor(String usuario, String contraseña,String privilegio){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.privilegio=privilegio;
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    
}