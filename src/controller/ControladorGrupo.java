/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import persistencia.RecuperarAlumnos;
import view.JFGrupo;
import view.JFVerAlumnos;

/**
 *
 * @author Marco
 */
public class ControladorGrupo implements ActionListener{
    
    JFGrupo vistagrupo = new JFGrupo();
    String grado, grupo, asignatura;
    
    
    
    
    public ControladorGrupo(JFGrupo vistagrupo, String seleccionado, String grado, String grupo, String asignatura){
        this.vistagrupo=vistagrupo;
        this.vistagrupo.Veralumnos.addActionListener(this);
        this.vistagrupo.Tomarasistencia.addActionListener(this);
        vistagrupo.grupo.setText(seleccionado);
        this.grado=grado;
        this.grupo=grupo;
        this.asignatura=asignatura;
        
    }
    
    
    
    
    
    public void actionPerformed (ActionEvent e){
        
        if (e.getSource()== vistagrupo.Veralumnos){
            JFVerAlumnos vistaalumnos = new JFVerAlumnos();
            RecuperarAlumnos recuperar = new RecuperarAlumnos();
            ControladorVerAlumnos controlador= new ControladorVerAlumnos(vistaalumnos, recuperar, grado, grupo, asignatura);
            
            controlador.RellenarTabla(vistaalumnos.TablaAlumnos);
            vistaalumnos.setVisible(true);
            
            
        }
        
        if (e.getSource()==vistagrupo.Tomarasistencia){
                JOptionPane.showMessageDialog(vistagrupo, "Datos correctos :D");
        
        }
        
        
    }
}
