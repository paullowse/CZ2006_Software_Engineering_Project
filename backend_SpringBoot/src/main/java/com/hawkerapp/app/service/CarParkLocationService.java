package com.hawkerapp.app.service;

import com.hawkerapp.app.model.CarParkLocation;
import com.hawkerapp.app.model.HawkerStall;
import com.hawkerapp.app.repository.CarParkLocationRepository;
import com.hawkerapp.app.repository.HawkerStallRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarParkLocationService {

    @Autowired
    private CarParkLocationRepository carParkLocationRepository;


    //@Override
    public List<CarParkLocation> findAll(){

        return (List<CarParkLocation>) carParkLocationRepository.findAll();
    }
}
