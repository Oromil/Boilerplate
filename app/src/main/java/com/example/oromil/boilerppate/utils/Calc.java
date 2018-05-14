package com.example.oromil.boilerppate.utils;

import com.example.oromil.boilerppate.data.Food;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private static final float k = 0;
    private static final float Gnorm = 0;
    private static final float m = 0;

    public static float calc1(List<Food>food, Float Mt, Float G0, ArrayList<Float>Nj){

        Float sum1 = 0f;
        Float sum2 = 0f;

        Float kMt = k*Mt;
        for (Food f:food) {
            sum1 = sum1+((f.getM()*(Float.valueOf(f.getCarbohydrates())*f.getM()/100))/kMt);
        }
        for (Float n:Nj) {
            sum2 = sum2+(m*n/kMt);
        }

        return (kMt/m)*((G0+sum1-sum2)-Gnorm);
    }

    public static float calc2(){
        return 0;
    }
}
