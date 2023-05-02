package com.pidev.welend.services;

import com.pidev.welend.entities.Reclaim;

import java.util.List;

public interface ReclaimService {
    public Reclaim addReclaim(Reclaim r);
    public Reclaim updateReclaim(Reclaim r);
    public List<Reclaim> getAllReclaim();
    public Reclaim getReclaimByID(Integer reclaimID);
    public void deleteReclaim(Integer reclaimID);
}
