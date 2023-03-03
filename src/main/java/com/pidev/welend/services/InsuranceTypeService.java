package com.pidev.welend.services;


import com.pidev.welend.entities.insuranceType;

import java.util.List;

public interface InsuranceTypeService {
    public insuranceType addInsuranceType(insuranceType i);
    public insuranceType updateInsuranceType(insuranceType i);
    public List<insuranceType> getAllInsuranceType();
    public insuranceType getInsuranceTypeById(Integer insuranceTypeID);
    public void deleteInsuranceType(Integer insuranceTypeId);

}
