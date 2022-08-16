package com.example.stageversion.controller;

import com.example.stageversion.entity.Categorie;
import com.example.stageversion.entity.Produit;
import com.example.stageversion.entity.User;
import com.example.stageversion.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
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


    // @PostAuthorize("hasAnyAuthority('Admin')")
    @PostMapping({"/AddCat"})
    public Categorie AddCategorie(@RequestBody Categorie cat) {
        return categorieService.AddCategorie(cat) ;
    }

    @PutMapping("/modify-Categorie/{id}")
    @ResponseBody
    public Categorie UpdateCategorie(@RequestBody Categorie c, @PathVariable("id") Integer CategorieId) {
        return categorieService.UpdateCategorie(c);
    }

    @DeleteMapping("/delete-Categorie/{id}")
    @ResponseBody
    public void UpdateCategorie(@PathVariable("id") Integer CategorieId) {
         categorieService.DeleteCategorie(CategorieId);
    }

    @GetMapping({"/GetCat/{id}"})
    public Categorie GetCat(@PathVariable("id") Integer CategorieId){
        return categorieService.retrieveCategorie(CategorieId);
    }
}
