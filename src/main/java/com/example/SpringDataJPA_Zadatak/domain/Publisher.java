package com.example.SpringDataJPA_Zadatak.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @OneToMany
    @JoinColumn(name = "book_id")
    private Set<Publisher> publishers = new HashSet<Publisher>();
}
