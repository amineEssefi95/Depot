package com.test.depot.controller;

import com.test.depot.business.ProductBusiness;
import com.test.depot.business.dto.ProductDTO;
import com.test.depot.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;

@SpringJUnitConfig
class ProductControllerTest {


    @Mock
    private ProductBusiness productBusiness;

    @InjectMocks
    private ProductController productController;

    @Test
    void testGetProductById() {
        ProductDTO product = new ProductDTO("c1", "p1", 3);
        List<ProductDTO> productList = Arrays.asList(product);

       Mockito.when(productBusiness.getAllAvailbleProductsByCategory("c1")).thenReturn(productList);

        ResponseEntity<List<ProductDTO>> response = productController.getAllAvailbleProductsByCategorie("c1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }
}
