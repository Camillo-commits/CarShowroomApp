package com.mycompany.mavenproject1.fromlab2;

import com.mycompany.mavenproject1.fromlab2.ItemCondition;
import java.io.Serializable;
//import com.sun.jdi.connect.Connector;

public class Vechicle implements Comparable<Vechicle>,Serializable {
    String marka;
    String model;
    ItemCondition itemCondition;
    int ilosc;
    double cena;
    int rokProdukcji;
    double pojemnoscSilnika;
    boolean zarezerwowane;
    int przebieg;
    String opisSprzedajacego;

    public Vechicle(String marka, String model, ItemCondition itemCondition, int ilosc, double cena, int rokProdukcji, double pojemnoscSilnika, boolean zarezerwowane, int przebieg, String opisSprzedajacego) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.ilosc = ilosc;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.zarezerwowane = zarezerwowane;
        this.przebieg = przebieg;
        this.opisSprzedajacego = opisSprzedajacego;
    }

    
    
    public Vechicle(String marka, String model, ItemCondition itemCondition, double cena, int rokProdukcji, double pojemnoscSilnika, boolean zarezerwowane, int przebieg, String opisSprzedajacego) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.zarezerwowane = zarezerwowane;
        this.przebieg = przebieg;
        this.opisSprzedajacego = opisSprzedajacego;
        this.ilosc = 1;
    }

    
    
    public Vechicle(String marka, String model, ItemCondition itemCondition, int ilosc, double cena, int rokProdukcji, double pojemnoscSilnika, boolean zarezerwowane) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.ilosc = ilosc;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.zarezerwowane = zarezerwowane;
    }

    public Vechicle(String marka, String model, ItemCondition itemCondition, double cena, int rokProdukcji, double pojemnoscSilnika, boolean zarezerwowane) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.zarezerwowane = zarezerwowane;
        this.ilosc = 1;
    }
    
    
    
    

    public Vechicle(String marka, String model, ItemCondition itemCondition, int ilosc, double cena, int rokProdukcji, double pojemnoscSilnika) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.ilosc = ilosc;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public Vechicle(String marka, String model, ItemCondition itemCondition, double cena, int rokProdukcji, double pojemnoscSilnika) {
        this.marka = marka;
        this.model = model;
        this.itemCondition = itemCondition;
        this.cena = cena;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.ilosc = 1;
    }

    public Vechicle() {
        this.marka = "";
        this.model = "";
        this.itemCondition = null;
        this.cena = 0;
        this.rokProdukcji = 0;
        this.pojemnoscSilnika = 0;
        this.ilosc = 1;
    }

    public Vechicle(String marka) {
        this.marka = marka;
        this.ilosc = 1;
    }

    public Vechicle(String marka, String model) {
        this.marka = marka;
        this.model = model;
        this.ilosc = 1;
    }

    public Vechicle(Vechicle v) {
    }

    public boolean isZarezerwowane() {
        return zarezerwowane;
    }

    
    
    public String getMarka() {
        return marka;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public double getCena() {
        return cena;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public String getModel() {
        return model;
    }

    public void print(){
        System.out.println(
                "marka: " + this.marka + "\n" +
                "model: " + this.model + "\n" +
                "kondycja: " + this.itemCondition.toString() + "\n" +
                "cena: " + this.cena + "\n" +
                "rok produkcji: " + this.rokProdukcji + "\n" +
                "pojemnosc silnika: " + this.pojemnoscSilnika + "\n" +
                "ilosc: " + this.ilosc
        );
    }

    @Override
    public int compareTo(Vechicle o) {
        if(this.marka.equals(o.marka) && this.model.equals(o.model))
        return 0;
        else return -1;
    }
    
    public int compareToDetailed(Vechicle o) {
        if(this.marka.equals(o.marka) && this.model.equals(o.model) 
                && this.itemCondition.equals(o.itemCondition) 
                && this.ilosc == o.getIlosc()
                && this.rokProdukcji == o.getRokProdukcji()
                && this.pojemnoscSilnika == o.getPojemnoscSilnika())
        return 0;
        else return -1;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    public void setZarezerwowane(boolean zarezerwowane) {
        this.zarezerwowane = zarezerwowane;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getOpisSprzedajacego() {
        return opisSprzedajacego;
    }

    public void setOpisSprzedajacego(String opisSprzedajacego) {
        this.opisSprzedajacego = opisSprzedajacego;
    }

    
}
