package com.pidev.welend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.welend.entities.Rating;
import com.pidev.welend.entities.Reclaim;
import com.pidev.welend.repos.RatingRepo;
import com.pidev.welend.services.RatingService;
import com.pidev.welend.services.ReclaimService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {
	@Autowired
    RatingService ratingService;
    @PostMapping("/add")
    public Rating addRating(@RequestBody Rating r)
    {
        return ratingService.addRating(r);
    }
    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable("id") Integer id,@RequestBody Rating r)
    {	r.setId(id);
        return ratingService.updateRating(r);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable("id") Integer id)
    {
    	ratingService.deleteRating(id);
    }
    @GetMapping("/getAll")
    public List<Rating> getAllReclaim()
    {
        return ratingService.getAllRating();
    }
    @GetMapping("/getRatingGood")
    public Integer getAllRatingReclaim()
    {

return ratingService.nbrRatingGood();
    }
    @GetMapping("/getById/{id}")
    public Rating getByRating(@PathVariable("id") Integer id)
    {
        return ratingService.getRatingById(id);
    }
}
