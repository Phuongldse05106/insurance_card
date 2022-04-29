/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDaoImpl;
import entity.Role;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.User;

/**
 *
 * @author chubo
 */
public class LoginController extends HttpServlet {

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
            String user = request.getParameter("username");
            String pass = request.getParameter("password");

            LoginDaoImpl loginDAO = new LoginDaoImpl();

            Users a = loginDAO.checkAccount(user, pass);

            if (a == null) {
                request.setAttribute("mess", "Wrong user or password !");
                request.getRequestDispatcher("Login.jsp").forward(request, response);

            } else {
//                HttpSession session = request.getSession();
//                session.setAttribute("acc", a);
//                session.setMaxInactiveInterval(186400);
//                response.sendRedirect();
                Cookie cookie = new Cookie("userId", String.valueOf(a.getUserId()));
                cookie.setMaxAge(30000000);
//                cookie.setUserId(1);
//                cookie.setPath(request.getContextPath());
//                cookie.setComment("1");
////                cookie.setVersion(1);
//                System.out.println("Cookie created!");
                response.addCookie(cookie);
                switch (a.getRole()) {
                    case "1":
//                        response.sendRedirect("AdminPage.jsp");
                        request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
                    case "2":
//                        response.sendRedirect("StaffPage.jsp");
                        request.getRequestDispatcher("StaffPage.jsp").forward(request, response);
                    case "3":
//                        response.sendRedirect("CustomerPage.jsp");
                        request.getRequestDispatcher("CustomerPage.jsp").forward(request, response);
                    default:
                        break;

                }

            }
        } catch (Exception e) {
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
