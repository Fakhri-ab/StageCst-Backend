package com.example.stageversion.dao;

import com.example.stageversion.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit,Integer> {
}
