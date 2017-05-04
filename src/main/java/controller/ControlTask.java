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
import model.bd.DAOTask;
import model.pojo.BeanTask;

/**
 *
 * @author clara
 */
public class ControlTask extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            PrintWriter out = response.getWriter();
            DAOTask access = new DAOTask();
            String op = request.getParameter("action");
            
            String req;
            int id = 0;
            
            if (!op.equals("addTask")) {
                req = request.getParameter("id");
                id = Integer.parseInt(req);
            }
            
            switch (op) {
                case "addTask":
                    if (request.getParameter("task") != null) {
                        access.insertTask(request.getParameter("task"));
                    }
                    break;
                case "removeTask":
                    access.removeTask(id);
                    break;
                case "doneTask":
                    Thread.sleep(100); // sleep
                    access.removeTask(id);
                    break;
                case "start":
                    access.startTask(id);
                    break;
                case "pause":
                    access.pauseTask(id);
            }
            
            RequestDispatcher rq = request.getRequestDispatcher("app.jsp");
            rq.forward(request, response);
            
            
            
            /*if (op.equals("addTask")) {
                if (request.getParameter("task") != null) {
                    access.insertTask(request.getParameter("task"));
                    RequestDispatcher rq = request.getRequestDispatcher("app.jsp");
                    rq.forward(request, response);
                }
            } else 
            if (op.equals("removeTask")) {
                String req = request.getParameter("id");
                int id = Integer.parseInt(req);
                access.removeTask(id);
                RequestDispatcher rq = request.getRequestDispatcher("app.jsp");
                rq.forward(request, response);
            }*/
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
