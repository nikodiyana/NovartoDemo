package com.example.novartodemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovartoDemoApplicationTests {

    // Test operations on the comma-delimited reference String for each product
    @Test
    public void testReferencesOperations() {
        // Create example references list
        Product p = new Product();
        p.setReferences("Monitor,Keyboard,Mouse");
        System.out.println("Reference list contains: " + p.getReferences());

        // Add to reference list
        System.out.println("Adding reference \"Trackpad\"");
        p.addReference("Trackpad");
        System.out.println("Reference list contains: " + p.getReferences());

        // Remove from reference list
        System.out.println("Removing reference \"Mouse\"");
        p.removeReference("Mouse");
        System.out.println("Reference list contains: " + p.getReferences());

        Assertions.assertEquals("Monitor,Keyboard,Trackpad",p.getReferences());
    }

    @Test
    void contextLoads() {
    }

}
