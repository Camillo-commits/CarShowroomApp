/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.fromlab2;

import adnotations.Marka;
import java.io.IOException;
import java.io.Serializable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kamil
 */
public class TableVechicle implements Comparable<TableVechicle>, Serializable {
    //@Marka
    //String marka;
    private SimpleStringProperty MarkaColumn;
    public SimpleStringProperty markaColumnProperty(){
        if(MarkaColumn == null)
            MarkaColumn = new SimpleStringProperty(this,"MarkaColumn");
        return MarkaColumn;
    }
    
    private SimpleStringProperty ModelColumn;
     public SimpleStringProperty modelColumnProperty(){
        if(ModelColumn == null)
            ModelColumn = new SimpleStringProperty(this,"ModelColumn");
        return ModelColumn;
    }
     
    private SimpleStringProperty KondycjaColumn;
     public SimpleStringProperty kondycjaColumnProperty(){
        if(KondycjaColumn == null)
            KondycjaColumn = new SimpleStringProperty(this,"KondycjaColumn");
        return KondycjaColumn;
    }
    
    private SimpleStringProperty IloscColumn;
     public SimpleStringProperty iloscColumnProperty(){
        if(IloscColumn == null)
            IloscColumn = new SimpleStringProperty(this,"IloscColumn");
        return IloscColumn;
    }
    
    private SimpleStringProperty CenaColumn;
     public SimpleStringProperty cenaColumnProperty(){
        if(CenaColumn == null)
            CenaColumn = new SimpleStringProperty(this,"CenaColumn");
        return CenaColumn;
    }
     
    private SimpleStringProperty RokProdukcjiColumn;
     public SimpleStringProperty rokProdukcjiColumnProperty(){
        if(RokProdukcjiColumn == null)
            RokProdukcjiColumn = new SimpleStringProperty(this,"RokProdukcjiColumn");
        return RokProdukcjiColumn;
    }
    
    private SimpleStringProperty PojemnoscSilnikaColumn;
     public SimpleStringProperty pojemnoscSilnikaColumnProperty(){
        if(PojemnoscSilnikaColumn == null)
            PojemnoscSilnikaColumn = new SimpleStringProperty(this,"MarkaColumn");
        return PojemnoscSilnikaColumn;
    }
     
    private SimpleStringProperty SalonColumn;
    public SimpleStringProperty salonColumnProperty(){
        if(SalonColumn == null)
            SalonColumn = new SimpleStringProperty(this,"SalonColumn");
        return SalonColumn;
    }
    private SimpleStringProperty MiastoColumn;
    public SimpleStringProperty miastoColumnProperty(){
        if(MiastoColumn == null)
            MiastoColumn = new SimpleStringProperty(this,"MiastoColumn");
        return MiastoColumn;
    }
    
    private SimpleStringProperty ZarezerwowaneColumn;
     public SimpleStringProperty zarezerwowaneColumnProperty(){
        if(ZarezerwowaneColumn == null)
            ZarezerwowaneColumn = new SimpleStringProperty(this,"ZarezerwowaneColumn");
        return ZarezerwowaneColumn;
    }
     
     private String opisSprzedajacego;
     private int przebieg;
    public TableVechicle() {
        MarkaColumn = new SimpleStringProperty("");
        //this.marka = marka;
        ModelColumn = new SimpleStringProperty("");
        KondycjaColumn = new SimpleStringProperty("");
        IloscColumn = new SimpleStringProperty("0");
        CenaColumn = new SimpleStringProperty("0");
        RokProdukcjiColumn = new SimpleStringProperty("0");
        PojemnoscSilnikaColumn = new SimpleStringProperty("0");
        SalonColumn = new SimpleStringProperty("");
        MiastoColumn = new SimpleStringProperty("");
        ZarezerwowaneColumn = new SimpleStringProperty(String.valueOf(""));
    }

    public TableVechicle(String marka, String model,String salon,String miasto,boolean zarezerwowane) {
        this.MarkaColumn = new SimpleStringProperty(marka) ;
        //this.marka = marka;
        this.ModelColumn = new SimpleStringProperty(model);
        KondycjaColumn = new SimpleStringProperty("");
        IloscColumn = new SimpleStringProperty("0");
        CenaColumn = new SimpleStringProperty("0");
        RokProdukcjiColumn = new SimpleStringProperty("0");
        PojemnoscSilnikaColumn = new SimpleStringProperty("0");
        SalonColumn = new SimpleStringProperty(salon);
        MiastoColumn = new SimpleStringProperty(miasto);
        ZarezerwowaneColumn = new SimpleStringProperty(String.valueOf(zarezerwowane));
    }

    public TableVechicle(String marka, String model, String itemCondition,String salon,String miasto,boolean zarezerwowane) {
        this.MarkaColumn = new SimpleStringProperty(marka) ;
        //this.marka = marka;
        this.ModelColumn = new SimpleStringProperty(model);
        this.KondycjaColumn = new SimpleStringProperty(itemCondition);
        this.IloscColumn = new SimpleStringProperty("0");
        CenaColumn = new SimpleStringProperty("0");
        RokProdukcjiColumn = new SimpleStringProperty("0");
        PojemnoscSilnikaColumn = new SimpleStringProperty("0");
        SalonColumn = new SimpleStringProperty(salon);
        MiastoColumn = new SimpleStringProperty(miasto);
        ZarezerwowaneColumn = new SimpleStringProperty(String.valueOf(zarezerwowane));
    }

