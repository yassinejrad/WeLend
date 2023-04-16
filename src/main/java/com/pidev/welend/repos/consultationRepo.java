package com.pidev.welend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.welend.entities.Consultation;

public interface consultationRepo extends JpaRepository<Consultation,Integer> {
}
