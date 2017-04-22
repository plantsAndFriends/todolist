/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;

/**
 *
 * @author clara
 */
public class BeanUser implements Serializable {
    private int id;
    private String username;
    private String email;
    private String password;
    
    public BeanUser() {
        
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BeanUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + '}';
    }

    
}
