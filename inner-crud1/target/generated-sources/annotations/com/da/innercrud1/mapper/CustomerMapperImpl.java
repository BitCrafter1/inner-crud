package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.CustomerDto;
import com.da.innercrud1.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-30T15:33:49+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setUsername( customer.getUsername() );
        customerDto.setPassword( customer.getPassword() );

        return customerDto;
    }

    @Override
    public Customer toModel(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.username( customerDto.getUsername() );
        customer.password( customerDto.getPassword() );

        return customer.build();
    }

    @Override
    public void updateCustomer(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return;
        }

        customer.setUsername( customerDto.getUsername() );
        customer.setPassword( customerDto.getPassword() );
    }
}
