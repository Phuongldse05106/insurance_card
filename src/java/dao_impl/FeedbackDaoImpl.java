/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import context.DBContext1;
import entity.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chubo
 */
public class FeedbackDaoImpl {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext1 db = new DBContext1();
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();

        try {

            String query = "select * from Feedback where isenable = '1'";

            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

               Feedback feedback = new Feedback();
               feedback.setId(rs.getInt("id"));
               feedback.setFullName(rs.getString("fullName"));
               feedback.setEmail(rs.getString("email"));
               feedback.setPhone(rs.getString("phone"));
               feedback.setMessage(rs.getString("message"));
               feedback.setIsenable(rs.getInt("isenable"));
               feedbacks.add(feedback);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return feedbacks;
    }
    public List<Feedback> getFeedbackDetails(){
        List<Feedback> feedback1 = new ArrayList<>();
        try {

            String query = "select * from Feedback where isenable = '1'";

            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

               Feedback feedback = new Feedback();
               feedback.setId(rs.getInt("id"));
               feedback.setFullName(rs.getString("fullName"));
               feedback.setEmail(rs.getString("email"));
               feedback.setPhone(rs.getString("phone"));
               feedback.setMessage(rs.getString("message"));
               feedback.setIsenable(rs.getInt("isenable"));
               feedback1.add(feedback);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return feedback1;
    }
    
//    public static void main(String[] args) {
//        FeedbackDaoImpl dao = new FeedbackDaoImpl();
//        System.out.println(dao.getFeedbackDetails());
//    }
}
