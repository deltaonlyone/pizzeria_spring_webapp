package com.lpnu.spring.pizzeria_spring_webapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PizzaID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private double price;

    @ManyToMany
    @JoinTable(name = "pizza_ingredients", joinColumns = @JoinColumn(name = "PizzaID"), inverseJoinColumns = @JoinColumn(name = "IngredientID"))
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public Pizza(Long pizzaId, String name, String description, int price) {
        this.id = pizzaId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long pizzaId) {
        this.id = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredientList) {
        this.ingredients = ingredientList;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


}
