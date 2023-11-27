package com.lpnu.spring.pizzeria_spring_webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PizzaID")
    private Pizza pizza;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "UnitPrice")
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, Order order, Pizza pizza, int quantity, int unitPrice) {
        this.id = orderItemId;
        this.order = order;
        this.pizza = pizza;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long orderItemId) {
        this.id = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + id +
                ", order=" + order +
                ", pizza=" + pizza +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }



}
