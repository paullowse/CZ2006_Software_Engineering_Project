package com.hawkerapp.app.model;

public class CarParkData {
    int totalLots;
    char lotType;
    int lotsAvailable;

    public CarParkData() {
    }

    public CarParkData(int lotsAvailable, int totalLots, char lotType) {
        this.totalLots = totalLots;
        this.lotType = lotType;
        this.lotsAvailable = lotsAvailable;
    }

    public int getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }

    public char getLotType() {
        return lotType;
    }

    public void setLotType(char lotType) {
        this.lotType = lotType;
    }

    public int getLotsAvailable() {
        return lotsAvailable;
    }

    public void setLotsAvailable(int lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }

    @Override
    public String toString() {
        return totalLots + ";"
                + lotType + ";"
                + lotsAvailable;
    }
}
