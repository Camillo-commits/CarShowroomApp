package com.mycompany.mavenproject1.fromlab2;

import java.util.ArrayList;

public class CarShowroomDescriptor {
    String name;
    int maxNumOfCars;
    int numOfCars;

    public CarShowroomDescriptor(String name, int maxNumOfCars, int numOfCars) {
        this.name = name;
        this.maxNumOfCars = maxNumOfCars;
        this.numOfCars = numOfCars;
    }

    public CarShowroomDescriptor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumOfCars() {
        return maxNumOfCars;
    }

    public void setMaxNumOfCars(int maxNumOfCars) {
        this.maxNumOfCars = maxNumOfCars;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

    public void setNumOfCars(int numOfCars) {
        this.numOfCars = numOfCars;
    }
}
