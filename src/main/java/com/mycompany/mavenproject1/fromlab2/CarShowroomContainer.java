package com.mycompany.mavenproject1.fromlab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class CarShowroomContainer implements Serializable {
    Map<String, CarShowroom> carDealers;

    public CarShowroomContainer(Map<String, CarShowroom> carDealers) {
        this.carDealers = carDealers;
    }

    public Map<String, CarShowroom> getCarDealers() {
        return carDealers;
    }

    public void setCarDealers(Map<String, CarShowroom> carDealers) {
        this.carDealers = carDealers;
    }

    
    public void addCenter(CarShowroom cs){
        carDealers.put(cs.getName(), cs);
    }
    
    public void addCenter(String name, int maxNumOfCars,String miasto){
        carDealers.put(name,new CarShowroom(name,maxNumOfCars,miasto));
    }
    public boolean removeCenter(String name){
        try {
            carDealers.remove(name);
        }
        catch (Exception e){
            System.err.print(e);
            return false;
        }
        return true;
    }
    public ArrayList<CarShowroom> findEmpty(){
        ArrayList<CarShowroom> tmp = new ArrayList<>();
        for(Map.Entry<String,CarShowroom> entry : carDealers.entrySet()){
            if(entry.getValue().numOfCars == 0){
                tmp.add(entry.getValue());
            }
        }
        return tmp;
    }
    public void summary(){
        for(Map.Entry<String,CarShowroom> entry : carDealers.entrySet()) {
            System.out.print(entry.getKey() + " zapelnienie = " + (double)(entry.getValue().numOfCars * 100 / entry.getValue().maxNumOfCars ) + "%" + "\n");
        }

    }

    public void addCenter(String name, CarShowroom carShowroom) {
        carDealers.put(name,carShowroom);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
