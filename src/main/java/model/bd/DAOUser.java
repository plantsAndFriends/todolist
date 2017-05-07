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

/** Classe Bean que tractarà tots els moviments a la base de dades relacionats
 *  amb els usuaris.
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

    /**
     * Mètode que insertarà usuaris a la BD.
     * 
     * Guardarà el nom d'usuari, l'email i la contrasenya.
     * 
     * @param bu l'usuari  del formulari de registre
     * @throws Exception 
     */
    public void insertUser(BeanUser bu) throws Exception {
        String username = bu.getUsername();
        String password = bu.getEmail();
        String email = bu.getPassword();

        stmt.executeUpdate("INSERT INTO user (username, password, email) VALUES ('" + username + "', '" + email + "', '" + password + "')");
    }

    /**
     * Mètode que comprova si aquell email i contrasenya existeixen a la BD.
     * 
     * @param user l'usuari del formulari de login
     * @return true o false, segons si existeix o no aquell usuari
     * @throws Exception 
     */
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

    /**
     * Mètode que retorna l'usuari (BeanUser) de l'email passat per paràmetres.
     * 
     * @param email de l'usuari en qüestió
     * @return l'usuari (BeanUser)
     */
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
