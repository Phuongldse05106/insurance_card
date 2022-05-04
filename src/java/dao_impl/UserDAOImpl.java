/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import context.DBContext1;
import dao.UserDAO;
import entity.Account;
import entity.Compensation;
import entity.Contract;
import entity.Motobike;
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
public class UserDAOImpl extends DBContext1 implements UserDAO {

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
            throw ex;
        } catch (Exception ex) {
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
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return null;
    }

    @Override
    public void createAccount(Account user) throws SQLException, Exception {
//        int n = 0;
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into [user] (role_id, username, fullname, email, dob, gender, phone, address, isenable, password)\n"
                    + "values (?,?,?,?,?,?,?,?, 1,?)");
            preparedStatement.setInt(1, user.getRoleId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, user.getBirthDate());
            if (user.isGender()) {
                preparedStatement.setInt(6, 1);
            } else {
                preparedStatement.setInt(6, 0);
            }
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connecion != null && !connecion.isClosed()) {
                connecion.close();
            }
//            closeResultSet(rs);
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
        }
//        return n > 0;
    }

    @Override
    public boolean checkUsernameAndEmail(String username, String email) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from [user] where username = ? or email = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return false;
    }

    @Override
    public boolean checkUsernameAndEmailById(String username, String email, int userID) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from [user] where (username = ? or email = ?) and user_id NOT LIKE ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, userID);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connecion != null && !connecion.isClosed()) {
                connecion.close();
            }
//            closeResultSet(rs);
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
        }
        return false;
    }

    @Override
    public void editAccount(Account user) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("update [user] set email = ?, fullname = ?, dob = ?,"
                    + " phone = ? , [address] = ? , role_id = ?,  username = ? , gender = ? where user_id = ?");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setDate(3, user.getBirthDate());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getRoleId());
            preparedStatement.setString(7, user.getUsername());
            if (user.isGender()) {
                preparedStatement.setInt(8, 1);
            } else {
                preparedStatement.setInt(8, 0);
            }
            preparedStatement.setInt(9, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connecion != null && !connecion.isClosed()) {
                connecion.close();
            }
//            closeResultSet(rs);
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
        }
    }

    @Override
    public void register(Account user) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("insert into [user] (role_id, username, fullname, email, dob, gender, phone, address, isenable, password)\n"
                    + "values (?,?,?,?,?,?,?,?, 1,?)");
            preparedStatement.setInt(1, user.getRoleId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, user.getBirthDate());
            if (user.isGender()) {
                preparedStatement.setInt(6, 1);
            } else {
                preparedStatement.setInt(6, 0);
            }
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connecion != null && !connecion.isClosed()) {
                connecion.close();
            }
//            closeResultSet(rs);
//            closePreparedStatement(preparedStatement);
//            closeConnection(connecion);
        }
//        return n > 0;

    }
    
    public List<Users> searchAccountByName(String txtSearch) throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from [User]"
                    + "where username like ?");
            preparedStatement.setString(1, "%" + txtSearch + "%");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("user_id"));
                user.setRole(rs.getString("role_id"));
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
        return users;
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
    
    public List<Users> getPersonInfor() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Users> users = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from [User]");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
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
        }
    }
    
    
    public List<Contract> getPersonContract() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Contract> contr = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from [User] u JOIN Contract c on u.user_id = c.user_id");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getInt("id"));
                contract.setName(rs.getString("name"));
                contract.setMotoId(rs.getInt("moto_id"));
                contract.setUserId(rs.getInt("user_id"));
                contract.setDate(rs.getDate("date"));
                contract.setStatus(rs.getBoolean("status"));
                contr.add(contract);
            }
            return contr;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    
    public List<Motobike> getPersonMoto() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Motobike> moto = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from [User] u JOIN Motobike m on u.user_id = m.user_id");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Motobike mt = new Motobike();
                mt.setId(rs.getInt("id"));
                mt.setUserId(rs.getInt("user_id"));
                mt.setBrand(rs.getString("brand"));
                mt.setColor(rs.getString("color"));
                mt.setLisence_plate(rs.getString("lisence_plate"));
                mt.setVehicle_capacity(rs.getString("vehicle_capacity"));
                moto.add(mt);
            }
            return moto;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    
    public List<Compensation> getCompensation() throws SQLException, Exception {
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Compensation> compen = new ArrayList<>();
        try {
            connecion = getConnection();
            preparedStatement = connecion.prepareStatement("select * from [User] u JOIN Compensation com on u.user_id = com.user_id");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Compensation comp = new Compensation();
                comp.setId(rs.getInt("id"));
                comp.setUserId(rs.getInt("user_id"));
                comp.setDescription(rs.getString("description"));
                comp.setDate(rs.getDate("date"));
                comp.setStatus(rs.getBoolean("status"));
                compen.add(comp);
            }
            return compen;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
