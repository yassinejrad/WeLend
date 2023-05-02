package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceType;
import com.pidev.welend.repos.InsuranceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceTypeServiceImp implements InsuranceTypeService {
    @Autowired
    InsuranceTypeRepo insuranceTypeRepo;
    @Override
    public insuranceType addInsuranceType(insuranceType i) {
        return insuranceTypeRepo.save(i);
    }

    @Override
    public insuranceType updateInsuranceType(insuranceType i) {
        return insuranceTypeRepo.save(i);
    }

    @Override
    public List<insuranceType> getAllInsuranceType() {
        return insuranceTypeRepo.findAll();
    }

    @Override
    public insuranceType getInsuranceTypeById(Integer insuranceTypeID) {
        return insuranceTypeRepo.findById(insuranceTypeID).orElse(null);
    }

    @Override
    public void deleteInsuranceType(Integer insuranceTypeId) {
        insuranceTypeRepo.deleteById(insuranceTypeId);
    }
}
