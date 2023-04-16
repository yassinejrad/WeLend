package com.pidev.welend.services;


import com.pidev.welend.entities.Reclaim;
import com.pidev.welend.entities.ReclaimStatus;
import com.pidev.welend.entities.reclaimType;
import com.pidev.welend.repos.ReclaimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    @Override
    public void deleteReclaimIfStatusNotDone(Integer reclaimID) throws Exception {
        Reclaim reclaim = getReclaimByID(reclaimID);
        if (reclaim.getReclaimstatus() == ReclaimStatus.DONE) {
            throw new Exception("Cannot delete reclaim with status 'Done'");
        } else {
            deleteReclaim(reclaimID);
        }
    }

	@Override
	public List<Reclaim> getAllReclaimForUnlockedUser() {
		return reclaimRepo.findReclaimByLockedUser();
	}

    public double calculateReclaimCost(Reclaim reclaim) {
        double cost = 0.0;
        if (reclaim.getReclaimType() == reclaimType.Other) {
            cost = 100.0;
        } else if (reclaim.getReclaimType() == reclaimType.AccountProblem) {
            cost = 200.0;
        } else if (reclaim.getReclaimType() == reclaimType.LoanProblem) {
            cost = 50.0;
        }else if (reclaim.getReclaimType() == reclaimType.RemaittanceProblem) {
            cost = 50.0;
        }else if (reclaim.getReclaimType() == reclaimType.TransferProblem) {
            cost = 50.0;
        }
        if (reclaim.getReclaimstatus() == ReclaimStatus.DONE) {
            cost += 50.0;
        }
        return cost;
    }


}
