package com.hawkerapp.app.service;


import com.hawkerapp.app.model.HawkerStall;
import com.hawkerapp.app.repository.HawkerStallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HawkerStallService{

    @Autowired
    private HawkerStallRepository repository;


    //@Override
    public List<HawkerStall> findAll(){

        return (List<HawkerStall>) repository.findAll();
    }


}
