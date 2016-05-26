/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import model.Actividad;
import persistencia.FileActividad;
import view.ViewNuevaActividad;
import persistencia.BD_Actividad;
import view.ViewTareasPorFecha;

/**
 *
 * @author Kike
 */
public class controllerTarea implements ActionListener{
    private Actividad modelo = new Actividad();
    private ViewNuevaActividad view = new ViewNuevaActividad();
    ViewTareasPorFecha viewtarea = new ViewTareasPorFecha();

    public controllerTarea(Actividad modelo, ViewNuevaActividad view,ViewTareasPorFecha viewtarea) {
        this.modelo = modelo;
        this.view = view;
        this.view.jButtonGuardar.addActionListener(this);
        this.viewtarea=viewtarea;
        this.view.btnRegresar.addActionListener(this);
    }


    
    
    
public void actionPerformed(ActionEvent e){
    if(e.getSource()==view.jButtonGuardar){
        String nombre=view.jTextFieldNombreActividad.getText();
        String descripcion=view.jTextAreaDescripcionActividad.getText();
        String valor=view.jTextFieldValorActividad.getText();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatoFecha.format(view.jDateEntrega.getDate());
        BD_Actividad registro = new BD_Actividad();
        registro.Insertaractividad(nombre, valor, descripcion,fecha);
    }
    
    if(e.getSource()==view.btnRegresar){
        view.setVisible(false);
        viewtarea.setVisible(true);
    }

}

}