/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import context.DBContext;
import entity.Feedback;
import entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author my laptop
 */
public class ImplDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext db = new DBContext();

    public Users checkAccount(String user, String pass) {
        try {
            String query = "Select * from [User] where username = ? and password = ? and isenable = 1";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7),
                        rs.getBoolean(8), rs.getString(9), rs.getString(10), rs.getInt(11));

            }

        } catch (Exception e) {
        }

        return null;
    }

    public List<Users> getAllAccount() {
        List<Users> users = new ArrayList<>();

        try {

            String query = "select u.user_id, r.name, u.username, u.email, u.password, u.fullname, u.dob, u.gender, u.phone, u.address, u.isenable\n"
                    + "from [User] u join [Role] r on u.role_id = r.id\n"
                    + "where u.isenable = 1\n"
                    + "order by user_id";

            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                Users user = new Users();
                user.setUserId(rs.getInt("user_id"));
                user.setRole(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullname"));
                user.setBirthDate(rs.getDate("dob"));
                user.setGender(rs.getBoolean("gender"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setIsenable(rs.getInt("isenable"));
                users.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return users;
    }
//    public static void main(String[] args) {
//        ImplDAO dao = new ImplDAO();
//        List<Users> user = dao.getAllAccount();
//        System.out.println(user);
//    }

    public void deleteAccount(String userId) {
        

        try {
            String query = "update [User] set isenable = 0 where user_id = ?";
           conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            int flag = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    public void deleteFeedback(String id) {
        

        try {
            String query = "update [Feedback] set isenable = 0 where id = ?";
           conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            int flag = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    public boolean createFeedback(String name, String email, String phone, String message) {
        int n = 0;
        String query =  "INSERT [DB_SWP391_Project].[dbo].[Feedback] ([fullName],[email], [phone],[message],[isenable])" +
                    "VALUES" +
                    "(?, ?, ?, ?, ?)";
        try {
            ps = db.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, message);
            ps.setInt(5, 1);
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
    
   
    
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
    
    public boolean checkUsernameAndEmail(String fullName, String email) {
       
        try {
            
            // Get data
            String query = "select * from [user] where username = ? and email = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, email);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                return true;
            }
        }catch (Exception ex) {
            
        } 
        return false;
    }
    
    
    public static void main(String[] args) {
        ImplDAO logindao = new ImplDAO();
//        logindao.getAllFeedback();
//        logindao.getAllAccount();
        System.out.println(logindao.getAllFeedback());
    }
}
