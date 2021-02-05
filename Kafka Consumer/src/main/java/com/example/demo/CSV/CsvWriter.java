package com.example.demo.CSV;

import com.example.demo.Entities.Facture;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.Writer;


@Component
public class CsvWriter {
    public void Write(Facture facture) throws Exception {
        Writer writer = new FileWriter("Factures.csv",true);
        writer.append(Long.toString(facture.getId())+","+facture.getName()+","+Double.toString(facture.getMontant())+"\n");
        writer.close();
    }
}
