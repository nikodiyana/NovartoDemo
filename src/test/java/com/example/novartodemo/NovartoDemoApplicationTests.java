package com.example.novartodemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NovartoDemoApplicationTests {

    @Autowired
    private ProductController controller;

    // Test Database CRUD operations
    @Test
    public void testDatabaseOperations() {

        // Database Create
        Product createdProduct = controller.addProduct("Some Product", 3499.0f);
        int id = createdProduct.getId(); // Save id for access later
        assertEquals(1, controller.all().size()); // Check if database contains one entity

        // Database Read
        Optional<Product> p = controller.getProductById(id);
        if (p.isPresent()) {
            // Add product reference Ids
            p.get().addReferenceId(1234);
            p.get().addReferenceId(5678);
            assertEquals("1234,5678", p.get().getReferenceIds());

            // Modify product reference Ids
            p.get().removeReferenceId(5678);
            assertEquals("1234", p.get().getReferenceIds());

            p.get().addReferenceId(9876);

            // Database Update
            controller.updateProduct(id, p.get());
        }

        // Read after update
        Optional<Product> updatedP = controller.getProductById(id);
        updatedP.ifPresent(product -> assertEquals("9876,1234", product.getReferenceIds()));

        // Database Delete
        controller.deleteProduct(id);
        assertEquals(0, (long) controller.all().size()); // Check if database contains is empty
    }
}
