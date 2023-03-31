package com.example.thymleaffilmdemo.Bank.controllers;

import com.example.thymleaffilmdemo.Bank.models.Konto;
import com.example.thymleaffilmdemo.Bank.repos.KontoRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KontoController {

    private final KontoRepo kontoRepo;

    KontoController(KontoRepo kontoRepo){
        this.kontoRepo=kontoRepo;
    }

    @RequestMapping("konton")
    public List<Konto> getAllKonton(){
        return kontoRepo.findAll();
    }

    @RequestMapping("konton/delete/{id}")
    public String deleteKonto(@PathVariable Long id){
        kontoRepo.deleteById(id);
        return "konto togs bort";
    }

}
