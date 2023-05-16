package com.test.depot.controller;

import com.test.depot.business.ProductBusiness;
import com.test.depot.business.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductBusiness productBusiness;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(this.productBusiness.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDto) {
        return ResponseEntity.status(201).body(this.productBusiness.addProduct(productDto));
    }

    @GetMapping("/getAllAvailbleProductsByCategorie/{category}")
    public ResponseEntity<List<ProductDTO>> getAllAvailbleProductsByCategorie(@PathVariable("category") String category) {
        return ResponseEntity.ok(this.productBusiness.getAllAvailbleProductsByCategory(category));
    }
}
