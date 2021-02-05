package com.example.demo.Repositories;

import com.example.demo.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
