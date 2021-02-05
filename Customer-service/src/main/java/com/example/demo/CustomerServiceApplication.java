package com.example.demo;

import com.example.demo.Entity.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (CustomerRepository customerRepository){
        return args->{
                customerRepository.save(new Customer(null ,"Bichou","Youssef","youssef@bichou.com"));
                customerRepository.save(new Customer(null ,"Bichou","Hamza","hamza@bichou.com"));
        };
    }
}