    public TableVechicle(String marka, String model, String itemCondition,int ilosc, double cena, int rokProdukcji, double pojemnoscSilnika,String salon,String miasto,boolean zarezerwowane, int przebieg,String opis) {
        //this.marka = marka;
        this.MarkaColumn = new SimpleStringProperty(marka) ;
        this.ModelColumn = new SimpleStringProperty(model);
        this.KondycjaColumn = new SimpleStringProperty(itemCondition);
        this.IloscColumn = new SimpleStringProperty(String.valueOf(ilosc));
        this.CenaColumn = new SimpleStringProperty(String.valueOf(cena));
        this.RokProdukcjiColumn = new SimpleStringProperty(String.valueOf(rokProdukcji));
        this.PojemnoscSilnikaColumn = new SimpleStringProperty(String.valueOf(pojemnoscSilnika));
        SalonColumn = new SimpleStringProperty(salon);
        MiastoColumn = new SimpleStringProperty(miasto);
        ZarezerwowaneColumn = new SimpleStringProperty(String.valueOf(zarezerwowane));
        this.przebieg = przebieg;
        this.opisSprzedajacego = opis;
    }

    

    public String getMarkaColumn() {
        //return marka;
        return MarkaColumn.get();
    }

    public String getModelColumn() {
        return ModelColumn.get();
    }

    public String getItemConditionColumn() {
        return KondycjaColumn.get();
    }

    public String getIloscColumn() {
        return IloscColumn.get();
    }

    public String getCenaColumn() {
        return CenaColumn.get();
    }

    public String getRokProdukcjiColumn() {
        return RokProdukcjiColumn.get();
    }

    public String getPojemnoscSilnikaColumn() {
        return PojemnoscSilnikaColumn.get();
    }
    
    public String getSalonColumn(){
        return SalonColumn.get();
    }
    
    public String getMiastoColumn(){
        return MiastoColumn.get();
    }
    
    public String getZarezerwowaneColumn(){
        return ZarezerwowaneColumn.get();
    }

    public String getOpisSprzedajacego() {
        return opisSprzedajacego;
    }

    public void setOpisSprzedajacego(String opisSprzedajacego) {
        this.opisSprzedajacego = opisSprzedajacego;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }
    
    

    public void setMarkaColumn(String marka) {
        this.MarkaColumn.set(marka);
        //this.marka = marka;
    }

    public void setModelColumn(String model) {
        this.ModelColumn.set(model);
    }

    public void setItemConditionColumn(String itemCondition) {
        this.KondycjaColumn.set(itemCondition);
    }

    public void setIloscColumn(int ilosc) {
        this.IloscColumn.set(String.valueOf(ilosc));
    }

    public void setCenaColumn(double cena) {
        this.CenaColumn.set(String.valueOf(cena));
    }

    public void setRokProdukcjiColumn(int rokProdukcji) {
        this.RokProdukcjiColumn.set(String.valueOf(rokProdukcji));
    }

    public void setPojemnoscSilnikaColumn(double pojemnoscSilnika) {
        this.PojemnoscSilnikaColumn.set(String.valueOf(pojemnoscSilnika));
    }
    public void setZarezerwowaneColumn(boolean isReserved){
        this.ZarezerwowaneColumn.set(String.valueOf(isReserved));
        
    }

    @Override
    public int compareTo(TableVechicle o) {
        if(     o.getCenaColumn().equals(this.CenaColumn.toString())
                && o.getIloscColumn().equals(this.IloscColumn.toString())
                && o.getItemConditionColumn().equals(this.KondycjaColumn.toString())
                && o.getMarkaColumn().equals(this.MarkaColumn.toString())
                && o.getMiastoColumn().equals(this.MiastoColumn.toString())
                && o.getModelColumn().equals(this.ModelColumn.toString())
                && o.getOpisSprzedajacego().equals(this.opisSprzedajacego)
                && o.getPojemnoscSilnikaColumn().equals(this.PojemnoscSilnikaColumn.toString())
                && o.getPrzebieg() == this.przebieg
                && o.getRokProdukcjiColumn().equals(this.RokProdukcjiColumn.toString())
                && o.getSalonColumn().equals(this.SalonColumn.toString())
                && o.getZarezerwowaneColumn().equals(this.ZarezerwowaneColumn.toString())
            )
        {
            return 0;
        }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return -1;
    }
    
   /* public VechicleSerializable toVechicleSerializable(){
        return new VechicleSerializable(this.getMiastoColumn(),this.getSalonColumn(),this.getMarkaColumn(), this.getModelColumn(),this.getItemConditionColumn(), Integer.valueOf(this.getIloscColumn()), Double.valueOf(this.getCenaColumn()), Integer.valueOf(this.getRokProdukcjiColumn()), Double.valueOf(this.getPojemnoscSilnikaColumn()), Boolean.valueOf(this.getZarezerwowaneColumn()), this.przebieg, this.opisSprzedajacego);
    }
   */
}
