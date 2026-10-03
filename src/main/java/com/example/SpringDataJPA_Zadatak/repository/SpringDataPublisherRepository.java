package com.example.SpringDataJPA_Zadatak.repository;

import com.example.SpringDataJPA_Zadatak.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataPublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByName(String name);
}
