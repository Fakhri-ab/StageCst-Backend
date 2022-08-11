package com.example.stageversion.dao;

import com.example.stageversion.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie,Integer> {
    public Categorie  findByNomCategorie(String nom);
}
