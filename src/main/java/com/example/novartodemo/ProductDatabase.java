package com.example.novartodemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDatabase extends CrudRepository<Product, Integer> {

}
