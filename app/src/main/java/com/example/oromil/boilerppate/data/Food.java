package com.example.oromil.boilerppate.data;

public class Food {

    private String name;
    private String carbohydrates;
    private Integer id;

    private Float m;

    public Food(String name, String carbohydrates) {
        this.name = name;
        this.carbohydrates = carbohydrates;
    }

    public String getName() {
        return name;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public Float getM() {
        return m;
    }

    public void setM(Float m) {
        this.m = m;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
