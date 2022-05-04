/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContractDAO;
import entity.Contract;
import entity.MotorBike;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duongdt
 */
@WebServlet(name = "ContractCreateController", urlPatterns = {"/contract-create"})
public class ContractCreateController extends HttpServlet {

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
        try {
            ContractDAO contractDAO = new ContractDAO();
            
            //list Customer
            List<User> listCustomer = contractDAO.getAllCustomer();
            if (listCustomer == null || listCustomer.isEmpty()) {
                request.setAttribute("customerError", "There's no user to show!");
            }
            request.setAttribute("listCustomer", listCustomer);
            //list Staff
            List<User> listStaff = contractDAO.getAllStaff();
            if (listStaff == null || listStaff.isEmpty()) {
                request.setAttribute("staffError", "There's no staff to show!");
            }
            request.setAttribute("listStaff", listStaff);
            
            
            request.getRequestDispatcher("contract-create.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex);
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
        processRequest(request, response);
        try{
            ContractDAO contractDAO = new ContractDAO();
            
            //get customerId
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            //get staffId
            int staffId =  Integer.parseInt(request.getParameter("staffId"));
            
            //get contractDate
            //String contractDate = request.getParameter("contractDate");
            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            LocalDateTime now = LocalDateTime.now();  
            //System.out.println(date.format(now));  
            
            //get contractType
            String contractType = request.getParameter("contractType");

            //load UserData
            User customer = contractDAO.getUserById(customerId);
            request.setAttribute("customer", customer);
            MotorBike bike = contractDAO.getMotorbikeByUserId(customerId);
            request.setAttribute("bike", bike);
            User staff = contractDAO.getUserById(staffId);
            request.setAttribute("staff", staff);
            
            
            //Create contract
            contractDAO.createContract(customerId, staffId, date.format(now), contractType);
            String success="success";
            request.setAttribute("success", success);
            request.getRequestDispatcher("contract-create.jsp").forward(request, response);

            response.sendRedirect("contract-create");
        }catch (Exception ex) {
            System.out.println(ex);
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
