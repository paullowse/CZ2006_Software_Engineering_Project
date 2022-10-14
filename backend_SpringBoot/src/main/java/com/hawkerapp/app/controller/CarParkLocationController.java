package com.hawkerapp.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hawkerapp.app.model.CarParkData;
import com.hawkerapp.app.model.CarParkLocation;
import com.hawkerapp.app.repository.CarParkLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.hawkerapp.app.model.CarParkAvail.getCarParkInfo;

@RestController
public class CarParkLocationController {
    @Autowired
    private CarParkLocationRepository carParkLocationRepository;

    @GetMapping("/carparkcodes")
    public List<CarParkLocation> findCarParkCodes(){
        return (List<CarParkLocation>) carParkLocationRepository.findAll();
    }

    @GetMapping("/nearest/{latitude}/{longitude}")
    public List<String> findNearestCarPark(@PathVariable double latitude,@PathVariable double longitude ){
        return carParkLocationRepository.carpark_distance(latitude, longitude);
    }

    @GetMapping("/getcarparkinfo/{latitude}/{longitude}")
    public String getCarParkinfo(@PathVariable double latitude, @PathVariable double longitude ) throws JsonProcessingException {
        List<String> carparkinfo = findNearestCarPark(latitude,longitude);
        Map<String, CarParkData> carparkList = getCarParkInfo(carparkinfo);

        ObjectMapper objectMapper = new ObjectMapper();


        String json = objectMapper.writeValueAsString(carparkList);

        return json;

    }

    @GetMapping("/getnearestcarpark/{latitude}/{longitude}")
    public String getCarParknear(@PathVariable double latitude, @PathVariable double longitude ){
        List<String> carparkinfo = findNearestCarPark(latitude,longitude);
        Map<String, CarParkData> carparkList = getCarParkInfo(carparkinfo);

        Map.Entry<String, CarParkData> entry = carparkList.entrySet().iterator().next();

        return entry.getKey() + ";" + entry.getValue().toString();
    }

    @GetMapping("/carpark/{car_park_no}")
    public List<CarParkLocation> carparkinfo(@PathVariable String car_park_no){
        return carParkLocationRepository.carparkinfo(car_park_no);
    }
}
