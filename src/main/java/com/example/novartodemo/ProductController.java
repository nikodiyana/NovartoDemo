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
        return null;
    }

    @PutMapping("/{id}")
    public void replaceProduct(Product newProduct, @PathVariable long id) {
        Product p = getProductById(id);
        p.setName(newProduct.getName());
        p.setPrice(newProduct.getPrice());

        // Update the rest of the fields
        // ...
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        //database.deleteById(id);  // Not implemented yet
    }
}
