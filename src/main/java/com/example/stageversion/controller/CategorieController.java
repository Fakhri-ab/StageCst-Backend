package com.example.stageversion.controller;

import com.example.stageversion.entity.Categorie;
import com.example.stageversion.entity.User;
import com.example.stageversion.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategorieController {

    @Autowired
    CategorieService categorieService ;

    @GetMapping({"/AllCat"})
    public List<Categorie> GetAllCat(){
       return categorieService.GetAllCategories();
    }

    @PostMapping({"/AddCat"})
    public Categorie AddCategorie(@RequestBody Categorie cat) {
        return categorieService.AddCategorie(cat) ;
    }
}
