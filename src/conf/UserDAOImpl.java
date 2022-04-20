/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import context.DBContext;
import dao.UserDAO;
import entity.Contract;
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
 * @author dell
 */
public class UserDAOImpl extends DBContext implements UserDAO {

    @Override
    public List<Users> getAllAccount() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select u.user_id, r.name, u.username, u.email, u.password, u.fullname, u.dob, u.gender, u.phone, u.address\n"
                    + "from [User] u join [Role] r on u.role_id = r.id\n"
                    + "where u.isenable = 1\n"
                    + "order by user_id");
            rs = preparedStatement.executeQuery();
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
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    @Override
    public Users getAccountById(int id) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select u.user_id, r.name, u.username, u.email, u.password, u.fullname, u.dob, u.gender, u.phone, u.address\n"
                    + "from [User] u join [Role] r on u.role_id = r.id\n"
                    + "where user_id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

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
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }

        return null;
    }
    
    public List<Users> getAllCustomer() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select u.user_id, r.name, u.username, u.email, u.password, u.fullname, u.dob, u.gender, u.phone, u.address\n"
                    + "from [User] u join [Role] r on u.role_id = r.id\n"
                    + "where u.role_id = 3\n"
                    + "order by user_id");
            rs = preparedStatement.executeQuery();
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
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }

    public List<Contract> getAllContract() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Contract> contracts = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("SELECT [id]\n" +
                            "      ,[name]\n" +
                            "      ,[moto_id]\n" +
                            "      ,[user_id]\n" +
                            "      ,[date]\n" +
                            "      ,[status]\n" +
                            "  FROM [Contract]");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getInt("contractid"));
                contract.setName(rs.getString("name"));
                contract.setMotoId(rs.getInt("motoId"));
                contract.setUserId(rs.getInt("userId"));
                contract.setDate(rs.getDate("date"));
                contract.setStatus(rs.getBoolean("status"));
                contracts.add(contract);
            }
            return contracts;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
    }
}
