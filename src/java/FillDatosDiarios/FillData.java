/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FillDatosDiarios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author ZDanny
 */

@WebServlet("/FillData")
public class FillData extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        JSONObject jObj;
        try {
            jObj = new JSONObject(request.getParameter("id")); // this parses the json
            
            //Iterator it = jObj.keys();
            System.out.println(jObj.get("id"));
            
        } catch (JSONException ex) {
            Logger.getLogger(FillData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
