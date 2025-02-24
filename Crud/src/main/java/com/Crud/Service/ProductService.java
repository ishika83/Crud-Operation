package com.Crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Crud.Entity.Product;
import com.Crud.Repository.ProductRepository;

@Service
public class ProductService 
{
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable)
    {
        return productRepository.findAll(pageable);
    }

    public Product createProduct(Product product) 
    {
        return productRepository.save(product);
    }

    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product)
    {
        if (productRepository.existsById(id))
        {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) 
    {
        productRepository.deleteById(id);
    }
}