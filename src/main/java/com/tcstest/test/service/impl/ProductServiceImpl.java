package com.tcstest.test.service.impl;

import com.tcstest.test.model.Product;
import com.tcstest.test.repository.ProductRepository;
import com.tcstest.test.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        log.info("ProductsService - getAllProducts");
        return productRepository.findAll();
    }

    @Override
    public Integer createProduct(Product product) {
        log.info("ProductsService - createProduct : " + product);
        Product save = productRepository.save(product);
        return save.getId();
    }

    @Override
    public Product getProductById(Integer id) {
        log.info("ProductsService - getProductById : " + id);
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public Integer updateProduct(Product prdct) {
        log.info("ProductsService - updateProduct : " + prdct);
        Product product = this.getProductById(prdct.getId());
        product.setDescription(prdct.getDescription());
        product.setName(prdct.getName());
        product.setPrice(prdct.getPrice());
        product.setType(prdct.getType());

        return productRepository.save(product).getId();
    }
}
