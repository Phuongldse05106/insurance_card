/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContextDuongdt;
import entity.Contract;
import entity.ContractExtended;
import entity.Contract_Duongdt;
import entity.MotorBike;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duongdt
 */
public class ContractDAO {
    DBContextDuongdt db = new DBContextDuongdt();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<ContractExtended> getAllContract() throws Exception {
        List<ContractExtended> list = null;
        try {
            list = new ArrayList<ContractExtended>();
            String query = "SELECT [id], [moto_id], [Contract2].[user_id], [date], [contract_type]\n" +
                ", [staff_id], [status], [fullname], [phone], [email], [address], [isenable]\n" +
                "FROM [Contract2]\n" +
                "left JOIN [user]\n" +
                "ON [Contract2].user_id = [user].user_id\n" +
                "where [status] not like 'rejected';";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ContractExtended d = new ContractExtended(rs.getInt("id"),
                        rs.getInt("moto_id"),
                        rs.getInt("user_id"),
                        rs.getDate("date"),
                        rs.getString("contract_type"),
                        rs.getInt("staff_id"),
                        rs.getString("status"),
                        rs.getString("fullname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("isenable")
                );
                list.add(d);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return list;
    }
    public List<User> getAllCustomer() throws Exception {
        List<User> list = null;
        try {
            list = new ArrayList<User>();
            String query = "select * from [DB_SWP391_Project].[dbo].[User]\n" +
                "  where role_id='3' and [User].isenable='1';";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getInt("role_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getDate("dob"),
                        rs.getInt("gender"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("isenable")
                );
                list.add(u);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return list;
    }
    public List<User> getAllStaff() throws Exception {
        List<User> list = null;
        try {
            list = new ArrayList<User>();
            String query = "select * from [DB_SWP391_Project].[dbo].[User]\n" +
                "  where role_id='2' and [User].isenable='1';";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getInt("role_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getDate("dob"),
                        rs.getInt("gender"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("isenable")
                );
                list.add(u);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return list;
    }
    public User getUserById(int user_id) throws Exception {
        DBContextDuongdt db = new DBContextDuongdt();
        Connection conn = null;
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from [User] where user_id = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                User d = new User(rs.getInt("user_id"),
                        rs.getInt("role_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getDate("dob"),
                        rs.getInt("gender"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("isenable"));
                user = d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return user;
    }
    public MotorBike getMotorbikeByUserId(int user_id) throws Exception {
        DBContextDuongdt db = new DBContextDuongdt();
        Connection conn = null;
        MotorBike motorBike = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from [DB_SWP391_Project].[dbo].[Motobike] where user_id = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                MotorBike d = new MotorBike(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("color"),
                        rs.getString("brand"),
                        rs.getString("lisence_plate"),
                        rs.getString("vehicle_capacity"));
                motorBike = d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return motorBike;
    }
    public MotorBike getMotorbikeByBikeId(int bike_id) throws Exception {
        DBContextDuongdt db = new DBContextDuongdt();
        Connection conn = null;
        MotorBike motorBike = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from [DB_SWP391_Project].[dbo].[Motobike] where [id]=?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bike_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                MotorBike d = new MotorBike(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("color"),
                        rs.getString("brand"),
                        rs.getString("lisence_plate"),
                        rs.getString("vehicle_capacity"));
                motorBike = d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return motorBike;
    }
    public boolean createContract(int customerId, int staffId, String contractDate, String contractType) {
        int n = 0;
        String sql = "INSERT [DB_SWP391_Project].[dbo].[Contract2] ([id], [moto_id], [user_id], [date] , [contract_type] , [staff_id], [status]) \n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, 8);
            ps.setInt(2, 5);
            ps.setInt(3, customerId);
            ps.setString(4,  contractDate);
            
            
            ps.setString(5, contractType);
            ps.setInt(6, staffId);
            ps.setString(7, "pending");
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
    
    public Contract_Duongdt getContractById(int id) throws Exception {
        DBContextDuongdt db = new DBContextDuongdt();
        Connection conn = null;
        Contract_Duongdt contract = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM [DB_SWP391_Project].[dbo].[Contract2] where id = ?;";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contract_Duongdt d = new Contract_Duongdt(rs.getInt("id"),
                        rs.getInt("moto_id"),
                        rs.getInt("user_id"),
                        rs.getDate("date"),
                        rs.getString("contract_type"),
                        rs.getInt("staff_id"),
                        rs.getString("status"));
                contract = d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return contract;
    }
    public boolean updateContractStatus(int customerId, int staffId, String contractDate, String contractType) {
        int n = 0;
        String sql = "UPDATE [Contract2]\n" +
                "SET [status] = 'accepted'\n" +
                "WHERE [id] = ?;";
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setInt(2, 2);
            ps.setInt(3, customerId);
            ps.setString(4,  contractDate);
            ps.setString(5, contractType);
            ps.setInt(6, staffId);
            ps.setString(7, "pending");
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
    public boolean EditContract(int contractId, String contractDate, String contractType, String status) {
        int n = 0;
        String sql = "UPDATE [Contract2]\n" +
            "SET [date] = ?, [contract_type] = ?, [status] = ?\n" +
            "WHERE [id] = ?;";
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, contractDate);
            ps.setString(2, contractType);
            ps.setString(3, status);
            ps.setInt(4, contractId);
            
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
    
    public List<ContractExtended> getAllContractExpired() throws Exception {
        List<ContractExtended> list = null;
        try {
            list = new ArrayList<ContractExtended>();
            String query = "SELECT [id], [moto_id], [Contract2].[user_id], [date], [contract_type]\n" +
                ", [staff_id], [status], [fullname], [phone], [email], [address], [isenable]\n" +
                "FROM [Contract2]\n" +
                "left JOIN [user]\n" +
                "ON [Contract2].user_id = [user].user_id\n" +
                "where [status] = 'expired';";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ContractExtended d = new ContractExtended(rs.getInt("id"),
                        rs.getInt("moto_id"),
                        rs.getInt("user_id"),
                        rs.getDate("date"),
                        rs.getString("contract_type"),
                        rs.getInt("staff_id"),
                        rs.getString("status"),
                        rs.getString("fullname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("isenable")
                );
                list.add(d);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return list;
    }
     public boolean DeleteContract(int contractId) {
        int n = 0;
        String sql = "UPDATE [Contract2]\n" +
            "SET [status] = 'rejected'\n" +
            "WHERE [id] = ?;";
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, contractId);
            
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
     public ContractExtended getContractDetailById(int id) throws Exception {
        DBContextDuongdt db = new DBContextDuongdt();
        Connection conn = null;
        ContractExtended contract = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT [id], [moto_id], [Contract2].[user_id], [date], [contract_type] , [staff_id], [status], [fullname]\n" +
                ", [phone], [email], [address], [isenable]\n" +
                "FROM [Contract2]\n" +
                "left JOIN [user]\n" +
                "ON [Contract2].user_id = [user].user_id\n" +
                "where [id] =?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ContractExtended d = new ContractExtended(rs.getInt("id"),
                        rs.getInt("moto_id"),
                        rs.getInt("user_id"),
                        rs.getDate("date"),
                        rs.getString("contract_type"),
                        rs.getInt("staff_id"),
                        rs.getString("status"),
                        rs.getString("fullname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("isenable")
                );
                contract = d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        return contract;
    }
    public boolean RenewContract(int contractId, String contractDate) {
        int n = 0;
        String sql = "UPDATE [Contract2]\n" +
            "SET [status] = 'accepted', [date] = ?\n" +
            "WHERE [id] = ?;";
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, contractDate);
            ps.setInt(2, contractId);
            
            n = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return n > 0;
    }
}
