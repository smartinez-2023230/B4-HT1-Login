/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.repository;

import org.saulmartinez.system.model.User;
import java.sql.CallableStatement;
import org.saulmartinez.system.config.ConexionDB;
/**
 *
 * @author informatica
 */
public class UserRepository implements UserInterface {
    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();    
    
    @Override
    public void create(User user) {
        try {
            callSP = conexionDB.getConnectionDB().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastName());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            
            callSP.execute();
            
            callSP.close();
        } catch (Exception e) {
        }
    }
}
