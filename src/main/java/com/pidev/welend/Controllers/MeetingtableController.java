package com.pidev.welend.Controllers;

import com.pidev.welend.entities.meetingtable;

import com.pidev.welend.services.MeetingtableService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/meetingtable")
public class MeetingtableController {
    @Autowired
    MeetingtableService meetingtableService;
    @PostMapping("/add")
    public meetingtable addmeetingtable(@RequestBody meetingtable m){
        return meetingtableService.addmeetingtable(m);
    }
    @PostMapping("/update")
    public meetingtable updatemeetingtable(@RequestBody meetingtable m ){
        return meetingtableService.updatemeetingtable(m);
    }
    @DeleteMapping("/delete/{id}")
    public void deletemeetingtable(@PathVariable("id") Integer meetingtableID){
        meetingtableService.deletemeetingtable(meetingtableID);
    }
    @GetMapping("/getAll")
    public List<meetingtable> getAllmeetingtable(){
        return meetingtableService.getAllmeetingtable();
    }
    @GetMapping("/getByID/{id}")
    public meetingtable getmeetingtableByID(@PathVariable("id") Integer meetingtableID){
        return meetingtableService.getmeetingtableByID(meetingtableID);
    }


}
