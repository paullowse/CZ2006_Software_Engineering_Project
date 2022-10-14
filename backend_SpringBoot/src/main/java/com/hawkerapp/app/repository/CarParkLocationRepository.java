package com.hawkerapp.app.repository;

import com.hawkerapp.app.model.CarParkLocation;
import com.hawkerapp.app.model.HawkerStall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarParkLocationRepository extends CrudRepository<CarParkLocation, Integer> {

    @Query(value="Select car_park_no from db_example.carpark_codes u where (6371 * acos(cos( radians(u.latitude) ) * cos( radians(?1) ) * cos( radians(?2) - radians(u.longitude) ) + sin( radians(u.latitude) ) * sin( radians(?1) ) ) ) < 1 order by (6371 * acos(cos( radians(u.latitude) ) * cos( radians(1.301063272) ) * cos( radians(103.854118) - radians(u.longitude) ) + sin( radians(u.latitude) ) * sin( radians(1.301063272) ) ) )", nativeQuery = true)
    public List<String> carpark_distance(double latitude, double longitude);

    @Query(value="Select * from db_example.carpark_codes u where u.car_park_no=?1", nativeQuery = true)
    public List<CarParkLocation> carparkinfo(String car_park_no);
}
