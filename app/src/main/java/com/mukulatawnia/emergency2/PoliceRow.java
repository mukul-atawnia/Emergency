package com.mukulatawnia.emergency2;


public class PoliceRow {

    private String police_stations_places;
    private String numbers;

    public String getPolice_stations_places() {
        return police_stations_places;
    }

    public PoliceRow(String police_stations_places,String numbers)
    {
        this.police_stations_places=police_stations_places;
        this.numbers=numbers;
    }

    public void setPolice_stations_places(String police_stations_places) {
        this.police_stations_places = police_stations_places;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }


}
