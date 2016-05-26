/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import model.Correo;
import view.JFCorreo;
import view.JFGrupo;

/**
 *
 * @author Marco
 */
public class ControladorCorreo implements ActionListener{
   
    JFCorreo vistaCorreo = new JFCorreo();
    Correo c = new Correo();
    ArrayList<String> correos = new ArrayList<String>();
    JFGrupo vistagrupo = new JFGrupo();
    
    public ControladorCorreo(JFCorreo vistaCorreo,Correo c, ArrayList<String> correos,JFGrupo vistagrupo){
        this.vistaCorreo = vistaCorreo;
        this.c=c;
        this.vistaCorreo.btnEnviar.addActionListener(this);
        this.correos=correos;
        this.vistagrupo=vistagrupo;
        this.vistaCorreo.btnRegresar.addActionListener(this);
        
    }
    
    public boolean enviarCorreo(Correo c){
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
            p.setProperty("mail.smtp.auth", "true");
            
            
            Session s = Session.getDefaultInstance(p, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMensaje());
            BodyPart adjunto = new MimeBodyPart();
            
            if(!c.getRutaArchivo().equals("")){
                adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
                adjunto.setFileName(c.getNombreArchivo());
            }
            
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            
            if(!c.getRutaArchivo().equals("")){
                m.addBodyPart(adjunto);
            }
            
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
            mensaje.setSubject(c.getAsunto());
            mensaje.setContent(m);
            
            Transport t = s.getTransport("smtp");
            t.connect(c.getUsuarioCorreo(), c.getContraseña());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de contar con una conexion a internet segura");
            return false;
        }
    }
    
    public void enviar(){
            
            int cantidad = correos.size();
            
            for(int i=0;i<cantidad;i++){
                
            c.setContraseña("lnmijkimwhasfmna");
            c.setUsuarioCorreo("marcostarr1940@gmail.com");
            c.setAsunto(vistaCorreo.txtAsunto.getText());
            c.setMensaje(vistaCorreo.txtMensaje.getText());
            
            //if(correos.get(i)==null){
            
            c.setDestino(correos.get(i));
            c.setNombreArchivo("");
            c.setRutaArchivo("");
            
            
            
            
            if(enviarCorreo(c)){
               
            }else{
            
            }
            
            //}
            
            
            
        
            }
            
        }
    
    public void actionPerformed (ActionEvent e){
        
        if(e.getSource()==vistaCorreo.btnEnviar){
        enviar();
        }
        
        if (e.getSource()==vistaCorreo.btnRegresar){
            vistaCorreo.setVisible(false);
            vistagrupo.setVisible(true);
        }
    }
    
}
