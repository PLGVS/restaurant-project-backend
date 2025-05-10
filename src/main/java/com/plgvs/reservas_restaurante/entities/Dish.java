package com.plgvs.reservas_restaurante.entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;

public class Dish {

    private String name;
    private String imageUrl;
    private Set<String> ingredients;
    private Double price;

    public Dish(){}

    public Dish(String name, String imageUrl, Set<String> ingredients, Double price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString(){
        return "Name: " + getName() + "\n"
             + "ImageURL: " + getImageUrl() + "\n"
             + "Ingredients: " + getIngredients() + "\n"
             + "Price: " + getPrice();
    }
}
