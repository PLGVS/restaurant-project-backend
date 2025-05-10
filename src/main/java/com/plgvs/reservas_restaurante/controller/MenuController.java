package com.plgvs.reservas_restaurante.controller;

import com.mongodb.MongoWriteException;
import com.plgvs.reservas_restaurante.entities.Category;
import com.plgvs.reservas_restaurante.entities.Dish;
import com.plgvs.reservas_restaurante.services.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping("/add-category")
    public String addCategory(@RequestBody Category category){
        try {
            menuService.addCategory(category);
            return "Added category";
        }
        catch (MongoWriteException e){
            return "This category is already on the database";
        }
    }

    @PostMapping("/{categoryName}/add-dish")
    public String addDish(@RequestBody Dish dish, @PathVariable("categoryName") String categoryName){
        menuService.addDish(categoryName, dish);
        return "Dish added!";
    }

    @GetMapping("/{categoryName}/dishes")
    public List<String> getDishes(@PathVariable("categoryName") String categoryName){
        return menuService.getDishes(categoryName);
    }
}
