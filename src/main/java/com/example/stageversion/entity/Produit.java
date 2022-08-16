package com.example.stageversion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idProduit;
    private String nomProduit ;
    private  float prixProduit;
    private  int qteProduit;
    private String imgProduit ;

    private  String description ;
    @ManyToOne
    Categorie categorie;

    public String getImgProduit() {
        return imgProduit;
    }

    public void setImgProduit(String imgProduit) {
        this.imgProduit = imgProduit;
    }

    public Produit(int idProduit, String nomProduit, float prixProduit, int qteProduit,String description , String imgProduit, Categorie categorie) {
        idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.qteProduit = qteProduit;
        this.imgProduit = imgProduit;
        this.description = description ;
        this.categorie = categorie;

    }
}
