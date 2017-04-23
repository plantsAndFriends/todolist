/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Adria Viñas
 */
public class ValidatorUtil {
    private String patternMail = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
"            + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    
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
     * !!! TODO !!!
     * @param email
     * @return 
     */
    public boolean validateMail (String email){
        Pattern pattern = Pattern.compile(patternMail);
        Matcher matcher = pattern.matcher(email);
                
        return matcher.matches();
    }
    
    public boolean validateUsername (String username){
        Pattern pattern = Pattern.compile(patternUsername);
        Matcher matcher = pattern.matcher(username);
        
        return matcher.matches();
    }
    
    public boolean validatePassword (String password){
        Pattern pattern = Pattern.compile(patternPass);
        Matcher matcher = pattern.matcher(password);
        
        return matcher.matches();
    }
}
