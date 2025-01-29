package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.CustomerDto;
import com.da.innercrud1.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toModel(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto, @MappingTarget Customer customer);
}
