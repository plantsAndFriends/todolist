/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bd.DAOUser;
import model.pojo.BeanUser;
import model.bd.Bd;

/** Controlador del login.
 * 
 *  Aquesta classe hereta HttpServlet.
 *  S'arribarà a aquest controlador mitjançant el jsp "login.jsp", on podran 
 *  passar tres coses:
 * 
 *  1. Es tracti d'un login: on es crearà una sessió i es validaran les credencials
 *     de l'usuari amb el mètode validateUser(BeanUser user) del model DAOUser, 
 *     on es comprova si aquell email i aquella password existeixen. 
 *     Si les dades són vàlides, l'usuari serà dirigit a l'aplicació.
 *     Sinó, s'enviarà al formulari de login un missatge d'error.
 *  
 *  2. Es tracti d'un logout: on es farà invàlida la sessió i es portarà a 
 *     l'usuari a la pàgina inicial de l'aplicació.
 * 
 *  3. Hi hagi algun error: on se li mostrarà a l'usuari un missatge d'error 
 *     friendly.
 *
 * @author clara
 */
public class ControlLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            DAOUser access = new DAOUser();
            String op = request.getParameter("action");
            
            if (op.equals("loginUser")) {
                BeanUser user = (BeanUser) request.getAttribute("bean_signin");
                if (access.validateUser(user)) {
                    request.getSession().setAttribute("sessusername", access.getUserByEmail(user.getEmail()).getUsername());
                    request.getSession().setAttribute("sessid", access.getUserByEmail(user.getEmail()).getId());
                    RequestDispatcher rd = request.getRequestDispatcher("app.jsp");
                    rd.forward(request, response);
                } else {
                    request.getSession().setAttribute("mssLogin", "We're sorry! Wrong authentication!");
                    response.sendRedirect(request.getHeader("referer"));
                }
            } else {
                if (op.equals("logout")) {
                    request.getSession().invalidate();
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Some kind of error happened when you were chillin'");
            throw new ServletException(e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
