/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContractDAO;
import entity.Contract;
import entity.Contract_Duongdt;
import entity.MotorBike;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duongdt
 */
@WebServlet(name = "ContractEditController", urlPatterns = {"/contract-edit"})
public class ContractEditController extends HttpServlet {

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
            //get contract data
            Contract_Duongdt contract = contractDAO.getContractById(contractId);
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
            
            request.getRequestDispatcher("contract-edit.jsp").forward(request, response);
        }catch (Exception ex) {
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
        
        ContractDAO contractDAO = new ContractDAO();
        
        //get contractId
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        //get contractDate
        String contractDate = request.getParameter("contractDate");
        //get contractType
        String contractType = request.getParameter("contractType");
        //get status
        String status = request.getParameter("status");
        
        //Edit contract
        contractDAO.EditContract(contractId, contractDate, contractType, status);
        String success="success";
        request.setAttribute("success", success);
        request.getRequestDispatcher("edit-success.jsp").forward(request, response);
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
