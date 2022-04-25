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
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class CreateAccountController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
//        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        boolean checkDate;
        checkDate = true;
        boolean checkAdd;
        checkAdd = true;
        int roleId = Integer.parseInt(request.getParameter("roleId"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String birthDate = request.getParameter("date");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        java.util.Date date = format.parse(birthDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date today = new java.util.Date();
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        if (date.after(today)) {
            checkDate = false;
            request.setAttribute("checkDate", checkDate);
            request.getRequestDispatcher("ViewAllAccountController").forward(request, response);
            response.sendRedirect("ViewAllAccountController");
            //request.getRequestDispatcher("./viewAllAccount.jsp").forward(request, response);
            return;
        }
        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.checkUsernameAndEmail(username.trim(), email.trim())) {
            checkAdd = false;
            request.setAttribute("checkAdd", checkAdd);
            request.getRequestDispatcher("ViewAllAccountController").forward(request, response);
            response.sendRedirect("ViewAllAccountController");
            return;
        }
        Account u = new Account();
        u.setRoleId(roleId);
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);
        u.setFullName(fullName);
        u.setBirthDate(sqlDate);
        if (gender == 1) {
            u.setGender(true);
        } else {
            u.setGender(false);
        }
        u.setPhone(phone);
        u.setAddress(address);
        userDAO.createAccount(u);
        checkAdd = true;
        request.setAttribute("checkAdd", checkAdd);
        request.getRequestDispatcher("ViewAllAccountController").forward(request, response);
        response.sendRedirect("ViewAllAccountController");
//        ViewAllAccountController accountController = new ViewAllAccountController();
//        accountController.processRequest(request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
