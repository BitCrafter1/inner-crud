package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.ProductDto;
import com.da.innercrud1.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductMapper  {

    Product toModel(ProductDto productDto);
    ProductDto toDto(Product product);

    void updateProduct(ProductDto productDto, @MappingTarget Product product);
}
