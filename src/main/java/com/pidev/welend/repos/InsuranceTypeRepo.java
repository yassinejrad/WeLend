package com.pidev.welend.repos;

import com.pidev.welend.entities.insuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepo extends JpaRepository<insuranceType,Integer> {
}
