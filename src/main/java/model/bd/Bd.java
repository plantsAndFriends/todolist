/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe per connexió i desconnexió a la base de dades.
 *
 * @author clara
 */
public class Bd {
    protected static final String DATABASE_URL = "jdbc:mysql://localhost:3306/todolist";
    protected static final String ID_DB = "root";
    protected static final String PW_DB = "";
    protected static Connection CONNECTION = null;
    
    /**
     * Mètode que estableix una connexió (si no existia abans) amb la base de dades
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection getConnexio() throws SQLException, ClassNotFoundException {
        if (CONNECTION == null) {
            new Bd(DATABASE_URL, ID_DB, PW_DB);
        }
         
        return CONNECTION;
    }
    public Bd(){
        
    }
    private Bd(String url, String id, String pw) throws SQLException {
        connectarBBDD(url, id, pw);
    }

    /**
     * Mètode que es connecta a la base de dades
     * 
     * @param url
     * @param id
     * @param pw
     * @throws SQLException 
     */
    private void connectarBBDD(String url, String id, String pw) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            CONNECTION = (Connection) DriverManager.getConnection(url, id, pw);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Mètode que tanca la connexió amb la base de dades
     */
    public static void tancarConnexio() {
        if (CONNECTION != null) {
            try {
                CONNECTION.close();
            } catch (Exception ignore) {
            }
        }
}
}
