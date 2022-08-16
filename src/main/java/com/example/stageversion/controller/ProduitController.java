package com.example.stageversion.controller;


import com.example.stageversion.dao.CategorieDao;
import com.example.stageversion.dao.ProduitDao;
import com.example.stageversion.entity.Categorie;
import com.example.stageversion.entity.Produit;
import com.example.stageversion.service.ProduitService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProduitController {

    @Autowired
    ProduitService produitService ;

    @Autowired
    ProduitDao produitDao ;

    @Autowired
    CategorieDao categorieDao ;

    @Autowired
    ServletContext context;

    @GetMapping({"/AllProd"})
    public List<Produit> GetAllProd(){
        return produitService.GetAllproduits();
    }


    @PostMapping("/Addprod")
    @ResponseBody
    public Produit addProduit (@RequestPart("file") MultipartFile file,
                                 @RequestParam("produit") String Produit /*@RequestParam("nomcat") String nomcat*/) throws JsonParseException, JsonMappingException, Exception
    {

        return produitService.addProduit(file,Produit/*nomcat*/);
    }

    @PostMapping("/AddprodCat/{idprod}/{idcat}")
    @ResponseBody
    @Transactional
    public void affecterCatProduit (@PathVariable("idprod") Integer idprod ,@PathVariable("idcat") Integer idcat)
    {
     Categorie cat =  categorieDao.findById(idcat).orElse(null);
     Produit prod = produitDao.findById(idprod).orElse(null);
     prod.setCategorie(cat);
    }

    @PutMapping("/modify-Produit/{id}")
    @ResponseBody
    public Produit modifyClient(@RequestPart("file") MultipartFile file,
                                @RequestParam("produit") String Produit, @PathVariable("id") Integer ProduitId) throws Exception {
        return produitService.UpdateProduit(file,Produit,ProduitId);
    }

    @DeleteMapping("/remove-Produit/{id}")
    @ResponseBody
    public void DeleteClient( @PathVariable("id") Integer ProduitId) {
         produitService.deleteClient(ProduitId);
    }

    @GetMapping("/retrieve-Produit/{id}")
    @ResponseBody
    public Produit modifyClient( @PathVariable("id") Integer ProduitId) {
        return produitService.retrieveproduit(ProduitId);
    }

    @GetMapping(path="/Imgarticles/{id}")
    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
        Produit prod   = produitDao.findById(id).get();


            return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+( prod).getImgProduit()/*+personnel.getCartegrise()+personnel.getPermis()*/));


    }
}


