/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Asistencia;
import persistencia.RecuperarTutorAsistenciaHijo;
import view.JFTutorAsistenciasHijo;

/**
 *
 * @author Marco
 */
public class ControladorTutorAsistenciasHijo {
    JFTutorAsistenciasHijo vista = new JFTutorAsistenciasHijo();
    RecuperarTutorAsistenciaHijo recuperar = new RecuperarTutorAsistenciaHijo();
    String alumno;
    
    public ControladorTutorAsistenciasHijo(JFTutorAsistenciasHijo vista, RecuperarTutorAsistenciaHijo recuperar,String alumno){
        this.vista=vista;
        this.recuperar=recuperar;
        this.alumno=alumno;
        
    }
    
    
    public void RellenarTabla(JTable TablaAsistencias){
        ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
        asistencias = recuperar.listarAsistencia(alumno);
        Asistencia asistencia = new Asistencia();
        
        DefaultTableModel modeloT = new DefaultTableModel();
        TablaAsistencias.setModel(modeloT);
        
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellidos");
        modeloT.addColumn("Grado");
        modeloT.addColumn("Grupo");
        modeloT.addColumn("Asignatura");
        modeloT.addColumn("asistencia");
        modeloT.addColumn("dia");
        modeloT.addColumn("mes");
        modeloT.addColumn("año");
        
        Object[] columna = new Object[9];
        
        int cantidad = asistencias.size();
        
        
        
        for(int i=0; i<cantidad; i++)
        {
            
            asistencia = (Asistencia) asistencias.get(i);
            
            columna[0] = asistencia.getNombre();
            columna[1] = asistencia.getApellidos();
            columna[2] = asistencia.getGrado();
            columna[3] = asistencia.getGrupo();
            columna[4] = asistencia.getAsignatura();
            columna[5] = asistencia.getAsistencia();
            columna[6] = asistencia.getDia();
            columna[7] = asistencia.getMes();
            columna[8] = asistencia.getAño();
            
            modeloT.addRow(columna);
        }    

    }
    
}
