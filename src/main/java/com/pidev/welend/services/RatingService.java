package com.pidev.welend.services;

import java.util.List;

import com.pidev.welend.entities.Rating;

public interface RatingService {
		public Rating addRating(Rating a );
	    public Rating updateRating(Rating a);
	    public List<Rating> getAllRating();
	    public Rating getRatingById(Integer id);
	    public void deleteRating(Integer id);
	    public Integer nbrRatingGood();
}
