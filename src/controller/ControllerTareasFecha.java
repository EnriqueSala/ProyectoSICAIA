/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Actividad;
import view.ViewTareasPorFecha;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.BD_Actividad;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import view.JFGrupo;
import view.ViewNuevaActividad;
/**
 *
 * @author Kike
 */
public class ControllerTareasFecha implements ActionListener{
    ViewTareasPorFecha view = new ViewTareasPorFecha();
    BD_Actividad recuperarActividades=new BD_Actividad();
    Actividad actividad= new Actividad();
    JFGrupo vistagrupo = new JFGrupo();
    
    
    public ControllerTareasFecha(ViewTareasPorFecha view, BD_Actividad recuperarActividades,JFGrupo vistagrupo){
        this.view = view;
        this.view.jButtonNuevaTarea.addActionListener(this);
        this.view.jBuscarPorFecha.addActionListener(this);
        this.vistagrupo=vistagrupo;
        this.view.btnRegresar.addActionListener(this);
    }
    public void RellenarTabla(JTable TablaActividades){
        Actividad actividad =new Actividad();
        ArrayList actividades = new ArrayList();
        SimpleDateFormat FormatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        String fecha=FormatoFecha.format(view.jFechaBuscar.getDate());
        actividades=recuperarActividades.MostrarActividades(fecha);
        DefaultTableModel modeloT= new DefaultTableModel();
        TablaActividades.setModel(modeloT);
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Valor");
        modeloT.addColumn("Fecha de entrega");
        Object[] columna = new Object[4];
        int numRegistros =actividades.size();
        for (int i = 0; i < numRegistros; i++) {
            actividad=(Actividad)actividades.get(i);
            columna[0]=actividad.getNombre();
            columna[1]=actividad.getDescripcion();
            columna[2]=actividad.getValor();
            columna[3]=actividad.getFecha_entrega();
            modeloT.addRow(columna);
        }
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==view.jButtonNuevaTarea){
            ViewNuevaActividad nuevatarea=new ViewNuevaActividad();
            Actividad actividad=new Actividad();
            controllerTarea vistaTarea=new controllerTarea(actividad,nuevatarea,view);
            nuevatarea.setVisible(true);
            view.setVisible(false);
        }
        if(e.getSource()==view.jBuscarPorFecha){
            try{
                RellenarTabla(view.jTableActividades);
            }catch(java.lang.NullPointerException ex){
                JOptionPane.showMessageDialog(null,"No seleccionó una fecha valida");
            }
        }
        
        if (e.getSource()==view.btnRegresar){
            view.setVisible(false);
            vistagrupo.setVisible(true);
        }
    
    }
}
    
