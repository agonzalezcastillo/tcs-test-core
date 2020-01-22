package com.tcstest.test.service;

import com.tcstest.test.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Integer createProduct(Product product);
    Product getProductById(Integer id);
    Integer updateProduct(Product product);
}
