package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.ProductDto;
import com.da.innercrud1.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T15:33:49+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );

        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }

    @Override
    public void updateProduct(ProductDto productDto, Product product) {
        if ( productDto == null ) {
            return;
        }

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
    }
}
