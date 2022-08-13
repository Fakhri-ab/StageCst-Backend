package com.example.stageversion.controller;

import com.example.stageversion.entity.Categorie;
import com.example.stageversion.entity.Produit;
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

    @PutMapping("/modify-Categorie/{Categorie-id}")
    @ResponseBody
    public Categorie UpdateCategorie(@RequestBody Categorie c, @PathVariable("Categorie-id") Integer CategorieId) {
        return categorieService.UpdateCategorie(c);
    }

    @DeleteMapping("/delete-Categorie/{Categorie-id}")
    @ResponseBody
    public void UpdateCategorie(@PathVariable("Categorie-id") Integer CategorieId) {
         categorieService.DeleteCategorie(CategorieId);
    }

    @GetMapping({"/GetCat/{Categorie-id}"})
    public Categorie GetCat(@PathVariable("Categorie-id") Integer CategorieId){
        return categorieService.retrieveCategorie(CategorieId);
    }
}
