package com.pidev.welend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pidev.welend.entities.Rating;


public interface RatingRepo extends JpaRepository<Rating,Integer> {
	@Query (value= "Select Count(id) FROM rating r INNER JOIN client c ON r.client_clientid = c.clientid INNER JOIN reclaim l ON c.clientid = l.client_clientid where r.rate > 3", nativeQuery =true)
	Integer nbrRateGood();
}
