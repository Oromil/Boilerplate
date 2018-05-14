package com.example.oromil.boilerppate;

public class EatingTableEntity {

    private String date;
    private String time;
    private String mass;
    private String index;
    public EatingTableEntity(String date, String time, String mass, String index){
        this.date = date;
        this.time = time;
        this.mass = mass;
        this.index = index;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getIndex() {
        return index;
    }

    public String getMass() {
        return mass;
    }
}
