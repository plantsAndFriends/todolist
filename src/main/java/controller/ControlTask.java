/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
            BeanTask task = new BeanTask();
            String op = request.getParameter("action");

            String req;
            int id = 0;

            if (!op.equals("addTask")) {
                req = request.getParameter("id");
                id = Integer.parseInt(req);
            }
            if (op.equals("addTask") || op.equals("removeTask") || op.equals("doneTask") || op.equals("start")) {
                switch (op) {
                    case "addTask":
                        if (request.getParameter("task") != null) {
                            access.insertTask(request.getParameter("task"), Integer.parseInt(request.getSession().getAttribute("sessid").toString()));
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
                    /*case "pause":
                        access.pauseTask(id);

                        Date start = access.getStartedAt(id);
                        Date pause = access.getCompletedAt(id);

                        long tt = access.totalTime(start, pause);

                        request.setAttribute("time", tt);
                        response.setContentType("text/plain");
                    response.setCharacterEncoding(("UTF-8"));
                    response.getWriter().write(op);*/
                        //request.getSession().setAttribute("time", tt);
                        //response.sendRedirect(request.getHeader("referer"));
//                        break;

                }
                RequestDispatcher rq = request.getRequestDispatcher("app.jsp");
                rq.forward(request, response);
            } else {
                access.pauseTask(id);

                Date start = access.getStartedAt(id);
                Date pause = access.getCompletedAt(id);

                long tt = access.totalTime(start, pause);
                String aux = Long.toString(tt);
                

                response.setContentType("text/plain");
                response.setCharacterEncoding(("UTF-8"));
                response.getWriter().write(aux);
            }

//            RequestDispatcher rq = request.getRequestDispatcher("app.jsp");
//            rq.forward(request, response);
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
    }

}
