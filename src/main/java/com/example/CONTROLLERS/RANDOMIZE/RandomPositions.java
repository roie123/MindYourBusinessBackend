package com.example.CONTROLLERS.RANDOMIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPositions {
    private static List<String> companyPositions=new ArrayList<>();
    public  void fillPositions(){
        companyPositions.add("Clinical Laboratory Technician");
        companyPositions.add("Electrical Engineer");
        companyPositions.add("Lawyer");
        companyPositions.add("High School Teacher");
        companyPositions.add("Writer");
        companyPositions.add("Occupational Therapist");
        companyPositions.add("Mechanical Engineer");
        companyPositions.add("Customer Service Representative");
        companyPositions.add("Construction Manager");
        companyPositions.add("Epidemiologist");

    }
    public String getRandomPosition(){
        Random random =new Random();
        return companyPositions.get(random.nextInt(0,companyPositions.size()));
    }



}
