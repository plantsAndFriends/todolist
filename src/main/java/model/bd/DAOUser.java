/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        
        conn = getConnexio();
        stmt = conn.createStatement();
    }

    public void insertUser(BeanUser bu) throws Exception {
        String username = bu.getUsername();
        String password = bu.getEmail();
        String email = bu.getPassword();

        stmt.executeUpdate("INSERT INTO user (username, password, email) VALUES ('" + username + "', '" + email + "', '" + password + "')");
    }

    public boolean validateUser(BeanUser user) throws Exception {
        boolean valid = false;

        try {
            String email = user.getEmail();
            String password = user.getPassword();

            PreparedStatement pst = conn.prepareStatement("SELECT email, password FROM user WHERE email = ? and password = ?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                valid = true;
            }

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        return valid;
    }

    public BeanUser getUserByEmail(String email) {
        String username = "";
        int id = 0;
        try {

            PreparedStatement pst = conn.prepareStatement("SELECT username, id FROM user WHERE email = ?");

            pst.setString(1, email);            

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("");
        }

        return new BeanUser(id, username);
    }

}
