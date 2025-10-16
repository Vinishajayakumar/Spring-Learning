package com.vinisha.spring.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vinisha.spring.Models.Product;
import com.vinisha.spring.Services.ProductService;

@RestController
@RequestMapping("/products")
public class vinisha {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @PutMapping("/edit/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.editProduct(id, updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
