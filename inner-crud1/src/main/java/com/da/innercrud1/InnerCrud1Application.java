package com.da.innercrud1;

import com.da.innercrud1.enums.Role;
import com.da.innercrud1.model.Customer;
import com.da.innercrud1.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InnerCrud1Application {

	public static void main(String[] args) {
		SpringApplication.run(InnerCrud1Application.class, args);
	}



	@Bean
	CommandLineRunner initDatabase(CustomerRepository customerRepository) {
		return args -> {
			if (customerRepository.findByEmail("ali@gmail.com").isEmpty()) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				Customer customer = new Customer();
				customer.setName("Ali");
				customer.setEmail("ali@gmail.com");
				customer.setPassword(encoder.encode("alibosssman"));
				customer.setUsername("alibos");
				customer.setRole(Role.valueOf("CUSTOMER"));
				customerRepository.save(customer);
				System.out.println("✅ Utilisateur Ali inséré avec succès !");
			} else {
				System.out.println("⚠️ L'utilisateur Ali existe déjà !");
			}
		};
	}

}
