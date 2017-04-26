/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import model.pojo.BeanTask;
import model.pojo.BeanUser;

/**
 *
 * @author clara
 */
public class DAOTask{
    private Connection conn;
    private Statement stmt;
    
    public DAOTask() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
        stmt = conn.createStatement();
    }
    
    public void insertTask(BeanTask bt) throws Exception {
        String task = bt.getTask();
        Date startedAt = bt.getStartedAt();
        Date completedAt = bt.getCompletedAt();

        stmt.executeUpdate("INSERT INTO task (task, startedAt, completedAt) VALUES ('" + task + "', '" + startedAt + "', '" + completedAt + "')");
    }
    
    public void updateTast(BeanTask bt)throws Exception {
        String task = bt.getTask();
    }
}
