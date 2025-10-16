package com.vinisha.spring.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinisha.spring.Models.Product;
import com.vinisha.spring.Repos.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    // Get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Add new product
    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    // Edit existing product
    public Product editProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    return productRepository.save(product);
                })
                .orElse(null);
    }

    // Delete product by ID
    public String deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted successfully!";
        } else {
            return "Product not found!";
        }
    }
}
