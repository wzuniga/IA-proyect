/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZDanny
 */
public class FillData {
    Coneccion cn;

    public void fill(String name,String extention, String table){
        try {
            cn = new Coneccion();
            Connection ct = cn.getConection();
            
            String filename = name+extention;
            String workingDirectory = System.getProperty("user.dir");
			
            File file = new File(workingDirectory, filename);
            System.out.println(file.getAbsolutePath());
            Scanner sc = new Scanner(file);
            
            ArrayList<String[]> arr = new ArrayList<String[]>();
            
            while(sc.hasNext()){
                String [] temp = sc.nextLine().split("-");
                arr.add(temp);
            }
            
            fillData(arr, table, ct);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FillData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fillData(ArrayList<String[]> arr,String table, Connection ct){
        for (int i = 0; i < arr.size(); i++) {
            String [] temp = arr.get(i);
            String data = "\"" + Arrays.toString(temp).replace(", ", "\",\"").replaceAll("[\\[\\]]", "") + "\"";
            
            try {
                Statement stmt = ct.createStatement();
                String set = "INSERT INTO "+table+" VALUES("+data+")";
                System.out.println(set);
                stmt.executeUpdate(set);
            } catch (SQLException ex) {
                Logger.getLogger(FillData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        FillData fd = new FillData();
        //fd.fill("Album", ".txt", "album");
        //fd.fill("Artista", ".txt", "artista");
        //fd.fill("Genero", ".txt", "genero");
        //fd.fill("Cancion", ".txt", "cancion");
        //fd.fill("Reproduccion", ".txt", "reproduccion");
    }
}
