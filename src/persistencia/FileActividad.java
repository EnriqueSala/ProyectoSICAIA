/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import model.Actividad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Kike
 */
public class FileActividad {
    public void AgregarActividad(Actividad actividad){
        String sActividad=actividad.toString();
        File fActividad = new File("actividad.txt");
		try {
			if(!fActividad.exists()){
				fActividad.createNewFile();
			}
			FileWriter fwProduct = new FileWriter(fActividad,true);
			BufferedWriter bwProduct = new BufferedWriter(fwProduct);
			bwProduct.write(sActividad + "\n");
			bwProduct.close();
		}
		catch(IOException ioe){
		  // Dear programmer put this magical code here, please. Xoxo.
		}
    }
    
}
