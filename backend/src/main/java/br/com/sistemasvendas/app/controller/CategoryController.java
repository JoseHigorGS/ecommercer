package br.com.sistemasvendas.app.controller;

import br.com.sistemasvendas.app.model.Category;
import br.com.sistemasvendas.app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @PostMapping("/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {

        if (category.getId() != null) {
            category.setId(null);
        }
        Category result = service.saveCategory(category);
        if (result != null) {
            service.saveCategory(category);
            return ResponseEntity.status(200).body(result);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category result = service.saveCategory(category);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(name = "id") Integer id) {
        Category category = new Category();
        category.setId(id);
        Category result = service.deleteCategory(category);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/category")
    public ResponseEntity<ArrayList<Category>> getAllCategory() {
        return ResponseEntity.ok().body(service.getAllCategory());
    }

    @GetMapping("/category/search")
    public ResponseEntity<ArrayList<Category>> getByKey(@RequestParam(name = "key") String key) {

        if (key != null) {
            return ResponseEntity.ok().body(service.getByKey(key));
        }

        return ResponseEntity.badRequest().build();
    }
}
