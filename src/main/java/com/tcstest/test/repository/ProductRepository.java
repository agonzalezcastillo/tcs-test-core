package com.tcstest.test.repository;

import com.tcstest.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends JpaRepository<Product,  Integer> {
}
