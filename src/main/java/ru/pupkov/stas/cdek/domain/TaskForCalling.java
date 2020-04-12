package ru.pupkov.stas.cdek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "tasks")
public class TaskForCalling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer orderId;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Date addingTime;

    private boolean completedTask;

    public TaskForCalling() {
    }

    public TaskForCalling(Integer orderId, Date date, Date addingTime, boolean completedTask) {
        this.orderId = orderId;
        this.date = date;
        this.addingTime = addingTime;
        this.completedTask = completedTask;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(Date addingTime) {
        this.addingTime = addingTime;
    }

    public boolean isCompletedTask() {
        return completedTask;
    }

    public void setCompletedTask(boolean completedTask) {
        this.completedTask = completedTask;
    }
}
