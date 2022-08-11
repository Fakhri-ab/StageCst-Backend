package com.example.stageversion.service;

import com.example.stageversion.dao.CategorieDao;
import com.example.stageversion.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieDao categorieDao ;

    public List<Categorie> GetAllCategories(){
        return categorieDao.findAll();
    }

    public Categorie AddCategorie(Categorie c){
        return categorieDao.save(c);
    }

    public void DeleteCategorie(int id){
         categorieDao.deleteById(id);
    }

}
