/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author clara
 */
public class BeanTask  implements Serializable {
    private int id;
    private String task;
    private Date startedAt;
    private Date completedAt;

    public BeanTask() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "BeanTask{" + "id=" + id + ", task=" + task + ", startedAt=" + startedAt + ", completedAt=" + completedAt + '}';
    }
    
}
