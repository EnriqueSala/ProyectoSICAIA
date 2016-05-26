/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Alumno;
import model.Correo;
import persistencia.BD_Actividad;
import persistencia.RecuperarAlumnos;
import persistencia.RecuperarCorreos;
import view.JFAsistencia;
import view.JFCorreo;
import view.JFGrupo;
import view.JFMaestro;
import view.JFVerAlumnos;
import view.ViewTareasPorFecha;

/**
 *
 * @author Marco
 */
public class ControladorGrupo implements ActionListener{
    
    JFGrupo vistagrupo = new JFGrupo();
    String grado, grupo, asignatura;
    JFMaestro vistamaestro = new JFMaestro();
    
    
    
    
    public ControladorGrupo(JFGrupo vistagrupo, String seleccionado, String grado, String grupo, String asignatura, JFMaestro vistamaestro){
        this.vistagrupo=vistagrupo;
        this.vistagrupo.Veralumnos.addActionListener(this);
        this.vistagrupo.Tomarasistencia.addActionListener(this);
        this.vistagrupo.MandarCorreo.addActionListener(this);
        this.vistagrupo.AgregarTarea.addActionListener(this);
        this.vistagrupo.btnRegresarr.addActionListener(this);
        vistagrupo.grupo.setText(seleccionado);
        this.grado=grado;
        this.grupo=grupo;
        this.asignatura=asignatura;
        this.vistamaestro=vistamaestro;
        
    }
    
    
    
    
    
    public void actionPerformed (ActionEvent e){
        
        if (e.getSource()== vistagrupo.Veralumnos){
            JFVerAlumnos vistaalumnos = new JFVerAlumnos();
            RecuperarAlumnos recuperar = new RecuperarAlumnos();
            ControladorVerAlumnos controlador= new ControladorVerAlumnos(vistaalumnos, recuperar, grado, grupo, asignatura,vistagrupo);
            
            controlador.RellenarTabla(vistaalumnos.TablaAlumnos);
            
            
            vistaalumnos.setVisible(true);
            vistagrupo.setVisible(false);
            
            
            
            
        }
        
        
        if (e.getSource()== vistagrupo.Tomarasistencia){
            JFAsistencia vistaasistencia = new JFAsistencia();
            RecuperarAlumnos recuperar = new RecuperarAlumnos();
            ControladorAsistencia controlador= new ControladorAsistencia(vistaasistencia, recuperar, grado, grupo, asignatura,vistagrupo);
            
            controlador.RellenarTabla(vistaasistencia.TablaAsistencia);
            vistaasistencia.setVisible(true);
            vistagrupo.setVisible(false);
            
            
        }
        
        
        
        if (e.getSource()==vistagrupo.MandarCorreo){
            JFCorreo vistacorreo = new JFCorreo();
            Correo c = new Correo();
            
            RecuperarAlumnos recuperar = new RecuperarAlumnos();
            ArrayList<Alumno> alumnos = recuperar.listaralumnos(grado, grupo, asignatura);
            
            RecuperarCorreos correos = new RecuperarCorreos();
            ArrayList<String> listaCorreos = new ArrayList<String>();
            
            int cantidad = alumnos.size();
           
            
            for(int i=0;i<cantidad;i++){
                String tutor = alumnos.get(i).getTutor();
                String correo = correos.listarCorreos(tutor);
                listaCorreos.add(correo);
                
            }
            
            ControladorCorreo controlador = new ControladorCorreo(vistacorreo,c,listaCorreos,vistagrupo);
            
            
            
            
            
            
            
            
            vistacorreo.setVisible(true);
            vistagrupo.setVisible(false);
            vistacorreo.setLocationRelativeTo(null);
        }
        
        
        if(e.getSource()==vistagrupo.AgregarTarea){
            BD_Actividad bd= new BD_Actividad();
            ViewTareasPorFecha vista = new ViewTareasPorFecha();
            ControllerTareasFecha controlador = new ControllerTareasFecha(vista,bd,vistagrupo);
            vista.setVisible(true);
            vistagrupo.setVisible(false);
            
            
            
        }
        
        if (e.getSource()==vistagrupo.btnRegresarr){
            vistagrupo.setVisible(false);
            vistamaestro.setVisible(true);
            
            
            
            
        }
        
        
    }
}
