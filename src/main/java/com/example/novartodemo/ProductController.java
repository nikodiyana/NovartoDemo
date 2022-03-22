package com.example.novartodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path="/product")
public class ProductController {
    @Autowired
    private ProductDatabase database;

    @PostMapping(path="/add")
    public Product addProduct(@RequestParam String name, @RequestParam float price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        return database.save(p);    // Add the new product to database repository
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return database.findById(id);
    }

    @GetMapping("/all")
    List<Product> all() {
        return (List<Product>) database.findAll();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, Product newProduct) {
        Optional<Product> p = getProductById(id);
        if (p.isPresent()) {
            p.get().updateWith(newProduct);
            database.save(p.get());
        } else {
            // Handle product not found case here
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        database.deleteById(id);
    }
}
