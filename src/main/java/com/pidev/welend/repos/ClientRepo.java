package com.pidev.welend.repos;

import com.pidev.welend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
