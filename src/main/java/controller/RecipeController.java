package controller;

import Opperation.Opperation;
import Tag.Tag;
import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Api рецепты", deskription = "CRUD рецепты")
public class RecipeController {

    private final RecipeService recipeService;
    private Recipe recipe;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Opperation( summary = "сохранение рецепта ")

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        Recipe recipeRs = recipeService.save(recipe);
        return ResponseEntity.ok(recipeRs);
    }
    @Opperation( summary = "получение рецепта ")

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getById(id));
    }
    @Opperation( summary = "обновление рецепта ")

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe ingredient) {
        return ResponseEntity.ok(recipeService.update(id,recipe));
    }
    @Opperation( summary = "удаление рецепта ")

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }

    @Opperation( summary = "получение всех рецептов ")

    @GetMapping("/{id}")
    public ResponseEntity<Map<Long, Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAll());
    }
}
