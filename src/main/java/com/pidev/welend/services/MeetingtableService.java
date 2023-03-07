package com.pidev.welend.services;

import com.pidev.welend.entities.meetingtable;

import java.util.List;

public interface MeetingtableService {
    public meetingtable addmeetingtable(meetingtable m);
    public meetingtable updatemeetingtable(meetingtable m);
    public List<meetingtable> getAllmeetingtable();
    public meetingtable getmeetingtableByID(Integer meetingtableID);
    public void deletemeetingtable(Integer meetingtableID);
}
