package com.lpnu.spring.pizzeria_spring_webapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Status")
    private String status;

    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;

    @Column(name = "DateTime")
    private Date dateTime;

    public Order() {
    }

    public Order(Long orderId, User user, String status, BigDecimal totalAmount, Date dateTime) {
        this.id = orderId;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
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
