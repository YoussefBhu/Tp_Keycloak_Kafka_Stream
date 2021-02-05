package com.example.demo.Services;

import com.example.demo.CSV.CsvWriter;
import com.example.demo.Entities.Facture;
import com.example.demo.Repositories.FactureRepository;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {
    @Autowired
    private FactureRepository factureRepository ;

    @Autowired
    private CsvWriter csvWriter ;

    @KafkaListener(topics = {"FACTURATION"},groupId = "test-consumer-group")
    public void GetMessage(Facture facture) throws Exception {
        System.out.println(factureRepository.save(facture));
        csvWriter.Write(facture);
    }
}
