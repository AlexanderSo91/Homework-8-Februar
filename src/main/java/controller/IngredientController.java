package controller;

import Opperation.Opperation;
import Tag.Tag;
import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IngredientService;

import java.util.Map;


@RestController
@RequestMapping("/ingredient")
@Tag(name = "Api ингредиенты", deskription = "CRUD операции")
public class IngredientController {
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;

    }
    @Opperation( summary = "сохранение ингредиентов")
    @PostMapping
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.save(ingredient));
    }
    @Opperation(summary = "Получение ингредиентов по id")

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable Long id) {
        return ResponseEntity.of(ingredientService.getById(id));
    }
    @Opperation(summary = "Обновление ингриента")

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.update(id, ingredient));
    }
    @Opperation(summary = "Удаление ингридиента")

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientService.delete(id));
    }
    @Opperation(summary = "Получение  всех ингридиентов")

    @GetMapping("/{id}")
    public ResponseEntity<Map<Long, Ingredient>> getAll() {
        return ResponseEntity.ok(ingredientService.getAll());
    }
}
