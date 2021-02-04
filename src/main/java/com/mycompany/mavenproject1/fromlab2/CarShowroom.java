package com.mycompany.mavenproject1.fromlab2;

import com.mycompany.mavenproject1.fromlab2.Vechicle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import com.mycompany.mavenproject1.fromlab2.ItemCondition;
import java.io.Serializable;

public class CarShowroom implements Serializable{
    String name;
    ArrayList<Vechicle> cars;
    int maxNumOfCars;
    int numOfCars;
    String miasto;

    public CarShowroom(String name, ArrayList<Vechicle> cars, int maxNumOfCars) {
        this.name = name;
        this.cars = cars;
        this.maxNumOfCars = maxNumOfCars;
    }

    public CarShowroom() {
        cars = new ArrayList<>();
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vechicle> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Vechicle> cars) {
        this.cars = cars;
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

    public int addProduct(Vechicle vechicle){
        //czy zmiesci się pojazd
        if(numOfCars + 1 > maxNumOfCars) System.err.print("Number of cars had accessed it's limitations");
        else {
            for(int i = 0; i < cars.size();++i){
            //for (Vechicle v : cars) {
                //istnieje ten sam pojazd
                if (cars.get(i).compareTo(vechicle) == 0) {
                    cars.get(i).setIlosc(cars.get(i).getIlosc() + 1);
                    numOfCars++;
                    return i;
                }
            }
            //nie istnieje ten sam pojazd
            cars.add(vechicle);
            numOfCars++;
            return -1;
        }
        return -2;
    }

    public Vechicle getProduct(Vechicle vechicle){
        for (Vechicle v : cars) {
            //istnieje ten sam pojazd
            if (v.compareTo(vechicle) == 0) {
                if(v.getIlosc() == 1){
                    Vechicle tmp = new Vechicle(v);
                    cars.remove(v);
                    return tmp;
                }else{
                    v.setIlosc(v.getIlosc() - 1);
                    return v;
                }

            }
        }
        System.err.print("this vechicle does not exist");
        return new Vechicle();
    }
    public boolean removeProduct(String marka,String model){
        try{
            for(Vechicle v : cars){
                if(v.getModel().equals( model) && v.getMarka().equals( marka)){
                     cars.remove(v);
                     return true;
                    }
                }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean removeProduct(Vechicle vechicle) {
        try {
            for(Vechicle v : cars){
                if(v.compareTo(vechicle) == 0){
                    cars.remove(v);
                }
            }

        }
        catch (Exception e){
            System.err.print(e.toString());
            return false;
        }
        return true;
    }
    public Vechicle search(String marka,String model){
        Vechicle tmp = new Vechicle(marka,model);
        for(Vechicle v : cars){
            if(v.compareTo(tmp) == 0){
                return v;
            }
        }
        return new Vechicle();
    }
    public ArrayList<Vechicle> searchPartial(String nazwa){
        ArrayList<Vechicle> tmp = new ArrayList<>();

        for(Vechicle v : cars){
            if(v.getMarka().compareTo(nazwa) >= 0 ||  v.getModel().compareTo(nazwa) >= 0){
                tmp.add(v);
            }
        }
        return tmp;
    }

    public int countByCondition(ItemCondition itemCondition){
        int counter = 0;
        for(Vechicle v : cars){
            if(v.getItemCondition().compareTo(itemCondition) == 0){
                counter ++;
            }
        }
        return counter;
    }
    public void summary(){
        for(Vechicle v : cars){
            v.print();
        }
    }
    public ArrayList<Vechicle> sortByName(){
        ArrayList<Vechicle> tmp = new ArrayList<>(cars);
        tmp.sort(new Comparator<Vechicle>() {
            @Override
            public int compare(Vechicle o1, Vechicle o2) {
                return o1.getMarka().compareTo(o2.getMarka());
            }
        });
        return tmp;
    }

    public CarShowroom(String name, int maxNumOfCars, String miasto) {
        this.name = name;
        this.maxNumOfCars = maxNumOfCars;
        this.cars = new ArrayList<>();
        this.miasto = miasto;
    }

    public ArrayList<Vechicle> sortByAmount(){
        ArrayList<Vechicle> tmp = new ArrayList<>(cars);
        tmp.sort(new Comparator<Vechicle>() {
            @Override
            public int compare(Vechicle o1, Vechicle o2) {
                if(o1.getIlosc() > o2.getIlosc()) return 1;
                if(o1.getIlosc() == o2.getIlosc()) return 0;
                else{
                    return -1;
                }
            }
        });
        return tmp;
    }
    public Vechicle max(){
        return Collections.max(cars, new Comparator<Vechicle>() {
            @Override
            public int compare(Vechicle o1, Vechicle o2) {
                if(o1.getIlosc() > o2.getIlosc()) return 1;
                if(o1.getIlosc() == o2.getIlosc()) return 0;
                if(o1.getIlosc() < o2.getIlosc()) return -1;
            return -2;
            }
        });
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
    
}