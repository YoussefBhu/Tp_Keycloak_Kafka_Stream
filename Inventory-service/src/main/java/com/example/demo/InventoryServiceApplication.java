package com.example.demo;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (ProductRepository productRepository){
        return args->{
            productRepository.save(new Product(null,"Lenovo Legion 5",11000));
            productRepository.save(new Product(null,"MSI GF63",15000));
            productRepository.save(new Product(null,"Alienware  m15 r3",19000));
        };
    }
}
