package ru.pupkov.stas.cdek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "tasks")
public class TaskForCalling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer orderId;

    @Column(nullable = false)
    private Date orderCreationTime;

    @Column(nullable = false)
    private Date taskAddingTime;

    private boolean taskIsCompleted;

    public TaskForCalling() {
    }

    public TaskForCalling(Integer orderId,
                          Date orderCreationTime,
                          Date taskAddingTime,
                          boolean taskIsCompleted) {
        this.orderId = orderId;
        this.orderCreationTime = orderCreationTime;
        this.taskAddingTime = taskAddingTime;
        this.taskIsCompleted = taskIsCompleted;
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

    public Date getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(Date orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public Date getTaskAddingTime() {
        return taskAddingTime;
    }

    public void setTaskAddingTime(Date taskAddingTime) {
        this.taskAddingTime = taskAddingTime;
    }

    public boolean isTaskIsCompleted() {
        return taskIsCompleted;
    }

    public void setTaskIsCompleted(boolean taskIsCompleted) {
        this.taskIsCompleted = taskIsCompleted;
    }
}
