package com.example.novartodemo;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Product {
    // Product fields
    private @Id long id;
    private long uin;
    private String name = "";
    private String priceDescription = "";
    private float price;

    // Category fields
    private long categoryId;
    private long categoryUin;
    private String categoryName = "";
    private String references = "";   // Comma-delimited string containing IDs of referenced products

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    // Returns a Java Set from comma-delimited string of reference ids
    private Set<String> getReferencesAsSet() {
        return Arrays.stream(references.split(",")).collect(Collectors.toSet());
    }

    // Creates comma-delimited string of reference ids from Java Set
    private void setReferencesFromSet(Set<String> refs) {
        setReferences(String.join(",", refs));
    }

    public void addReference(String reference) {
        Set<String> refs = getReferencesAsSet();
        refs.add(reference);
        setReferencesFromSet(refs);
    }

    public void removeReference(String reference) {
        Set<String> refs = getReferencesAsSet();
        refs.remove(reference);
        setReferencesFromSet(refs);
    }
}
