/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.fromlab2;

import java.io.Serializable;

/**
 *
 * @author Kamil
 */
public class VechicleSerializable extends Vechicle implements Serializable{
    private String miasto;
    private String salon;

    public VechicleSerializable(String miasto, String salon, String marka, String model, ItemCondition itemCondition, int ilosc, double cena, int rokProdukcji, double pojemnoscSilnika, boolean zarezerwowane, int przebieg, String opisSprzedajacego) {
        super(marka, model, itemCondition, ilosc, cena, rokProdukcji, pojemnoscSilnika, zarezerwowane, przebieg, opisSprzedajacego);
        /*this.cena = cena;
        this.ilosc = ilosc;
        this.itemCondition = itemCondition;
        this.marka = marka;
        this.model = model;
        this.opisSprzedajacego = opisSprzedajacego;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.przebieg = przebieg;
        this.rokProdukcji = rokProdukcji;
        this.zarezerwowane = zarezerwowane;
*/
        this.miasto = miasto;
        this.salon = salon;
    }

   

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

   
    
    public boolean isEqual(TableVechicle o){
        if(     o.getCenaColumn().equals(String.valueOf(this.cena))
                && o.getIloscColumn().equals(String.valueOf(this.ilosc))
                && o.getItemConditionColumn().equals(String.valueOf(this.itemCondition))
                && o.getMarkaColumn().equals(String.valueOf(this.marka))
                && o.getMiastoColumn().equals(this.miasto)
                && o.getModelColumn().equals(this.model)
                && o.getOpisSprzedajacego().equals(this.opisSprzedajacego)
                && o.getPojemnoscSilnikaColumn().equals(String.valueOf(this.pojemnoscSilnika))
                && o.getPrzebieg() == this.przebieg
                && o.getRokProdukcjiColumn().equals(String.valueOf(this.rokProdukcji))
                && o.getSalonColumn().equals(this.salon)
                && o.getZarezerwowaneColumn().equals(String.valueOf(this.zarezerwowane)) //.equals(this.zarezerwowane))
            ){
                return true;
        }
        else
            return false;
        
    }
    
    
    public TableVechicle toTableVechicle(){
        return new TableVechicle(this.getMarka(),this.getModel(),this.getItemCondition().toString(),this.getIlosc(),this.getCena(),this.getRokProdukcji(),this.getPojemnoscSilnika(),this.getSalon(),this.getMiasto(),this.isZarezerwowane(),this.getPrzebieg(),this.getOpisSprzedajacego());
    }
}
