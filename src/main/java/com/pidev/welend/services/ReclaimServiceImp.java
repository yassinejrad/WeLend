package com.pidev.welend.services;

import com.pidev.welend.entities.Agent;
import com.pidev.welend.entities.Reclaim;
import com.pidev.welend.repos.ReclaimRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReclaimServiceImp implements ReclaimService{
    @Autowired
    ReclaimRepo reclaimRepo;


    public Reclaim addReclaim(Reclaim r) {
        return reclaimRepo.save(r);
    }

    public Reclaim updateReclaim(Reclaim r)
    {
        return reclaimRepo.save(r);
    }

    @Override
    public List<Reclaim> getAllReclaim() {
        return reclaimRepo.findAll();
    }

    @Override
    public Reclaim getReclaimByID(Integer reclaimID) {
        return reclaimRepo.findById(reclaimID).orElse(null);
    }

    @Override
    public void deleteReclaim(Integer reclaimID) {
        reclaimRepo.deleteById(reclaimID);

    }


}
