package com.pidev.welend.repos;

import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<insurance,Integer> {
}
