package com.tcstest.test.api;

import com.tcstest.test.model.Product;
import com.tcstest.test.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/product")
public class ProductsController {

    private ProductService productService;

    @RequestMapping(value="/",  produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
        log.info("ProductsController - getProducts");
        List<Product> productsList = productService.getAllProducts();
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @RequestMapping(value="/",  produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Integer> createProduct(@RequestBody Product product){
        log.info("ProductsController - createProducts");
        Integer productId = productService.createProduct(product);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",  produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable(name="id") Integer productId){
        log.info("ProductsController - getProduct :" + productId);
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value="/",  produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateProduct(@RequestBody Product product){
        log.info("ProductsController - getProduct :" + product.getId());
        Integer productId = productService.updateProduct(product);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

}
