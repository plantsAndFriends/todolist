/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Classe per validar el camps del registre.
 * 
 *  Aquesta classe compte amb un mètode per camp que es demana al formulari
 *  del registre, que retornarà true o false segons si és vàlid o no.
 *
 * @author Adria Viñas
 */
public class ValidatorUtil {
    private String patternMail = "^[A-Z0-9._+-]+@[A-Z0-9]+.[A-Z]{2,6}$";
    
    private String patternUsername = "^[A-Za-z0-9]{3,}$";
    /*
    PASSWORD POLICY
   
        ^                # start-of-string
       (?=.*[0-9])       # a digit must occur at least once
       (?=.*[a-z])       # a lower case letter must occur at least once
       (?=.*[A-Z])       # an upper case letter must occur at least once
       (?=.*[@#$%^&+=])  # a special character must occur at least once
       (?=\S+$)          # no whitespace allowed in the entire string
       .{8,}             # anything, at least eight places though
       $                 # end-of-string
    */
    private String patternPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    
    /**
     * Mètode per validar l'email.
     * 
     * Es comprovarà que que l'email inserit faci "match" amb el pattern de 
     * l'email declarat prèviament.
     * 
     * @param email inserit al formulari
     * @return true o false
     */
    public boolean validateMail (String email){
        Pattern pattern = Pattern.compile(patternMail, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
                
        return matcher.matches();
    }
    
    /**
     * Mètode per validar el nom d'usuari.
     * 
     * Es comprovarà que l'usuari inserit faci "match" amb el pattern del
     * username declarat prèviament.
     * 
     * @param username inserit al formulari
     * @return true o false
     */
    public boolean validateUsername (String username){
        Pattern pattern = Pattern.compile(patternUsername);
        Matcher matcher = pattern.matcher(username);
        
        return matcher.matches();
    }
    
    /**
     * Mètode per validar la contrasenya.
     * 
     * Es comprovarà que la password inserida faci "match" amb el pattern de la
     * password prèviament declarada.
     * 
     * @param password inserida al formulari
     * @return true o false
     */
    public boolean validatePassword (String password){
        Pattern pattern = Pattern.compile(patternPass);
        Matcher matcher = pattern.matcher(password);
        
        return matcher.matches();
    }
}
