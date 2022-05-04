/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContractDAO;
import entity.Contract;
import entity.ContractExtended;
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
@WebServlet(name = "ContractDetailController", urlPatterns = {"/ContractDetailController"})
public class ContractDetailController extends HttpServlet {

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
            
            //get contractId
            int contractId = Integer.parseInt(request.getParameter("contractId"));
            ContractExtended contract = contractDAO.getContractDetailById(contractId);
            request.setAttribute("contract", contract);
            //get customer data
            User customer = contractDAO.getUserById(contract.getUser_id());
            request.setAttribute("customer", customer);
            //get customer's bike data
            MotorBike bike = contractDAO.getMotorbikeByBikeId(contract.getMoto_id());
            request.setAttribute("bike", bike);
            //get staff data
            User staff = contractDAO.getUserById(contract.getStaff_id());
            request.setAttribute("staff", staff);
            request.setAttribute("contract", contract);
            request.getRequestDispatcher("contract-detail.jsp").forward(request, response);
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
        try {
            Boolean isExpired = false;
            ContractDAO contractDAO = new ContractDAO();

            //get contractId
            int contractId = Integer.parseInt(request.getParameter("contractId"));
            //get contract
            ContractExtended contract = contractDAO.getContractDetailById(contractId);
            request.setAttribute("contract", contract);

            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            LocalDateTime now = LocalDateTime.now();  
            //Renew contract
            contractDAO.RenewContract(contractId, date.format(now));
            
            //get all contract
            List<ContractExtended> listContract = contractDAO.getAllContract();
            if (listContract == null || listContract.isEmpty()) {
                request.setAttribute("listContractError", "There's no contract to show!");
            }
            request.setAttribute("listContract", listContract); 
            
            request.getRequestDispatcher("contract-list.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ContractListController.class.getName()).log(Level.SEVERE, null, ex);
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
