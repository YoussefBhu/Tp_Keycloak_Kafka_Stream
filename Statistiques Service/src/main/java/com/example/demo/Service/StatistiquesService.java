package com.example.demo.Service;

import com.example.demo.Entities.Facture;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.internals.TimeWindow;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StatistiquesService {
    @Bean
    public Function<KStream<String, Facture>,KStream<String ,Long>> CountUserBills(){
        return (input)->{
            return input
                    .map((k,v)->new KeyValue<>(v.getName(),0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Long()))
                    .windowedBy(TimeWindows.of(5000))
                    .count()
                    .toStream()
                    .map((k,v)->new KeyValue<>(k.key(),v));
        };
    }

    @Bean
    public Function<KStream<String, Facture>,KStream<String,Long>> CountBills(){
        return (input)->{
            return input
                    .map((k,v)->new KeyValue<>("input",0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Long()))
                    .windowedBy(TimeWindows.of(5000))
                    .count()
                    .toStream()
                    .map((k,v)->new KeyValue<>("output in last 5 s",v));
        };
    }
}

