package com.example.stageversion.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int IdCategorie ;
    private String nomCategorie ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
    private Set<Produit> Produits;

}
