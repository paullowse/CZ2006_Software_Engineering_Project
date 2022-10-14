package com.hawkerapp.app.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carpark_codes")
public class CarParkLocation {

    @Id
    private int id;

    private String short_term_parking;

    private String car_park_type;

    private double y_coord;

    private double x_coord;

    private String free_parking;

    private long gantry_height;

    private String car_park_basement;

    private String night_parking;

    private String address;

    private int car_park_decks;

    private String car_park_no;

    private String type_of_parking_system;

    private double latitude;

    private double longitude;

    public CarParkLocation() {
    }

    public CarParkLocation(int id, String short_term_parking, String car_park_type, double y_coord, double x_coord, String free_parking, long gantry_height, String car_park_basement, String night_parking, String address, int car_park_decks, String car_park_no, String type_of_parking_system, double latitude, double longitude) {
        this.id = id;
        this.short_term_parking = short_term_parking;
        this.car_park_type = car_park_type;
        this.y_coord = y_coord;
        this.x_coord = x_coord;
        this.free_parking = free_parking;
        this.gantry_height = gantry_height;
        this.car_park_basement = car_park_basement;
        this.night_parking = night_parking;
        this.address = address;
        this.car_park_decks = car_park_decks;
        this.car_park_no = car_park_no;
        this.type_of_parking_system = type_of_parking_system;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_term_parking() {
        return short_term_parking;
    }

    public void setShort_term_parking(String short_term_parking) {
        this.short_term_parking = short_term_parking;
    }

    public String getCar_park_type() {
        return car_park_type;
    }

    public void setCar_park_type(String car_park_type) {
        this.car_park_type = car_park_type;
    }

    public double getY_coord() {
        return y_coord;
    }

    public void setY_coord(double y_coord) {
        this.y_coord = y_coord;
    }

    public double getX_coord() {
        return x_coord;
    }

    public void setX_coord(double x_coord) {
        this.x_coord = x_coord;
    }

    public String getFree_parking() {
        return free_parking;
    }

    public void setFree_parking(String free_parking) {
        this.free_parking = free_parking;
    }

    public long getGantry_height() {
        return gantry_height;
    }

    public void setGantry_height(long gantry_height) {
        this.gantry_height = gantry_height;
    }

    public String getCar_park_basement() {
        return car_park_basement;
    }

    public void setCar_park_basement(String car_park_basement) {
        this.car_park_basement = car_park_basement;
    }

    public String getNight_parking() {
        return night_parking;
    }

    public void setNight_parking(String night_parking) {
        this.night_parking = night_parking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCar_park_decks() {
        return car_park_decks;
    }

    public void setCar_park_decks(int car_park_decks) {
        this.car_park_decks = car_park_decks;
    }

    public String getCar_park_no() {
        return car_park_no;
    }

    public void setCar_park_no(String car_park_no) {
        this.car_park_no = car_park_no;
    }

    public String getType_of_parking_system() {
        return type_of_parking_system;
    }

    public void setType_of_parking_system(String type_of_parking_system) {
        this.type_of_parking_system = type_of_parking_system;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
