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
import model.Empleado;
import model.Grupo;
import persistencia.Login;
import persistencia.RecuperarGrupos;
import view.JFGrupo;
import view.JFLogin;
import view.JFMaestro;

/**
 *
 * @author Marco
 */
public class ControladorMaestro implements ActionListener{
    JFMaestro vistamaestro= new JFMaestro();
    Login usuariomaestro= new Login();
    Empleado empleado = new Empleado();
    String usuario,contraseña, maestro;
    

    public ControladorMaestro(JFMaestro vistamaestro, Login usuariomaestro){
        this.vistamaestro=vistamaestro;
        this.usuariomaestro=usuariomaestro;
        this.vistamaestro.btngrupo.addActionListener(this);
        this.vistamaestro.btn.addActionListener(this);
       
       
        
    }
    
    public void Inicializarmaestro(String usuario, String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.maestro=usuario;
    }
    
    public void recuperargrupos(String maestro){
        RecuperarGrupos gru=new RecuperarGrupos();
        ArrayList grupos = gru.listargrupos(maestro);
        Grupo grupo = new Grupo();
        
        int tamaño = grupos.size();
        
        for (int i=0;i<tamaño;i++){
            grupo = (Grupo) grupos.get(i);
            vistamaestro.cbogrupos.addItem(grupo.getGrado()+" "+ grupo.getGrupo()+ " " + grupo.getAsignatura());
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource()==vistamaestro.btngrupo){
        JFGrupo vistagrupo = new JFGrupo();
        String seleccionado = (String)vistamaestro.cbogrupos.getSelectedItem();
        String[] datos = seleccionado.split(" ");
        String grado = datos[0];
        String grupo = datos[1];
        String asignatura = datos[2];
        ControladorGrupo controladorgrupo= new ControladorGrupo(vistagrupo, seleccionado, grado, grupo, asignatura,vistamaestro);
        vistagrupo.setVisible(true);
        vistagrupo.setLocationRelativeTo(null);
        vistamaestro.setVisible(false);
        }
        
        if (e.getSource()==vistamaestro.btn){
            
            
            vistamaestro.setVisible(false);
            
            JFLogin vistalogin=new JFLogin();
            Login usuariologin = new Login();
            ControladorLogin controladorlogin = new ControladorLogin(vistalogin, usuariologin);
            vistalogin.setVisible(true);
            vistalogin.setLocationRelativeTo(null);
        }
        
    }
    
    
}
