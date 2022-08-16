package com.example.stageversion.service;

import com.example.stageversion.dao.CategorieDao;
import com.example.stageversion.dao.ProduitDao;
import com.example.stageversion.entity.Categorie;
import com.example.stageversion.entity.Produit;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.DataInput;
import java.io.File;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProduitDao produitDao ;
    @Autowired
    ServletContext context;
    @Autowired
    CategorieDao categorieDao ;

    public List<Produit> GetAllproduits(){
        return produitDao.findAll();
    }

    public Produit addProduit(MultipartFile file ,String p /*String nomcat*/) throws JsonParseException, JsonMappingException, Exception{
       // Categorie cat = categorieDao.findByNomCategorie(nomcat)  ;
        System.out.println("Ok .............");
        Produit prod = new ObjectMapper().readValue( p, Produit.class);
      //  Categorie cat = new ObjectMapper().readValue( nomcat, Categorie.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
       // prod.setCategorie(cat);
        prod.setImgProduit(newFileName);
        return  produitDao.save(prod) ;
    }

    public Produit UpdateProduit(MultipartFile file , String p ,Integer id) throws JsonParseException, JsonMappingException, Exception
    {
         //Produit prod1 = produitDao.findById(id).orElse(null) ;
        System.out.println("Ok .............");
        Produit prod = new ObjectMapper().readValue( p, Produit.class);
        prod.setIdProduit(id);
        //  Categorie cat = new ObjectMapper().readValue( nomcat, Categorie.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        // prod.setCategorie(cat);
        prod.setImgProduit(newFileName);
        return  produitDao.save(prod) ;
    }

    public void deleteClient(Integer id) { produitDao.deleteById(id);}


    public Produit retrieveproduit(Integer id) {
        Produit produit = produitDao.findById(id).orElse(null);
        return produit ;
    }


}
