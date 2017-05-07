/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;

/**
 * Classe bean amb els atributs, constructor, getters i setters d'un usuari
 * 
 * @author clara
 */
public class BeanUser implements Serializable {
    private int id;
    private String username;
    private String email;
    private String password;
    
    /**
     * Constructor per defecte d'una BeanTask
     */
    public BeanUser() {
        
    }
    
    /**
     * Constructor d'un BeanUser amb l'id i el nom d'usuari
     * @param id
     * @param username 
     */
    public BeanUser(int id, String username){
        this.id = id;
        this.username = username;
    }
    
    /**
     * Getter de l'Id
     * @return id de l'usuari
     */
    public int getId() {
        return id;
    }

    /**
     * Getter del nom d'usuari
     * @return el nom d'usuari
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter del nom d'usuari
     * @param username el nom d'usuari
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter de l'email
     * @return l'email de l'usuari
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter de l'email
     * @param email l'email de l'usuari
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter de la contrasenya
     * @return la contrasenya de l'usuari
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter de la contrasenya
     * @param password la contrasenya de l'usuari
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * El toString()
     * @return un String amb tots els atributs d'un usuari
     */
    @Override
    public String toString() {
        return "BeanUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + '}';
    }
}
