/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao_impl.UserDAOImpl;
import entity.Account;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        boolean checkPass;
        boolean checkDate;
        boolean checkAdd;
        String fullname = request.getParameter("fullname").trim();
        String email = request.getParameter("email").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String repassword = request.getParameter("repassword").trim();
        String birthDate = request.getParameter("birthDate").trim();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        java.util.Date date = format.parse(birthDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date today = new java.util.Date();
        int check = Integer.parseInt(request.getParameter("gender").trim());
        boolean gender;
        if (check == 1) {
            gender = true;
        } else {
            gender = false;
        }
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();
        if(!password.equals(repassword)){
            checkPass = false;
            request.setAttribute("checkPass", checkPass);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        if (date.after(today)) {
            checkDate = false;
            request.setAttribute("checkDate", checkDate);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
//            response.sendRedirect("ViewAllAccountController");
            return;
        }
        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.checkUsernameAndEmail(username, email)) {
            checkAdd = false;
            request.setAttribute("checkAdd", checkAdd);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
//            response.sendRedirect("ViewAllAccountController");
            return;
        }
        Account u = new Account(3, username, email, password, fullname, sqlDate, gender, phone, address); 
        userDAO.createAccount(u);
        checkAdd = true;
        request.setAttribute("checkAdd", checkAdd);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        response.sendRedirect("Login.jsp");

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
        } catch (ParseException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
