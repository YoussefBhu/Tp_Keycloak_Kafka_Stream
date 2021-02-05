package com.example.demo.Configuration;

import com.example.demo.Entities.Facture;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class KafkaProducer {
    List<String> names = Arrays.asList("user1","user2","user3");
    Random rand = new Random();
    long id = 0 ;
    @Bean
    public Supplier<Facture> factureSupplier(){
        return ()-> new Facture(++id, names.get(rand.nextInt(names.size())) , (int)(Math.random()*1000)+1);
    }
}
