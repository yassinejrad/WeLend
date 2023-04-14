package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Reclaim;
import com.pidev.welend.services.ReclaimService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reclaim")
@CrossOrigin(origins = "http://localhost:4200")
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
    @DeleteMapping("/delete/{id}")
    public void deleteReclaim(@PathVariable("id") Integer reclaimID)
    {
        reclaimService.deleteReclaim(reclaimID);
    }
    @GetMapping("/getAll")
    public List<Reclaim> getAllReclaim()
    {
        return reclaimService.getAllReclaim();
    }
    @GetMapping("/getById/{id}")
    public Reclaim getByReclaim(@PathVariable("id") Integer reclaimID)
    {
        return reclaimService.getReclaimByID(reclaimID);
    }

}
