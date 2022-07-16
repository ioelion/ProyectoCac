/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/checkuser"})
public class checkuser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset-UTF-8");
        
        try(PrintWriter out = response.getWriter()) {
            Persistencia base = new Persistencia();
            ResultSet rs = base.consultaSQL("select * from usuarios where usuario = " + "'" + request.getParameter("inputEmail") 
            + "'" + " and clave = " + "'" + request.getParameter("inputPassword") + "'"
            );
            
            if(rs == null){
                out.println("Las credenciales ingresadas no son válidas");
            } else {
                if(rs.first()==false){
                    out.println("Las credenciales ingresadas no son válidas");
                    out.println("<h1>Proyecto: " + request.getContextPath()+"<h1>");
                    out.println("<h1>Usuario: " + request.getParameter("inputEmail")+"<h1>");
                } else {
                    out.println(rs.getString("usuario"));
                    out.println(rs.getString("nombreyapellido")+"<BR>");
                }
            }

            
        
        }catch (Exception ex){
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
