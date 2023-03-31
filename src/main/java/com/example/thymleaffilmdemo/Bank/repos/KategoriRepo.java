package com.example.thymleaffilmdemo.Bank.repos;

import com.example.thymleaffilmdemo.Bank.models.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KategoriRepo extends JpaRepository<Kategori, Long> {
}
