package com.test.depot.business.dto.mapper;

import com.test.depot.business.dto.ProductDTO;
import com.test.depot.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDto);

}
