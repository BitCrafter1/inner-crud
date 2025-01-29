package com.da.innercrud1.service;

import com.da.innercrud1.dto.ProductDto;
import com.da.innercrud1.exception.ProductNotFoundException;
import com.da.innercrud1.mapper.ProductMapper;
import com.da.innercrud1.model.Product;
import com.da.innercrud1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService { public  ProductService(ProductRepository productRepository,ProductMapper productMapper){
    this.productRepository = productRepository;
    this.productMapper = productMapper;
}


    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toModel(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return productMapper.toDto(product);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productMapper.updateProduct(productDto, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found");
        }
        productRepository.deleteById(id);

    }
}
