package com.example.thymleaffilmdemo.Bank.repos;

import com.example.thymleaffilmdemo.Bank.models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KontoRepo extends JpaRepository<Konto, Long> {
}
