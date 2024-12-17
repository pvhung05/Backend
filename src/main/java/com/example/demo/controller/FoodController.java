package com.example.demo.controller;

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService fS;

    @Autowired
    public FoodController(FoodService fS) {
        this.fS = fS;
    }

    /**
     * Get all Food products
     * @return 123
     */
    @GetMapping
    public List<Food> getAllFoods() {
        return fS.getAllFoods();
    }

    /**
     * Get a Food product by ID
     * @param id 123
     * @return 123
     */
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Optional<Food> food = fS.getFoodById(id);
        return food.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Add a new Food product
     * @param food 123
     * @return 123
     */
    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food createdFood = fS.addFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    /**
     * Update an existing Food product by ID
     * @param id 123
     * @param foodDetails 123
     * @return 123
     */
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food foodDetails) {
        try {
            Food updatedFood = fS.updateFood(id, foodDetails);

            return ResponseEntity.ok(updatedFood);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Delete a Food product by ID
     * @param id 123
     * @return 123
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        fS.deleteFood(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
