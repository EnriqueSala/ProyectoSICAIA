/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import model.Empleado;
import persistencia.HoraConexiones;
import persistencia.Login;
import persistencia.RecuperarTutorAlumno;
import view.JFLogin;
import view.JFMaestro;
import view.JFTutor;

/**
 *
 * @author Marco
 */
public class ControladorLogin implements ActionListener{
    JFLogin vistalogin = new JFLogin();
    Login login = new Login();
    Empleado empleado = new Empleado();
    
    public ControladorLogin(JFLogin vistalogin, Login login){
        this.vistalogin=vistalogin;
        this.login=login;
        this.vistalogin.btnIngresar.addActionListener(this);
    }
    
    public void InicializarLogin(){
        
    }
    
    public void actionPerformed(ActionEvent e){
        String usuario=vistalogin.txtUsuario.getText();
        String contraseña=vistalogin.txtContraseña.getText();
        
        empleado=login.verificarUsuario(usuario, contraseña);
        
        if(empleado==null){
            JOptionPane.showMessageDialog(vistalogin, "Datos incorrectos");
            
            
        }else if("maestro".equals(empleado.getPrivilegio())){
            JOptionPane.showMessageDialog(vistalogin, "Datos correctos");
        
            JFMaestro vistamaestro= new JFMaestro();
            ControladorMaestro controladormaestro = new ControladorMaestro(vistamaestro, login);
            controladormaestro.recuperargrupos(usuario);
            vistamaestro.lblbienvenida.setText("Bienvenido "+empleado.getNombre());
            vistamaestro.setVisible(true);
            controladormaestro.Inicializarmaestro(usuario, contraseña);
            vistamaestro.setLocationRelativeTo(null);
            vistalogin.setVisible(false);
            
            
            
        }else if("tutor".equals(empleado.getPrivilegio())){
            JOptionPane.showMessageDialog(vistalogin, "Datos correctos");
            
            JFTutor vistatutor= new JFTutor();
            vistatutor.setVisible(true);
            vistatutor.setLocationRelativeTo(null);
            RecuperarTutorAlumno recuperar = new RecuperarTutorAlumno();
            
            String alumno = recuperar.listarTutorAlumno(empleado.getNombre());
            ControladorTutor controladortutor = new ControladorTutor(vistatutor, login, alumno);
            
            
            
            Date d = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH));
            String año = Integer.toString(c.get(Calendar.YEAR));
            String horas = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
            String minutos = Integer.toString(c.get(Calendar.MINUTE));
            HoraConexiones conexiones = new HoraConexiones();
            conexiones.AgregarConexion(dia, mes, año, horas, minutos, empleado.getNombre());
            
            
            
            
            vistalogin.setVisible(false);
        }
    }
    
}
