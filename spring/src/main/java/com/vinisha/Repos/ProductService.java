package com.vinisha.Repos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varshaa.haii.models.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product>GetProducts()
    {
        return productRepo.findAll();
    }

    public Product AddProduct(Product newproduct)
    {
        return productRepo.save(newproduct);
    }

    public Product EditProduct(Long id, Product updateproduct)
    {
        Product oldproduct= productRepo.findById(id).orElse(other:null);
        if(oldproduct!=null)
        {
            oldproduct.setName(updateproduct.getName());
            oldproduct.setDescription(updateproduct.getDescription());
            oldproduct.setPrice(updateproduct.getPrice());
            oldproduct.setQuantity(updateproduct.getQuantity());
            return productRepo.saveAndFlush(oldproduct);
        }
        return null;
    }
    public String DeleteProduct(Long id)
    {
         Product oldproduct= productRepo.findById(id).orElse(other:null);
         if(foundproduct!=null)
         {
            productRepo deletedById(id);
            return foundproduct.getName() +"Deleted !";
         }
         else
         {
            return "Product not found !";
         }


    }

}