package com.hawkerapp.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="hawkerstall") //name of the table
public class HawkerStall {

    @Id //specify the id
    private Long Id;

    private String Thumbnail;

    private String Name;

    private Long Rating;

    private String Hawkercentrename;

    private String Unitno;

    private String Operationhours;

    private Long Communityrating;

    private Long Noofrating;

    private Long Originalcommunityrating;

    private String Highlightitems;

    private String Foodcategories;

    private double latitude_hc;

    private double longitude_hc;

    private String photourl;

    private String q1_cleaningstartdate;

    private String q1_cleaningenddate;

    private String q2_cleaningstartdate;

    private String q2_cleaningenddate;

    private String q3_cleaningstartdate;

    private String q3_cleaningenddate;

    private String q4_cleaningstartdate;

    private String q4_cleaningenddate;

    private String Neighbourhood;


    public HawkerStall() {
    }

    public HawkerStall(Long id, String thumbnail, String name, Long rating, String hawkercentrename, String unitno, String operationhours, Long communityrating, Long noofrating, Long originalcommunityrating, String highlightitems, String foodcategories, double latitude_hc, double longitude_hc, String photourl, String q1_cleaningstartdate, String q1_cleaningenddate, String q2_cleaningstartdate, String q2_cleaningenddate, String q3_cleaningstartdate, String q3_cleaningenddate, String q4_cleaningstartdate, String q4_cleaningenddate, String neighbourhood) {
        Id = id;
        Thumbnail = thumbnail;
        Name = name;
        Rating = rating;
        Hawkercentrename = hawkercentrename;
        Unitno = unitno;
        Operationhours = operationhours;
        Communityrating = communityrating;
        Noofrating = noofrating;
        Originalcommunityrating = originalcommunityrating;
        Highlightitems = highlightitems;
        Foodcategories = foodcategories;
        this.latitude_hc = latitude_hc;
        this.longitude_hc = longitude_hc;
        this.photourl = photourl;
        this.q1_cleaningstartdate = q1_cleaningstartdate;
        this.q1_cleaningenddate = q1_cleaningenddate;
        this.q2_cleaningstartdate = q2_cleaningstartdate;
        this.q2_cleaningenddate = q2_cleaningenddate;
        this.q3_cleaningstartdate = q3_cleaningstartdate;
        this.q3_cleaningenddate = q3_cleaningenddate;
        this.q4_cleaningstartdate = q4_cleaningstartdate;
        this.q4_cleaningenddate = q4_cleaningenddate;
        Neighbourhood = neighbourhood;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getRating() {
        return Rating;
    }

    public void setRating(Long rating) {
        Rating = rating;
    }

    public String getHawkercentrename() {
        return Hawkercentrename;
    }

    public void setHawkercentrename(String hawkercentrename) {
        Hawkercentrename = hawkercentrename;
    }

    public String getUnitno() {
        return Unitno;
    }

    public void setUnitno(String unitno) {
        Unitno = unitno;
    }

    public String getOperationhours() {
        return Operationhours;
    }

    public void setOperationhours(String operationhours) {
        Operationhours = operationhours;
    }

    public Long getCommunityrating() {
        return Communityrating;
    }

    public void setCommunityrating(Long communityrating) {
        Communityrating = communityrating;
    }

    public Long getNoofrating() {
        return Noofrating;
    }

    public void setNoofrating(Long noofrating) {
        Noofrating = noofrating;
    }

    public Long getOriginalcommunityrating() {
        return Originalcommunityrating;
    }

    public void setOriginalcommunityrating(Long originalcommunityrating) {
        Originalcommunityrating = originalcommunityrating;
    }

    public String getHighlightitems() {
        return Highlightitems;
    }

    public void setHighlightitems(String highlightitems) {
        Highlightitems = highlightitems;
    }

    public String getFoodcategories() {
        return Foodcategories;
    }

    public void setFoodcategories(String foodcategories) {
        Foodcategories = foodcategories;
    }

    public double getLatitude_hc() {
        return latitude_hc;
    }

    public void setLatitude_hc(double latitude_hc) {
        this.latitude_hc = latitude_hc;
    }

    public double getLongitude_hc() {
        return longitude_hc;
    }

    public void setLongitude_hc(double longitude_hc) {
        this.longitude_hc = longitude_hc;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getQ1_cleaningstartdate() {
        return q1_cleaningstartdate;
    }

    public void setQ1_cleaningstartdate(String q1_cleaningstartdate) {
        this.q1_cleaningstartdate = q1_cleaningstartdate;
    }

    public String getQ1_cleaningenddate() {
        return q1_cleaningenddate;
    }

    public void setQ1_cleaningenddate(String q1_cleaningenddate) {
        this.q1_cleaningenddate = q1_cleaningenddate;
    }

    public String getQ2_cleaningstartdate() {
        return q2_cleaningstartdate;
    }

    public void setQ2_cleaningstartdate(String q2_cleaningstartdate) {
        this.q2_cleaningstartdate = q2_cleaningstartdate;
    }

    public String getQ2_cleaningenddate() {
        return q2_cleaningenddate;
    }

    public void setQ2_cleaningenddate(String q2_cleaningenddate) {
        this.q2_cleaningenddate = q2_cleaningenddate;
    }

    public String getQ3_cleaningstartdate() {
        return q3_cleaningstartdate;
    }

    public void setQ3_cleaningstartdate(String q3_cleaningstartdate) {
        this.q3_cleaningstartdate = q3_cleaningstartdate;
    }

    public String getQ3_cleaningenddate() {
        return q3_cleaningenddate;
    }

    public void setQ3_cleaningenddate(String q3_cleaningenddate) {
        this.q3_cleaningenddate = q3_cleaningenddate;
    }

    public String getQ4_cleaningstartdate() {
        return q4_cleaningstartdate;
    }

    public void setQ4_cleaningstartdate(String q4_cleaningstartdate) {
        this.q4_cleaningstartdate = q4_cleaningstartdate;
    }

    public String getQ4_cleaningenddate() {
        return q4_cleaningenddate;
    }

    public void setQ4_cleaningenddate(String q4_cleaningenddate) {
        this.q4_cleaningenddate = q4_cleaningenddate;
    }

    public String getNeighbourhood() {
        return Neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        Neighbourhood = neighbourhood;
    }
}
