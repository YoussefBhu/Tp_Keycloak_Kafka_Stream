package com.example.demo;

import com.example.demo.Entities.Bill;
import com.example.demo.Entities.ProductItem;
import com.example.demo.Repositories.BillRepository;
import com.example.demo.Repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (BillRepository billRepository, ProductItemRepository productItemRepository){
        return args->{
            Bill bill = new Bill();
            bill.setCustomerId(1);
            bill.setDate(new Date());
            Bill SavedBill = billRepository.save(bill);
            ProductItem p1 = new ProductItem(null,null,Integer.toUnsignedLong(1),30000,2,SavedBill);
            ProductItem p2 = new ProductItem(null,null,Integer.toUnsignedLong(2),30000,2,SavedBill);
            List<ProductItem> list = new ArrayList<ProductItem>();
            list.add(p1);
            list.add(p2);
            productItemRepository.saveAll(list);
        };
    }
}
