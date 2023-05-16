package com.test.depot.controller;

import com.test.depot.business.ProductBusiness;
import com.test.depot.business.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;


class ProductControllerTest {


    @Mock
    private ProductBusiness productBusiness;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testGetAllAvailbleProductsByCategorie() throws Exception {
        ProductDTO product = new ProductDTO("c1", "p1", 3);
        List<ProductDTO> productList = Arrays.asList(product);

        Mockito.when(productBusiness.getAllAvailbleProductsByCategory("c1")).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/getAllAvailbleProductsByCategorie/{category}", "c1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value(product.getCategory()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(product.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(product.getQuantity()));
    }
}
