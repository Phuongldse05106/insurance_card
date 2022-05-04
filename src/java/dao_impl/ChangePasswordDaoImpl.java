/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import context.DBContext1;
import entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chubo
 */
public class ChangePasswordDaoImpl {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext1 db = new DBContext1();

    public void changePassword(int userID, String newPass) {
        try {
            String query = "UPDATE [User]\n"
                    + "SET password = ? \n"
                    + "WHERE user_id = ?";
            
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, userID);
            rs = ps.executeQuery();
            

        } catch (Exception e) {
        }

       
    }
}
