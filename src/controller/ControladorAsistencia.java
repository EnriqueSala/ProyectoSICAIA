/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import persistencia.NuevaAsistencia;
import persistencia.RecuperarAlumnos;
import view.JFAsistencia;

/**
 *
 * @author Marco
 */
public class ControladorAsistencia implements ActionListener{
    
    JFAsistencia vistaasistencia = new JFAsistencia();
    RecuperarAlumnos recuperaralumnos = new RecuperarAlumnos();
    String grado, grupo, asignatura;
    
    
    public ControladorAsistencia(JFAsistencia vistaasistencia, RecuperarAlumnos recuperaralumnos, String grado, String grupo, String asignatura){
        this.vistaasistencia=vistaasistencia;
        this.recuperaralumnos=recuperaralumnos;
        this.grado=grado;
        this.grupo=grupo;
        this.asignatura=asignatura;
        this.vistaasistencia.btnAsistencia.addActionListener(this);
        
    }
    
    
    public void RellenarTabla(JTable TablaAsistencia){
        ArrayList alumnos = new ArrayList();
        alumnos = recuperaralumnos.listaralumnos(grado, grupo, asignatura);
        Alumno alumno = new Alumno();
        
        DefaultTableModel modeloT = new DefaultTableModel();
        TablaAsistencia.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellidos");
        modeloT.addColumn("Grado");
        modeloT.addColumn("Grupo");
        modeloT.addColumn("Asignatura");
        modeloT.addColumn("Asistencia");
        
        Object[] columna = new Object[5];
        
        int cantidad = alumnos.size();
        
        
        
        for(int i=0; i<cantidad; i++)
        {
            
            alumno = (Alumno) alumnos.get(i);
            
            columna[0] = alumno.getNombre();
            columna[1] = alumno.getApellidos();
            columna[2] = alumno.getGrado();
            columna[3] = alumno.getGrupo();
            columna[4] = alumno.getAsignatura();
            
            
            
            modeloT.addRow(columna);
        }    

    }
    
    
    public void actionPerformed(ActionEvent e){
        NuevaAsistencia nueva = new NuevaAsistencia();
        for(int i=0;i<vistaasistencia.TablaAsistencia.getRowCount();i++){
            String nombre= (String)vistaasistencia.TablaAsistencia.getValueAt(i,0);
            String apellidos= (String)vistaasistencia.TablaAsistencia.getValueAt(i,1);
            String grado= (String)vistaasistencia.TablaAsistencia.getValueAt(i,2);
            String grupo= (String)vistaasistencia.TablaAsistencia.getValueAt(i,3);
            String asignatura= (String)vistaasistencia.TablaAsistencia.getValueAt(i,4);
            String asistencia= (String)vistaasistencia.TablaAsistencia.getValueAt(i,5);
            
            Date D = new Date();
            Calendar C = new GregorianCalendar();
            C.setTime(D);
            String dia = Integer.toString(C.get(Calendar.DATE));
            String mes = Integer.toString(C.get(Calendar.MONTH));
            String año = Integer.toString(C.get(Calendar.YEAR));
            
            nueva.AgregarAsistencia(nombre, apellidos, grado, grupo, asignatura, asistencia, dia, mes, año);
            
        }
    }  
    
    
    
    
}
