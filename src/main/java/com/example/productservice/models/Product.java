package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;

    @ManyToOne
    private Category category;

    /*Product <-> Category => M : 1
        here, 1 P -> 1 C
               1 C ->  Many P
     */

}
