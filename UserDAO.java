/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contract;
import entity.Motobike;
import entity.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface UserDAO {
    
    List<Users> getAllAccount()throws SQLException, Exception;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws Exception
     */
    Users getAccountById(int id)throws SQLException, Exception;
    
    List<Contract> getAllContract() throws SQLException, Exception;
    
    List<Users> searchAccountByName(String txtSearch) throws SQLException, Exception;
    
    List<Users> getPersonInfor()throws SQLException, Exception;
    
    List<Contract> getPersonContract()throws SQLException, Exception;
    
    List<Motobike> getPersonMoto()throws SQLException, Exception;
    
}
