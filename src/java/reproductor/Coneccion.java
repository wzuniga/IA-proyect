/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ZDanny
 */
public class Coneccion {
    
    Connection con = null;
    String user = "root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/ia_data";
    
    public Coneccion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, "No se puede", e);
        }
    }
    
    //Metodo que nos retorna la coneccion
    public Connection getConection(){
        return con;
    }
    
    //Metodo que desconecta de la base de datos
    public boolean desconectar(){
        boolean val = false;
        try {
            con.close();
            val = true;
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return val;
        }
    }
    
    public static void main(String [] args){
        Coneccion cn = new Coneccion();
    }
    
}
