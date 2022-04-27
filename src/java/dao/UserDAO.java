/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface UserDAO {

    List<Users> getAllAccount() throws SQLException, Exception;

    Users getAccountById(int id) throws SQLException, Exception;

    void createAccount(Account user) throws SQLException, Exception;

    boolean checkUsernameAndEmail(String username, String email) throws SQLException, Exception;

    void editAccount(Account user) throws SQLException, Exception;

    boolean checkUsernameAndEmail2(String username, String email, int userID) throws SQLException, Exception;

}
