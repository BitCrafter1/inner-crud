package com.da.innercrud1.config;

import com.da.innercrud1.enums.Role;
import com.da.innercrud1.filter.JwtAuthentificationFilter;
import com.da.innercrud1.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;
    private final JwtAuthentificationFilter jwtAuthentificationFilter;


    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.requestMatchers("/api/authenticate")
                        .permitAll()
                        .requestMatchers("/api/customers").hasAnyAuthority(String.valueOf(Role.CUSTOMER))
                        .anyRequest().authenticated())

                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authentificationProvider()).addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }

    @Bean
    public AuthenticationProvider authentificationProvider() {
        DaoAuthenticationProvider authentificationProvider = new DaoAuthenticationProvider();
        authentificationProvider.setUserDetailsService(userService.UserDetailsService());
        authentificationProvider.setPasswordEncoder(passwordEncoder());
        return authentificationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
         {
            return config.getAuthenticationManager();
        }
    }
}