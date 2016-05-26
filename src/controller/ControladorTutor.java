/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Asistencia;
import model.Empleado;
import persistencia.Login;
import persistencia.RecuperarTutorAsistenciaHijo;
import view.JFLogin;
import view.JFMaestro;
import view.JFTutor;
import view.JFTutorAsistenciasHijo;

/**
 *
 * @author Marco
 */
public class ControladorTutor implements ActionListener{
    JFTutor vistatutor= new JFTutor();
    Login usuariotutor= new Login();
    Empleado empleado = new Empleado();
    String alumno;
    JFLogin vistalogin = new JFLogin();
    
    public ControladorTutor(JFTutor vistatutor, Login usuariotutor, String alumno,JFLogin vistalogin){
        this.vistatutor=vistatutor;
        this.usuariotutor=usuariotutor;
        this.alumno=alumno;
        this.vistatutor.btn.addActionListener(this);
        this.vistalogin=vistalogin;
        this.vistatutor.btnRegresar.addActionListener(this);
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource()==vistatutor.btn){
        RecuperarTutorAsistenciaHijo recuperar = new RecuperarTutorAsistenciaHijo();
        
        JFTutorAsistenciasHijo vista = new JFTutorAsistenciasHijo();
        
        ControladorTutorAsistenciasHijo controlador = new ControladorTutorAsistenciasHijo(vista,recuperar,alumno,vistatutor);
        controlador.RellenarTabla(vista.TablaAsistencias);
        vista.setVisible(true);
        vistatutor.setVisible(false);
        }
        
        if(e.getSource()==vistatutor.btnRegresar){
            vistatutor.setVisible(false);
            
            JFLogin vistalogin=new JFLogin();
            Login usuariologin = new Login();
            ControladorLogin controladorlogin = new ControladorLogin(vistalogin, usuariologin);
            vistalogin.setVisible(true);
            vistalogin.setLocationRelativeTo(null);
        }
        
    }
    
    
}