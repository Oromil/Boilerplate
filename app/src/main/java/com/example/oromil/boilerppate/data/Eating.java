package com.example.oromil.boilerppate.data;

import java.util.ArrayList;
import java.util.List;

public class Eating {

    private String date;
    private String time;
    private List<Integer> foodId;

    public Eating(String date, String time, List<Integer>foodId){
        this.date = date;
        this.time = time;
        this.foodId = foodId;
    }

    public List<Integer> getFoodId() {
        return foodId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
