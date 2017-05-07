/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import model.pojo.BeanTask;
import model.pojo.BeanUser;

/** Classe Bean que tractarà tots els moviments a la base de dades relacionats
 *  amb les tasques.
 *
 * @author clara
 */
public class DAOTask extends Bd {
    private Connection conn;
    private Statement stmt;

    public DAOTask() throws Exception {
        conn = getConnexio();
        stmt = conn.createStatement();
    }

    /**
     * Mètode que insertarà tasques a la BD.
     * 
     * Guardarà l'String de la tasca (la tasca en si) i l'id de l'usuari que
     * l'ha escrit.
     * 
     * @param task la tasca
     * @param userId l'id de l'usuari que l'ha escrit
     * @throws Exception 
     */
    public void insertTask(String task, int userId) throws Exception {
        stmt.executeUpdate("INSERT INTO task (task, user_id) VALUES ('" + task + "','" + userId + "')");
    }

    /**
     * Mètode per llistar les tasques.
     * 
     * Retornarà un ArrayList de tipus BeanTask amb l'id de la tasca, el
     * contingut, la data la qual comença, la data en la qual acaba i l'id
     * de l'usuari.
     * 
     * @param userId l'id de l'usuari de les tasques
     * @return un arraylist de les tasques
     * @throws Exception 
     */
    public ArrayList<BeanTask> getTasks(int userId) throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT * FROM task WHERE user_id = " + userId + " ORDER BY id ");

        ArrayList<BeanTask> listTask = new ArrayList();

        while (rs.next()) {
            BeanTask task = new BeanTask();

            int id = rs.getInt("id");
            String t = rs.getString("task");
            Date st = rs.getDate("startedAt");
            Date ct = rs.getDate("completedAt");
            int uId = rs.getInt("user_id");

            task.setId(id);
            task.setTask(t);
            task.setStartedAt(st);
            task.setCompletedAt(ct);
            task.setUser_id(uId);
            listTask.add(task);
        }
        return listTask;

    }

    /**
     * Mètode per esborrar una tasca.
     * 
     * Executa una query d'SQL per esborrar aquella tasca.
     * 
     * @param id de la tasca en qüestió
     * @throws SQLException 
     */
    public void removeTask(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM task WHERE id = " + id);
    }

    /**
     * Mètode per començar a temporitzar una tasca.
     * 
     * Exeucta una query d'SQL per posar a la columna `startedAt` (que fins ara 
     * era NULL) la data i hora d'aquell moment, moment en el qual es comença
     * una tasca.
     * 
     * @param id de la tasca en qüestió
     * @throws SQLException 
     */
    public void startTask(int id) throws SQLException {
        stmt.executeUpdate("UPDATE task SET startedAt = NOW() WHERE id = " + id);
    }

    /**
     * Mètode per aturar de temporitzar una tasca.
     * 
     * Exeucta una query d'SQL per posar a la columna `completedAt` (que fins
     * ara era NULL) la data i hora d'aquell moment, moment en el qual s'ha 
     * acabat una tasca.
     * 
     * @param id
     * @throws SQLException 
     */
    public void pauseTask(int id) throws SQLException {
        stmt.executeUpdate("UPDATE task SET completedAt = NOW() WHERE id = " + id);
    }

    /**
     * Mètode que retorna la data i hora en la qual es va començar una tasca.
     * 
     * @param id de la tasca en qüestió
     * @return Date start, que pot ser null si no està començada
     * @throws SQLException 
     */
    public Date getStartedAt(int id) throws SQLException {
        Date start = null;
        String sql = "SELECT startedAt FROM task WHERE id = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            start = rs.getTimestamp("startedAt");
        }
        System.out.println(start);
        return start;
    }

    /**
     * Mètode que retorna la data i hora en la qual es va acabar una tasca.
     * 
     * @param id de la tasca en qüestió
     * @return Date pause, que pot ser null si no està acabada
     * @throws SQLException 
     */
    public Date getCompletedAt(int id) throws SQLException {
        Date pause = null;
        String sql = "SELECT completedAt FROM task WHERE id = " + id;

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            pause = rs.getTimestamp("completedAt");
        }

        return pause;
    }

    /**
     * Mètode que calcula el temps total invertit en una tasca.
     * 
     * @param st data en la qual comença
     * @param ct data en la qual acaba
     * @return el temps total en minuts
     */
    public long totalTime(Date st, Date ct) {       
        String start = st.toString();
        String completed = ct.toString();

        long diff = ct.getTime() - st.getTime();
        System.out.println("funciones diff?" + diff);
        long diffMin = diff / (60 * 1000) % 60;
                          
        return diffMin;
    }
}
