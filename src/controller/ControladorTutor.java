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
    
    public ControladorTutor(JFTutor vistatutor, Login usuariotutor, String alumno){
        this.vistatutor=vistatutor;
        this.usuariotutor=usuariotutor;
        this.alumno=alumno;
        this.vistatutor.btn.addActionListener(this);
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        RecuperarTutorAsistenciaHijo recuperar = new RecuperarTutorAsistenciaHijo();
        
        JFTutorAsistenciasHijo vista = new JFTutorAsistenciasHijo();
        
        ControladorTutorAsistenciasHijo controlador = new ControladorTutorAsistenciasHijo(vista,recuperar,alumno);
        controlador.RellenarTabla(vista.TablaAsistencias);
        vista.setVisible(true);
        
    }
    
    
}