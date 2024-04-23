package com.example.thymleaffilmdemo.Bank.controllers;

import com.example.thymleaffilmdemo.Bank.models.Kategori;
import com.example.thymleaffilmdemo.Bank.repos.KategoriRepo;
import com.example.thymleaffilmdemo.Bank.repos.KundRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/kategori")
public class KategoriController {


    private final KategoriRepo kategoriRepo;
    private final KundRepo kundRepo;

    KategoriController(KategoriRepo kategoriRepo, KundRepo kundRepo){
        this.kategoriRepo=kategoriRepo;
        this.kundRepo=kundRepo;
    }


    @RequestMapping("/all")
    public String getAll(Model model) {
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "showAllCategories";
    }

    @RequestMapping("/all2")
    public String getAll2(Model model) {
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "completeCategory";
    }



    //servar ett formulär för att skapa en ny kategori
    @RequestMapping("/addByForm")
    public String createByForm(Model model) {
        return "createCategory";
    }

    //Tar emot från ett formulär
    @PostMapping("/create")
    public String create(@RequestParam String name, Model model) {
        kategoriRepo.save(new Kategori(name));
        //return getAll2(model);
        return "redirect:/kategori/all2";
    }

    @RequestMapping("/allWithDelete")
    public String getAllWithDelete(Model model) {
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "deleteCategory";
    }

    @RequestMapping(path = "/deleteById/{id}")
    public String deleteCap(@PathVariable Long id, Model model) {
        kategoriRepo.deleteById(id);
        return getAllWithDelete(model);
    }


    @RequestMapping("/editByView/{id}")
    public String createByForm(@PathVariable Long id, Model model) {
        System.out.println("hej");
        Kategori k= kategoriRepo.findById(id).get();
        model.addAttribute("kategori", k);
        return "updateCategoryForm";
    }

    @PostMapping("/update")
    public String addCustomer(Model model, Kategori c) {
        kategoriRepo.save(c);
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "completeCategory";
    }


}
