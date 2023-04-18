package com.pidev.welend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.welend.entities.Client;
import com.pidev.welend.entities.Consultation;


@Repository
public interface consultationRepo extends JpaRepository<Consultation,Integer> {
    List<Consultation> findByClient(Client c);
}
