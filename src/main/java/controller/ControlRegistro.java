/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bd.DAOUser;
import model.pojo.BeanUser;

/**
 *
 * @author clara
 */
public class ControlRegistro extends HttpServlet {

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
            String finalMessage = "";
            
            if (op.equals("insertUser")) {
                BeanUser user = (BeanUser) request.getAttribute("bean_signup");
                ValidatorUtil valid = new ValidatorUtil();
                if (valid.validateUsername(user.getUsername()) && valid.validateMail(user.getEmail()) && valid.validatePassword(user.getPassword())) {
                    out.println("Signed up successfully.");
                    access.insertUser(user);
                }else if(!valid.validateUsername(user.getUsername())){
                      String messageUsername = "Wrong username, try again";
                      
                      request.setAttribute("wop", messageUsername);
                      RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                      rd.forward(request, response);
                      
                }else if(!valid.validateMail(user.getEmail())){
                      String messageUsername = "Wrong email, try again";
                
                }else{
                      String messageUsername = "Wrong password, try again";
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
