package com.hawkerapp.app.repository;


import com.hawkerapp.app.model.HawkerStall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface HawkerStallRepository extends CrudRepository<HawkerStall,Long> {


    @Query(value="Select * from db_example.hawkerstall u where u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%", nativeQuery = true)
    public List<HawkerStall> stall_search(String keyword);

    //rating only
    @Query(value = "SELECT * FROM db_example.hawkerstall u WHERE u.rating>=:rating", nativeQuery = true)
    public List<HawkerStall> stall_ratinggreater(@Param("rating") long rating);

    //distance only
    @Query(value="Select * from db_example.hawkerstall u where (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?1) ) * cos( radians(?2) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?1) ) ) ) < ?3", nativeQuery = true)
    public List<HawkerStall> stall_distance(double latitude, double longitude, double distance);  //this distance input is in km

    //neighbourhood only
    @Query(value="Select * from db_example.hawkerstall u where u.neighbourhood = ?1", nativeQuery = true)
    public List<HawkerStall> stall_neigh(String neighbourhood);

    //rating, distance and neighbourhood
    @Query(value="Select * from db_example.hawkerstall u where u.neighbourhood = ?1 and u.rating>=?2 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?3) ) * cos( radians(?4) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?3) ) ) ) < ?5", nativeQuery = true)
    public List<HawkerStall> stall_ratingdistneigh(String neighbourhood, long rating,double latitude, double longitude, double distance );

    //rating, distance
    @Query(value="Select * from db_example.hawkerstall u where u.rating>=?1 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?2) ) * cos( radians(?3) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?2) ) ) ) < ?4", nativeQuery = true)
    public List<HawkerStall> stall_ratinganddist(long rating,double latitude, double longitude, double distance );

    //rating, neighbourhood
    @Query(value="Select * from db_example.hawkerstall u where u.neighbourhood = ?1 and u.rating>=?2", nativeQuery = true)
    public List<HawkerStall> stall_ratingandneigh(String neighbourhood, long rating);

    //distance, neighbourhood
    @Query(value="Select * from db_example.hawkerstall u where u.neighbourhood = ?1 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?2) ) * cos( radians(?3) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?2) ) ) ) < ?4", nativeQuery = true)
    public List<HawkerStall> stall_distandneigh(String neighbourhood,double latitude, double longitude, double distance );


    @Query(value="Select * from db_example.hawkerstall u where u.rating >= ?1 and u.name=?2", nativeQuery = true)
    public List<HawkerStall> stall_ratingandname(Long rating, String name);

    //distance, rating, neighbourhood, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.neighbourhood = ?2 and u.rating>=?3 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?4) ) * cos( radians(?5) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?4) ) ) ) < ?6", nativeQuery = true)
    public List<HawkerStall> stall_allfilters(String keyword,String neighbourhood, long rating, double latitude, double longitude, double distance);

    //distance, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?2) ) * cos( radians(?3) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?2) ) ) ) < ?4", nativeQuery = true)
    public List<HawkerStall> stall_distcuis(String keyword, double latitude, double longitude, double distance);

    //rating, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.rating>=?2 ", nativeQuery = true)
    public List<HawkerStall> stall_ratingcuis(String keyword, long rating);

    //neighbourhood, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.neighbourhood = ?2", nativeQuery = true)
    public List<HawkerStall> stall_neighcuis(String keyword,String neighbourhood);

    //rating, distance, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.rating>=?2 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?3) ) * cos( radians(?4) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?3) ) ) ) < ?5", nativeQuery = true)
    public List<HawkerStall> stall_ratingdistcuis(String keyword, long rating, double latitude, double longitude, double distance);

    //rating, neighbourhood, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.neighbourhood = ?2 and u.rating>=?3", nativeQuery = true)
    public List<HawkerStall> stall_ratingneighcuis(String keyword,String neighbourhood, long rating);

    //distance, neighbourhood, cuisine
    @Query(value="Select * from db_example.hawkerstall u where (u.foodcategories LIKE %?1% or u.name LIKE %?1% or u.hawkercentrename LIKE %?1%) and u.neighbourhood = ?2 and (6371 * acos(cos( radians(u.latitude_hc) ) * cos( radians(?3) ) * cos( radians(?4) - radians(u.longitude_hc) ) + sin( radians(u.latitude_hc) ) * sin( radians(?3) ) ) ) < ?5", nativeQuery = true)
    public List<HawkerStall> stall_distneighcuis(String keyword,String neighbourhood, double latitude, double longitude, double distance);

    // get stuff - old
    //@Query(value="Select * from db_example.hawkerstall u where u.name in (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    //public List<HawkerStall> stall_history(String name1,String name2,String name3,String name4,String name5,String name6,String name7,String name8,String name9,String name10);

    @Query(value="Select * from db_example.hawkerstall u where u.name in (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10) order by field(u.name,?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public List<HawkerStall> stall_history(String name1,String name2,String name3,String name4,String name5,String name6,String name7,String name8,String name9,String name10);
}



