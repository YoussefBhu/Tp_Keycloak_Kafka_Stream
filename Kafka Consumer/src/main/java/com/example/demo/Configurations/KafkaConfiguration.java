package com.example.demo.Configurations;

import com.example.demo.Entities.Facture;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConfiguration {

        ConsumerFactory<String, Object> consumerFactory(){
            Map<String, Object> config=new HashMap<>();
            config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
            JsonDeserializer<Facture> jsonDeserializer= new JsonDeserializer<>(Facture.class);
            jsonDeserializer.addTrustedPackages("*");
            jsonDeserializer.setUseTypeHeaders(false);
            return new DefaultKafkaConsumerFactory(config,new StringDeserializer(),jsonDeserializer);
        }
        @Bean
        ConcurrentKafkaListenerContainerFactory<String,Facture> kafkaListenerContainerFactory(){
            ConcurrentKafkaListenerContainerFactory factory=new ConcurrentKafkaListenerContainerFactory();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }
}
