package com.pidev.welend.repos;
import com.pidev.welend.entities.meetingtable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingtableRepo extends JpaRepository<meetingtable,Integer> {
        }
