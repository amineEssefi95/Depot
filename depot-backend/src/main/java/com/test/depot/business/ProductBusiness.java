package com.test.depot.business;

import com.test.depot.business.dto.ProductDTO;

import java.util.List;

public interface ProductBusiness {

    ProductDTO addProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getAllAvailbleProductsByCategory(String categorie);
}
