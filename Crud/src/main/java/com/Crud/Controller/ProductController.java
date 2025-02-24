package com.Crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Crud.Entity.Product;
import com.Crud.Service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) 
    {
        return productService.getAllProducts(pageable);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) 
    {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) 
    {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) 
    {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }
}

