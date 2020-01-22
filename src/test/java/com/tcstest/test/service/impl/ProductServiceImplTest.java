package com.tcstest.test.service.impl;

import com.tcstest.test.model.Product;
import com.tcstest.test.repository.ProductRepository;
import com.tcstest.test.service.ProductService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    private List<Product> productList;

    @Before
    public void setUp() throws Exception {
        productList =  new ArrayList<>();
        Product p1 = Product.builder().id(1)
                .name("tshirt")
                .type("clothes")
                .price(50.99)
                .description("large tshirt").build();

        productList.add(p1);

    }

    @Test
    public void shouldReturnAproduct(){
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> product =productRepository.findAll();
        verify(productRepository).findAll();
        assertEquals(1,productList.size());
        assertEquals("clothes",productList.get(0).getType());
    }
}