package com.example.stageversion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idCategorie ;
    private String nomCategorie ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
    @JsonIgnore
    private Set<Produit> Produits;

}
