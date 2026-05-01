package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;

//    public FakeStoreProductService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Override
    public Product getProductById(long id) {

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
                );
        // Convert FakeStoreProductDto to Product
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        //Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if( fakeStoreProductDto != null ) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setImageUrl(fakeStoreProductDto.getImage());

            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getCategory());

            product.setCategory(category);

            return product;

        }
        return null;
    }
}
