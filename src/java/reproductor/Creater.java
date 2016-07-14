/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author ZDanny
 */
public class Creater {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File canciones = new File ("Cancion.txt");
        
        FileReader fr = new FileReader (canciones);
        BufferedReader br = new BufferedReader(fr);
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Reproduccion1.txt");
            pw = new PrintWriter(fichero);
            String cadena;
            int i = 0;
            Random rd = new Random();
            while((cadena = br.readLine())!=null) {
                pw.println(i+"-"+(i%28)+"-6"+"-2016-"+(rd.nextInt(6)+4)+"-"+((rd.nextDouble() * 20 + 80)+"").substring(0,2)+"-"+(rd.nextInt(4)+4)+"-"+(i+1));
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        br.close();
        fr.close();
    }
}
