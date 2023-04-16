package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Reclaim;
import com.pidev.welend.repos.ReclaimRepo;
import com.pidev.welend.services.ReclaimService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reclaim")
public class ReclaimController {
    @Autowired
    ReclaimService reclaimService;

    @PostMapping("/add")
    public Reclaim addReclaim(@RequestBody Reclaim r)
    {
        return reclaimService.addReclaim(r);
    }
    @PutMapping("/update")
    public Reclaim updateReclaim(@RequestBody Reclaim r)
    {
        return reclaimService.updateReclaim(r);
    }
    @PutMapping("/respond")
    public Reclaim respReclaim(@RequestBody Reclaim r)
    {
        return reclaimService.updateReclaim(r);
    }

   /* @DeleteMapping("/delete/{id}")
    public void deleteReclaim(@PathVariable("id") Integer reclaimID)
    {
        reclaimService.deleteReclaim(reclaimID);
    }*/
    @DeleteMapping("/deleteWhileNotDone/{id}")
    public ResponseEntity<String> deleteReclaim(@PathVariable("id") Integer id) {
        try {
            reclaimService.deleteReclaimIfStatusNotDone(id);
            return ResponseEntity.ok("Reclaim deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public List<Reclaim> getAllReclaim()
    {
        return reclaimService.getAllReclaim();
    }
    @GetMapping("/getAllUnlocked")
    public List<Reclaim> getAllUnlockedUserReclaim()
    {
    	System.out.println(reclaimService.getAllReclaimForUnlockedUser());
        return reclaimService.getAllReclaimForUnlockedUser();
    }
    @GetMapping("/getById/{id}")
    public Reclaim getByReclaim(@PathVariable("id") Integer reclaimID)
    {
        return reclaimService.getReclaimByID(reclaimID);
    }
    @GetMapping("/cost/{id}")
    public double getReclaimCost(@PathVariable("id") Integer id) {
        Reclaim reclaim = reclaimService.getReclaimByID(id);
        return reclaimService.calculateReclaimCost(reclaim);
    }

}
