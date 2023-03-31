package com.example.thymleaffilmdemo.Bank.repos;

import com.example.thymleaffilmdemo.Bank.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;



public interface KpiRepo extends JpaRepository<Kpi, Long> {
}
