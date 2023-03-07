package com.pidev.welend.services;

import com.pidev.welend.entities.meetingtable;
import com.pidev.welend.repos.MeetingtableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingtableServiceImp implements MeetingtableService{
    @Autowired
    MeetingtableRepo meetingtableRepo;


    public meetingtable addmeetingtable(meetingtable m) {
        return meetingtableRepo.save(m);
    }

    public meetingtable updatemeetingtable(meetingtable m)
    {
        return meetingtableRepo.save(m);
    }

    @Override
    public List<meetingtable> getAllmeetingtable() {
        return meetingtableRepo.findAll();
    }

    @Override
    public meetingtable getmeetingtableByID(Integer meetingtableID) {
        return meetingtableRepo.findById(meetingtableID).orElse(null);
    }

    @Override
    public void deletemeetingtable(Integer meetingtableID) {
        meetingtableRepo.deleteById(meetingtableID);

    }


}

