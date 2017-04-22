/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.pojo.BeanUser;

/**
 *
 * @author clara
 */
public class DAOUser extends Bd {

    private Connection conn;
    private Statement stmt;

    public DAOUser() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
        stmt = conn.createStatement();
    }

    public void insertUser(BeanUser bu) throws Exception {
        String username = bu.getUsername();
        String password = bu.getEmail();
        String email = bu.getPassword();

        stmt.executeUpdate("INSERT INTO user (username, password, email) VALUES ('" + username + "', '" + email + "', '" + password + "')");
    }

    /*public boolean validateLoginUser(BeanUser bu) throws InvalidEmail {
        boolean login = false;
        String sql = "SELECT * FROM user WHERE email=" + bu.getEmail() + "AND password=" + bu.getPassword();
        ResultSet rs = stmt.executeQuery(sql);
        try {
            while (rs.next()) {
                System.out.println("You in");
            }
            catch(Exception e){
                throw new InvalidEmail();
                }
            return login;
        }
        
    public void verificarLogin(BeanUser bu) throws Exception {
        System.out.println(bu.getEmail());
    }*/

}
