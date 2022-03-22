package com.example.novartodemo;

// Product Class
// The data model containing product information



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;



@Entity
public class Product {
    // Product fields
    private @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    private long uin;
    private String name = "";
    private String priceDescription = "";
    private double price;

    // Category fields
    private int categoryId;
    private long categoryUin;
    private String categoryName = "";
    private String referenceIds = "";   // Comma-delimited string containing IDs of referenced products

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReferenceIds() {
        return referenceIds;
    }

    public void setReferenceIds(String referenceIds) {
        this.referenceIds = referenceIds;
    }

    // Returns a String set from comma-delimited string of reference ids
    private Set<String> getReferenceIdsAsSet() {
        return Arrays.stream(referenceIds.split(",")).collect(Collectors.toSet());
    }

    // Creates comma-delimited string of reference ids from Set
    private void setReferenceIdsFromSet(Set<String> refs) {
        setReferenceIds(String.join(",", refs));
    }

    public void addReferenceId(int id) {
        if (referenceIds.length() == 0) {
            referenceIds = String.valueOf(id);  // Quick add if referenceIds is empty
        } else {
            Set<String> refs = getReferenceIdsAsSet();
            refs.add(String.valueOf(id));
            setReferenceIdsFromSet(refs);
        }
    }

    public void removeReferenceId(int id) {
        Set<String> refs = getReferenceIdsAsSet();
        refs.remove(String.valueOf(id));
        setReferenceIdsFromSet(refs);
    }

    public void updateWith(Product newProduct) {
        this.name = newProduct.name;
        this.uin = newProduct.uin;
        this.price = newProduct.price;
        this.priceDescription = newProduct.priceDescription;
        this.categoryId = newProduct.categoryId;
        this.categoryUin = newProduct.categoryUin;
        this.categoryName =newProduct.categoryName;
        this.referenceIds = newProduct.referenceIds;
    }

    // The rest of the getters and setters
    // ...
}
