package com.pidev.welend.services;

import com.pidev.welend.entities.Reclaim;

import java.util.List;

public interface ReclaimService {
    public Reclaim addReclaim(Reclaim r);
    public Reclaim updateReclaim(Reclaim r);
    public List<Reclaim> getAllReclaim();
    public List<Reclaim> getAllReclaimForUnlockedUser();
    public Reclaim getReclaimByID(Integer reclaimID);
    public void deleteReclaim(Integer reclaimID);
    public double calculateReclaimCost(Reclaim reclaim);
    public void deleteReclaimIfStatusNotDone(Integer reclaimID) throws Exception ;
}
