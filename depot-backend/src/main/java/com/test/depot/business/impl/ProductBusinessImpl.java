package com.test.depot.business.impl;

import com.test.depot.business.ProductBusiness;
import com.test.depot.business.dto.ProductDTO;
import com.test.depot.business.dto.mapper.ProductMapper;
import com.test.depot.model.Product;
import com.test.depot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBusinessImpl implements ProductBusiness {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toEntity(productDTO));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDto).toList();
    }

    @Override
    public List<ProductDTO> getAllAvailbleProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategoryIgnoreCaseAndQuantityGreaterThan(category, 0);
        return products.stream().map(productMapper::toDto).toList();
    }
}
