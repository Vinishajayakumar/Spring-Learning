package com.vinisha.spring.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vinisha.spring.Models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
