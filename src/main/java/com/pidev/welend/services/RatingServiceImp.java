package com.pidev.welend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.welend.entities.Rating;
import com.pidev.welend.repos.RatingRepo;
@Service
public class RatingServiceImp implements RatingService{

	@Autowired
    RatingRepo ratingRepo;
	
	@Override
	public Rating addRating(Rating a) {
		
		return ratingRepo.save(a);
	}

	@Override
	public Rating updateRating(Rating a) {
		
		return ratingRepo.save(a);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepo.findAll();
	}

	@Override
	public Rating getRatingById(Integer id) {
		
		return ratingRepo.getById(id);
	}

	@Override
	public void deleteRating(Integer id) {
		ratingRepo.deleteById(id);
		
	}

	@Override
	public Integer nbrRatingGood() {
		
		return ratingRepo.nbrRateGood();
	}

}
