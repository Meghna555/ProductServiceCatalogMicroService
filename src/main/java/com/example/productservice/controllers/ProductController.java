package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

/*    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }
*/

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){

        Product product = productService.getProductById(productId);
        return product;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return null;
    }

}
