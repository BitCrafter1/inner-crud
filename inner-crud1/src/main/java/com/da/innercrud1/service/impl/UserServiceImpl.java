package com.da.innercrud1.service.impl;

import com.da.innercrud1.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final CustomerRepository customerRepository;


@Override
    public UserDetailsService UserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return customerRepository.findByEmail(username).orElseThrow(()  -> new UsernameNotFoundException("User Not Found"));
            }



            };
        }
    }




