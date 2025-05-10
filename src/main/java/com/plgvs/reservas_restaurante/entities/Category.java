package com.plgvs.reservas_restaurante.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {
    private String categoryName;
    private List<Dish> dishes;

    public Category(){}

    public Category(String categoryName, List<Dish> dishes) {
        this.categoryName = categoryName;
        this.dishes = dishes;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
