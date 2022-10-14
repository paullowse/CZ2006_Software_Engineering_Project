package com.hawkerapp.app.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.hawkerapp.app.model.HawkerStall;
import com.hawkerapp.app.repository.HawkerStallRepository;
import org.apache.tomcat.util.json.JSONParser;
//import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
public class HawkerStallController {

    @Autowired
    private HawkerStallRepository repository;


    @GetMapping("/hawkerstalls")
    public List<HawkerStall> findHawkerStalls(){
        return (List<HawkerStall>) repository.findAll();
    }

    @GetMapping(value="/search/{keyword}")
    public List<HawkerStall> stall_search(@PathVariable String keyword){
        return repository.stall_search(keyword);
    }

    @GetMapping(value = "/rating/{rating}")
    public List<HawkerStall> stallGRating (@PathVariable Long rating) {
        return repository.stall_ratinggreater(rating);
    }

    @GetMapping(value="/distance/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_distance(@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance){
        return repository.stall_distance(latitude, longitude, distance);
    }

    @GetMapping(value="/neighbourhood/{neighbourhood}")
    public List<HawkerStall> stall_neigh(@PathVariable String neighbourhood){
        return repository.stall_neigh(neighbourhood);
    }

    @GetMapping(value = "/ratingdistneigh/{neighbourhood}/{rating}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_ratingdistneigh(@PathVariable String neighbourhood,@PathVariable long rating,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance){
        return repository.stall_ratingdistneigh(neighbourhood, rating, latitude, longitude, distance);
    }

    @GetMapping(value = "/ratinganddist/{rating}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_all(@PathVariable long rating,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance){
        return repository.stall_ratinganddist(rating, latitude, longitude, distance);
    }

    @GetMapping(value = "/ratingandneigh/{neighbourhood}/{rating}")
    public List<HawkerStall> stall_all(@PathVariable String neighbourhood,@PathVariable long rating){
        return repository.stall_ratingandneigh(neighbourhood, rating);
    }

    @GetMapping(value = "/distandneigh/{neighbourhood}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_all(@PathVariable String neighbourhood,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance){
        return repository.stall_distandneigh(neighbourhood,latitude, longitude, distance);
    }

    @GetMapping(value = "/allfilters/{keyword}/{neighbourhood}/{rating}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_allfilters(@PathVariable String keyword, @PathVariable String neighbourhood , @PathVariable long rating,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance) {
        return repository.stall_allfilters(keyword,neighbourhood,rating, latitude, longitude, distance);
    }

    @GetMapping(value = "/distandcuis/{keyword}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_distcuis(@PathVariable String keyword ,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance) {
        return repository.stall_distcuis(keyword,latitude, longitude, distance);
    }

    @GetMapping(value = "/ratingandcuis/{keyword}/{rating}")
    public List<HawkerStall> stall_ratingcuis(@PathVariable String keyword,@PathVariable long rating) {
        return repository.stall_ratingcuis(keyword,rating);
    }

    @GetMapping(value = "/neighcuis/{keyword}/{neighbourhood}")
    public List<HawkerStall> stall_neighcuis(@PathVariable String keyword, @PathVariable String neighbourhood) {
        return repository.stall_neighcuis(keyword,neighbourhood);
    }

    @GetMapping(value = "/ratingneighcuis/{keyword}/{neighbourhood}/{rating}")
    public List<HawkerStall> stall_ratingneighcuis(@PathVariable String keyword, @PathVariable String neighbourhood, @PathVariable long rating) {
        return repository.stall_ratingneighcuis(keyword,neighbourhood,rating);
    }

    @GetMapping(value = "/ratingdistcuis/{keyword}/{rating}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_ratingdistcuis(@PathVariable String keyword,  @PathVariable long rating,@PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance) {
        return repository.stall_ratingdistcuis(keyword,rating, latitude, longitude, distance);
    }

    @GetMapping(value = "/distneighcuis/{keyword}/{neighbourhood}/{latitude}/{longitude}/{distance}")
    public List<HawkerStall> stall_distneighcuis(@PathVariable String keyword, @PathVariable String neighbourhood , @PathVariable double latitude, @PathVariable double longitude,@PathVariable double distance) {
        return repository.stall_distneighcuis(keyword,neighbourhood,latitude, longitude, distance);
    }

    @GetMapping(value="/ratingname/{rating}/{name}")
    public List<HawkerStall> stall_rating_name(@PathVariable long rating, @PathVariable String name){return repository.stall_ratingandname(rating,name);}

    @GetMapping(value="/history/{name1}/{name2}/{name3}/{name4}/{name5}/{name6}/{name7}/{name8}/{name9}/{name10}")
    public List<HawkerStall> stall_history(@PathVariable String name1,@PathVariable String name2,@PathVariable String name3,@PathVariable String name4,@PathVariable String name5,@PathVariable String name6,@PathVariable String name7,@PathVariable String name8,@PathVariable String name9,@PathVariable String name10){
        return repository.stall_history(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10);
    }
}
