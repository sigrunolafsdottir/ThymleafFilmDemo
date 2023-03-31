package com.example.thymleaffilmdemo.Bank.repos;

import com.example.thymleaffilmdemo.Bank.models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundRepo extends JpaRepository<Kund, Long> {
}
