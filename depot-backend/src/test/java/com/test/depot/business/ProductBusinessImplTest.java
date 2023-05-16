package com.test.depot.business;

import com.test.depot.business.dto.ProductDTO;
import com.test.depot.business.dto.mapper.ProductMapper;
import com.test.depot.business.dto.mapper.ProductMapperImpl;
import com.test.depot.business.impl.ProductBusinessImpl;
import com.test.depot.model.Product;
import com.test.depot.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringJUnitConfig
class ProductBusinessImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductBusiness productBusiness = new ProductBusinessImpl();


    private ProductMapper productMapper = new ProductMapperImpl();

    List<Product> productList1, productList2;

    @BeforeEach
    public void init() {
        Product product1 = new Product("1", "C1", "P1", 3);
        Product product2 = new Product("2", "C2", "P2", 6);

        productList1 = Arrays.asList(product1, product2);
        productList2 = Arrays.asList(product1);

    }

    @Test
    void testGetAllProducts() {
        ReflectionTestUtils.setField(productBusiness, "productMapper", productMapper);
        when(productRepository.findAll()).thenReturn(productList1);

        List<ProductDTO> result = productBusiness.getAllProducts();

        assertEquals(2, result.size());

    }

    @Test
    void testGetAllAvailbleProductsByCategory() {
        ReflectionTestUtils.setField(productBusiness, "productMapper", productMapper);
        when(productRepository.findByCategoryIgnoreCaseAndQuantityGreaterThan("C1", 0)).thenReturn(productList2);

        List<ProductDTO> result = productBusiness.getAllAvailbleProductsByCategory("C1");
        ProductDTO productDTO = result.get(0);

        assertEquals(1, result.size());
        assertEquals("P1", productDTO.getName());
        assertEquals("C1", productDTO.getCategory());
        assertEquals(3, productDTO.getQuantity());

    }
}
