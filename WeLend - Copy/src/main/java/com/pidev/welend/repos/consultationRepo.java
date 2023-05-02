package com.pidev.welend.repos;

import com.pidev.welend.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultationRepo extends JpaRepository<Consultation,Integer> {
}
