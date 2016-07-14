/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZDanny
 */
public class Normalizer {
    
    Coneccion con;

    public Normalizer() throws SQLException {
        con = new Coneccion();
        
        ResultSet resp = execQuery("SELECT * FROM album", con);
        for (int i = 0; i < 1; i++) {
            System.out.println(resp.getString("")); 
        }
    }
    
    public ResultSet execQuery(String query, Coneccion con) throws SQLException{
        ResultSet resp = null;
        try {
            Statement stmt = con.getConection().createStatement();
            //String set = "INSERT INTO " + table + " VALUES(" + data + ")";
            resp=stmt.executeQuery(query);
            
            //resp.getString(query);
        } catch (SQLException ex) {
            Logger.getLogger(FillData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    public static void main(String[] args) throws SQLException{
        Normalizer norm = new Normalizer();
    }
    
}
