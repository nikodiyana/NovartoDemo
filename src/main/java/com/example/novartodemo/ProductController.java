package com.example.novartodemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    @PostMapping(path="/add")
    public String addProduct(@RequestParam String name, @RequestParam float price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        //database.save(p);    // Not implemented yet - Add the new product to database repository

        return "Product Added Successfully";
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable long id) {
        //return database.findById(id);  // Not implemented yet
        return new Product();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable long id, Product updatedProduct) {
        Product p = getProductById(id);
        p.setName(updatedProduct.getName());
        p.setPrice(updatedProduct.getPrice());

        // Update the rest of the product fields
        // ...

        // Update the database
        // ..
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        //database.deleteById(id);  // Not implemented yet
    }
}
