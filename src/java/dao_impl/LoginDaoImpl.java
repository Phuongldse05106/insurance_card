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
public class LoginDaoImpl {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext1 db = new DBContext1();

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
//    public Users checkRole(String role) {
//        try {
//            String query = "Select role_id from [User]";
//
//            conn = db.getConnection();
//            ps = conn.prepareStatement(query);
//
//            
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7),
//                        rs.getBoolean(8), rs.getString(9), rs.getString(10), rs.getInt(11));
//
//            }
//
//        } catch (Exception e) {
//        }
//
//        return null;
//    }
//    public Role getUserRole(int roleId, String name ){
//        try {
//            
//        } catch (Exception e) {
//        }
//        return null;
//        
//    }
}

//    public List<Users> getAllAccount() throws SQLException, Exception {
//
//        try {
//            List<Users> users = new ArrayList<>();
//            String query = "select u.user_id, r.name, u.username, u.email, u.password, u.fullname, u.dob, u.gender, u.phone, u.address\n"
//                    + "from [User] u join [Role] r on u.role_id = r.id\n"
//                    + "where u.isenable = 1\n"
//                    + "order by user_id";
//            conn = db.getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//
//                Users user = new Users();
//                user.setUserId(rs.getInt("user_id"));
//                user.setRole(rs.getString("name"));
//                user.setUsername(rs.getString("username"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                user.setFullName(rs.getString("fullname"));
//                user.setBirthDate(rs.getDate("dob"));
//                user.setGender(rs.getBoolean("gender"));
//                user.setPhone(rs.getString("phone"));
//                user.setAddress(rs.getString("address"));
//                users.add(user);
//            }
//
//        } catch (SQLException ex) {
//        }
//
//        return null;
//    }
//}
