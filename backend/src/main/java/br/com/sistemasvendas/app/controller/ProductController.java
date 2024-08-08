package br.com.sistemasvendas.app.controller;

import br.com.sistemasvendas.app.model.Product;
import br.com.sistemasvendas.app.service.IProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private IProductService service;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        Product result = service.saveProduct(product);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product result = service.updateProduct(product);
        if (result != null) {
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable (name = "id") Integer id){
        var product = new Product();
        product.setId(id);
        Product result = service.deleteProduct(product);
        if (result!=null){
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/product")
    public ResponseEntity<ArrayList<Product>> getAllProduct(){
        return ResponseEntity.status(200).body(service.getAllProduct());
    }

    @GetMapping("/product/search")
    public ResponseEntity<ArrayList<Product>> getByKey(@RequestParam (name = "key") String key){
        if (key != null){
            return ResponseEntity.status(200).body(service.getByKey(key));
        }
        return ResponseEntity.badRequest().build();
    }
}
