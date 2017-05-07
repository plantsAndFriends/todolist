/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe bean amb els atributs, constructor, getters i setters d'una tasca
 *
 * @author clara
 */
public class BeanTask  implements Serializable {
    private int id;
    private String task;
    private Date startedAt;
    private Date completedAt;
    private int user_id;

    /**
     * Constructor per defecte d'una BeanTask
     */
    public BeanTask() {
    
    }

    /**
     * Getter de l'Id
     * @return id de la tasca
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'id
     * @param id nou a insertar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del text de la tasca
     * @return el text de la tasca
     */
    public String getTask() {
        return task;
    }

    /**
     * Setter del text de la tasca
     * @param task el text de la tasca
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Getter de l'inici de la tasca
     * @return la data inici
     */
    public Date getStartedAt() {
        return startedAt;
    }

    /**
     * Setter de l'inici de la tasca
     * @param startedAt la data inici
     */
    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * Getter del final de la tasca
     * @return la data final
     */
    public Date getCompletedAt() {
        return completedAt;
    }
    
    /**
     * Setter del final de la tasca
     * @param completedAt la data final
     */
    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    /**
     * Getter del id de l'usuari
     * @return l'id de l'usuari
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Setter del id de l'usuari
     * @param user_id l'id de l'usuari
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    /**
     * El toString()
     * @return un String amb tots els atributs d'una tasca
     */
    @Override
    public String toString() {
        return "BeanTask{" + "id=" + id + ", task=" + task + ", startedAt=" + startedAt + ", completedAt=" + completedAt + '}';
    }
    
}
