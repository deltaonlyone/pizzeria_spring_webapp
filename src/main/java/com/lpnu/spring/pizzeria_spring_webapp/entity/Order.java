package com.lpnu.spring.pizzeria_spring_webapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    public Order() {
    }

    public Order(Long id,User user, String status, double totalAmount, Date dateTime) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long orderId) {
        this.id = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", dateTime=" + dateTime +
                '}';
    }
}
