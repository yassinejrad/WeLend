package com.pidev.welend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.welend.entities.Client;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
