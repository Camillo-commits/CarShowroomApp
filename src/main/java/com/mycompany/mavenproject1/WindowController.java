/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Excel.ExcelCarShowroomIO;
import Excel.ExcelCarsIO;
import adnotations.Marka;
import com.mycompany.mavenproject1.fromlab2.CarShowroom;
import com.mycompany.mavenproject1.fromlab2.CarShowroomContainer;
import com.mycompany.mavenproject1.fromlab2.ItemCondition;
import com.mycompany.mavenproject1.fromlab2.TableVechicle;
import com.mycompany.mavenproject1.fromlab2.Vechicle;
import com.mycompany.mavenproject1.fromlab2.VechicleSerializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ListExpression;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import shareable.Shareable;

/**
 *
 * @author Kamil
 */
public class WindowController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        assert KondycjaComboBox != null : "Fail to inject KondycjaComboBox";
        assert ModelComboBox != null : "Fail to inject ";
        assert MarkaComboBox != null : "Fail to inject ";
        assert cenaOd != null : "Fail to inject ";
        assert cenaDo != null : "Fail to inject ";
        assert MiastoButton != null : "Fail to inject ";
        assert salonButton != null : "Fail to inject ";
        assert MiastoComboBox != null : "Fail to inject ";
        assert SalonComboBox != null : "Fail to inject ";
        assert SzukajButton != null : "Fail to inject ";
        assert PojemnośćOd != null : "Fail to inject ";
        assert PojemnośćDo != null : "Fail to inject ";
        assert RokOd != null : "Fail to inject ";
        assert RokDo != null : "Fail to inject ";
        
        assert CarTable != null : "Fail to inject ";
        assert MarkaColumn != null : "Fail to inject ";
        assert ModelColumn != null : "Fail to inject ";
        assert KondycjaColumn != null : "Fail to inject ";
        assert IloscColumn != null : "Fail to inject ";
        assert CenaColumn != null : "Fail to inject ";
        assert RokProdukcjiColumn != null : "Fail to inject ";
        assert PojemnoscSilnikaColumn != null : "Fail to inject ";
        assert SalonColumn != null : "Fail to inject ";
        assert MiastoColumn != null : "Fail to inject ";
        assert ZarezerwowaneColumn != null : "Fail to inject ";
        
       // assert toolTip != null : "Fail to inject ";
        assert ExtraSearchButton != null : "Fail to inject";
        assert ExtraCarInfoButton != null : "Fail to inject";
        assert errorLabel != null : "Fail to inject";
        assert zakupButton != null : "Fail to inject";
        //assert zarezerwujButton != null : "Fail to inject";
        
        //          RADIO BUTTONS           //
        ToggleGroup group = new ToggleGroup();
        salonButton.setToggleGroup(group);
        MiastoButton.setToggleGroup(group);
        //ExtraSearchButton.setToggleGroup(group);
        ///////////////////////////////////////
        //      LABEL       //
        errorLabel.setTextFill(Color.RED);
        /////////////////////
        
        
        ///             GENEROWANIE DANYCH              ///
        /*
        carShowroomContainer.addCenter("Salon1", 10,"Kraków");
        carShowroomContainer.addCenter("Salon2", 10,"Kraków");
        carShowroomContainer.addCenter("Salon3", 100,"Warszawa");
        
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("BMW","120i",ItemCondition.USED,2500.0,2005,2000.0,true,150000,"Niemiec plakal jak sprzedawal"));
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("Mercedes-Benz","W201",ItemCondition.USED,2500.0,1999,3000.0,false,240000,"tel. 555 555 555"));
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("BMW","120i",ItemCondition.USED,3000.0,2005,2000.0,true,150000,"Niemiec plakal jak sprzedawal"));
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("BMW","320i",ItemCondition.USED,25000.0,2015,2000.0,false,150000,"Komentarz"));
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("Mercedes-Benz","W123",ItemCondition.USED,5000.0,1973,3000.0,false,240000,"tel. 555 555 555"));
        carShowroomContainer.getCarDealers().get("Salon1").addProduct(new Vechicle("BMW","320i",ItemCondition.USED,25000.0,2015,2000.0,false,150000,"Komentarz"));

        
        carShowroomContainer.getCarDealers().get("Salon2").addProduct(new Vechicle("BMW","120i",ItemCondition.USED,2500.0,2005,2000.0,false,900000,"jak nie sprzeda si edo czwartku oddam na żyletki"));
        carShowroomContainer.getCarDealers().get("Salon2").addProduct(new Vechicle("Mazda","3",ItemCondition.NEW,75000.0,2020,1900.0,false,0,"tani i oszczedny"));

        carShowroomContainer.getCarDealers().get("Salon3").addProduct(new Vechicle("BMW","120i",ItemCondition.USED,2500.0,2005,2000.0,false,70000,"nie odpisuje na sms \ntelefon: 832 234 211"));
        carShowroomContainer.getCarDealers().get("Salon3").addProduct(new Vechicle("Fiat","Panda",ItemCondition.DAMAGED,500.0,2010,1300.0,false,35000,"nie odpisuje na sms \ntelefon: 832 234 211"));
        carShowroomContainer.getCarDealers().get("Salon3").addProduct(new Vechicle("Toyota","GT-86",ItemCondition.USED,54000.0,2018,2000.0,false,57000,"nie odpisuje na sms \ntelefon: 832 234 211"));
        carShowroomContainer.getCarDealers().get("Salon3").addProduct(new Vechicle("Toyota","Yaris",ItemCondition.NEW,32000.0,2019,1400.0,false,57000,"nie odpisuje na sms \ntelefon: 832 234 211"));

        
        //SERIALIZATION
        
        try {
            FileOutputStream fileOut = new FileOutputStream("carShowroomContainer.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(carShowroomContainer);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */
        FileInputStream fileIn;
        ObjectInputStream in;
        try{
        fileIn = new FileInputStream("carShowroomContainer.csv");
        in = new ObjectInputStream(fileIn);
                  
        carShowroomContainer = (CarShowroomContainer) in.readObject();
        }
        catch(Exception ex){
            System.err.println(ex.toString());
        }

        savedCars = new ArrayList<>();
        try{
        fileIn = new FileInputStream("savedCars.csv");
        in = new ObjectInputStream(fileIn);
           
        savedCars = (List<VechicleSerializable>) in.readObject();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        //List<Vechicle> savedCars = new ArrayList<>();
    
        
        /*try {
            FileOutputStream fileOut = new FileOutputStream("savedCars.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savedCars);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */
        
      
        
        ///////////////////////////////////////////////////
        boolean add = false;
        ///         MARKA         ///
        List <String> marki = new ArrayList<>();
        List <String> modele = new ArrayList<>();
        
            //          THROUGH EVERY DEALER            //
            for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
                //      THROUGH EVERY CAR       //
                for(Vechicle car : entry.getValue().getCars()){
                    //      THROUGH LISTS       //
                    for(int v = 0;v < marki.size() ; ++v){
                        //      MARKA       //
                        if(car.getMarka().equalsIgnoreCase(marki.get(v))){
                            add = false;
                            break;
                        }
                        else
                            add = true;
                    }
                    if(marki.size() == 0){
                        marki.add(car.getMarka());  
                    }
                    if(add){
                        marki.add(car.getMarka());
                    }
                }
            }
        add = false;
        
        marki.add("Marka");
        
        for(String s : marki){
            MarkaComboBox.getItems().add(s);
        }
        
        
        //ModelComboBox.getItems().setAll(modele);
        
        ModelComboBox.setVisible(false);
        
        MarkaComboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ModelComboBox.getItems().clear();
                modele.clear();
                for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
                //      THROUGH EVERY CAR       //
                    for(Vechicle car : entry.getValue().getCars()){
                    //      THROUGH LISTS       //
                        for(int v = 0; v < modele.size(); ++v){
                        //      MODEL       //
                            if(!car.getModel().equalsIgnoreCase(modele.get(v)) && t1.equalsIgnoreCase(car.getMarka())){
                                modele.add(car.getModel());
                            }
                        }
                        if(modele.size() == 0 && t1.equalsIgnoreCase(car.getMarka())){
                            modele.add(car.getModel());
                        }
                    }
                    ModelComboBox.setVisible(true);
                }
                for(String s: modele){
                    ModelComboBox.getItems().add(s);
                }        
            }});
       
        
        ModelComboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
                    
        });
        
            
        ///////////////////////////////
        
        ///     KONDYCJA        /// 
        KondycjaComboBox.getItems().setAll("NEW","USED","DAMAGED");  
        
        KondycjaComboBox.getSelectionModel().
                selectedItemProperty().
                addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
               
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            
        
        });
        /////////////////////////
        
        //      MIASTO     //
        List<String> miasta = new ArrayList<>();
        
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            //      THROUGH EVERY CARSHOWROOM       //
            for(int i = 0; i < miasta.size(); ++i){
                if(miasta.get(i).equalsIgnoreCase(entry.getValue().getMiasto())){
                    add = false;
                    break;
                }
                else{
                    add = true;
                }
                    
            }
            if(miasta.size() == 0){
                miasta.add(entry.getValue().getMiasto());
            }
            if(add){
                miasta.add(entry.getValue().getMiasto());
            }
        }
            
        for(String s : miasta){
            MiastoComboBox.getItems().add(s);
        }    
        
        ////////////////////////
        
        //      SALON       //
        add = false;
        List<String> salony = new ArrayList<>();
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            //      THROUGH EVERY CARSHOWROOM       //
            for(int i = 0; i < salony.size();++i){
                if(salony.get(i).equalsIgnoreCase(entry.getValue().getName())){
                    add = false;
                    break;
                }
                else{
                    add = true;
                }
                   
            }
            if(salony.size() == 0){
                salony.add(entry.getValue().getName());
            }
            if(add){
                 salony.add(entry.getValue().getName());
            }
        }
            
        for(String s : salony){
            SalonComboBox.getItems().add(s);
        }    
        
        
        /////////////////////// 
        
        //          TABLE CARS          //
        
        //CarTable = new TableView<>();
        //CarTable.setEditable(true);
        
        //CarTable.getItems().setAll(new TableVechicle("Suzuki","Jimny"));
        
        /*CarTable.rowFactoryProperty().addListener(new ChangeListener<>(){
            @Override
            public void changed(ObservableValue<? extends Callback<TableView<TableVechicle>, TableRow<TableVechicle>>> ov, Callback<TableView<TableVechicle>, TableRow<TableVechicle>> t, Callback<TableView<TableVechicle>, TableRow<TableVechicle>> t1) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });*/
        //List<TableVechicle> list = new ArrayList<>();
        //list.add(new TableVechicle("marka","model"));
        //carsList = FXCollections.observableArrayList();//list); 
        
       // MarkaColumn = new TableColumn<>("Marka");
       MarkaColumn.setCellValueFactory(v-> v.getValue().markaColumnProperty());  //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).markaColumnProperty().getName()));
       /*Class cls = TableVechicle.class;
       
       Field markaField;
       try{
           markaField = cls.getDeclaredField("marka");
           String name = markaField.getName();
           MarkaColumn.setCellValueFactory(new PropertyValueFactory<TableVechicle,String>(name));
           Annotation annotation = markaField.getAnnotation(Marka.class);
           if(annotation instanceof Marka){
               Marka marka = (Marka) annotation;
               MarkaColumn.setText(marka.name());
           }
        //ModelColumn = new TableColumn<>("Model");
       }
       catch(Exception e){
           System.err.println(e);
       }*/
        ModelColumn.setCellValueFactory(v-> v.getValue().modelColumnProperty());  //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).modelColumnProperty().getName()));

        //KondycjaColumn = new TableColumn<>("Kondycja");
        KondycjaColumn.setCellValueFactory(v-> v.getValue().kondycjaColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).kondycjaColumnProperty().getName()));

        //IloscColumn = new TableColumn<>("Ilosc");
        IloscColumn.setCellValueFactory(v-> v.getValue().iloscColumnProperty());        //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).iloscColumnProperty().getName()));

        //CenaColumn = new TableColumn<>("Cena");
        CenaColumn.setCellValueFactory(v-> v.getValue().cenaColumnProperty());     //new PropertyValueFactory <>/*<TableVechicle,String>*/(carsList.get(0).cenaColumnProperty().getName()));

        //RokProdukcjiColumn = new TableColumn<>("Rok Produkcji");
        RokProdukcjiColumn.setCellValueFactory(v-> v.getValue().rokProdukcjiColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).rokProdukcjiColumnProperty().getName()));

        //PojemnoscSilnikaColumn = new TableColumn<>("Pojemnosc silnika");
        PojemnoscSilnikaColumn.setCellValueFactory(v-> v.getValue().pojemnoscSilnikaColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).pojemnoscSilnikaColumnProperty().getName()));

        SalonColumn.setCellValueFactory(v-> v.getValue().salonColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).pojemnoscSilnikaColumnProperty().getName()));

        MiastoColumn.setCellValueFactory(v-> v.getValue().miastoColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).pojemnoscSilnikaColumnProperty().getName()));

        ZarezerwowaneColumn.setCellValueFactory(v-> v.getValue().zarezerwowaneColumnProperty());     //new PropertyValueFactory<>/*<TableVechicle,String>*/(carsList.get(0).pojemnoscSilnikaColumnProperty().getName()));

        
        CarTable.setItems(carsList);
        //CarTable.getColumns().setAll(MarkaColumn,ModelColumn,KondycjaColumn,IloscColumn,CenaColumn,RokProdukcjiColumn,PojemnoscSilnikaColumn);
        
        //CarTable.refresh();
        
        CarTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //CarTable.setTooltip(toolTip);
        CarTable.setRowFactory(tv -> new TableRow<TableVechicle>(){
          //private Tooltip rowTooltip = new Tooltip();
          @Override
          public void updateItem(TableVechicle tableVechicle,boolean empty){
              super.updateItem(tableVechicle, empty);
              if(tableVechicle == null){
                  setTooltip(null);    
              }
                else{
                  toolTip = new Tooltip();
                  toolTip.setText("Przebieg: " + getItem().getPrzebieg()+"\n\n"
                          + getItem().getOpisSprzedajacego() );
                  setTooltip(toolTip);
                  
              }
          }
        });
        
        /*
        MarkaColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getMarka();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        ModelColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getModel();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        KondycjaColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getItemCondition();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        IloscColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return String.valueOf(p) p.getValue().getIlosc();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        CenaColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getCena().asString();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        RokProdukcjiColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getRokProdukcji().asString();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        PojemnoscSilnikaColumn.setCellValueFactory(new Callback<CellDataFeatures<TableVechicle,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<TableVechicle, String> p) {
                return p.getValue().getPojemnoscSilnika().asString();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });*/
        
        //CarTable.getItems().add(new TableVechicle("marka","model"));
        
       // CarTable.getColumns().setAll(MarkaColumn,ModelColumn,KondycjaColumn,IloscColumn, CenaColumn, RokProdukcjiColumn,PojemnoscSilnikaColumn);
        //carsList = new SimpleListProperty<>();
       
        //carsList.add(new TableVechicle(new SimpleStringProperty("Suzuki"),new SimpleStringProperty("Jimny")));
        
        
        /*
        carsList.addListener(new ListChangeListener<Vechicle>(){
            @Override
            public void onChanged(ListChangeListener.Change<? extends Vechicle> change) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
*/
        //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty("Suzuki"),new SimpleStringProperty("Jimny")));
        
        ///////////////////////////////////
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //              SZUKAJ BUTTON FUNCTION              //
    @FXML
    private void szukaj()throws IOException{
        double minPrice = -1;
        double maxPrice = -1;
        if(!cenaOd.getText().equals(""))
            minPrice = Double.valueOf(cenaOd.getText());
        if(!cenaDo.getText().equals(""))
            maxPrice = Double.valueOf(cenaDo.getText());
        
        String markaStr = MarkaComboBox.getValue();
        String modelStr = ModelComboBox.getValue();
        String condStr = KondycjaComboBox.getValue();
        String miastoStr = MiastoComboBox.getValue();
        String salonStr = SalonComboBox.getValue();
        
        double pojemnoscOd = -1;
        double pojemnoscDo = -1;
        if(!PojemnośćOd.getText().equals(""))
            pojemnoscOd = Double.valueOf(PojemnośćOd.getText());
        if(!PojemnośćDo.getText().equals(""))
            pojemnoscDo = Double.valueOf(PojemnośćDo.getText());
        
        int rokOd = -1;
        int rokDo = -1;
        if(!RokOd.getText().equals("")){
            rokOd = Integer.valueOf(RokOd.getText());
        }
        if(!RokDo.getText().equals(""))
            rokDo = Integer.valueOf(RokDo.getText());
        if(markaStr == null){
            markaStr = "";
        }
        if(markaStr.equals("Marka"))
            markaStr = null;
        
        if(ExtraSearchButton.isSelected()){
            //      EXTRA DATA NEEDED       //
            if(ExtraCarInfoButton.isSelected()){
                if(MiastoButton.isSelected()){
                    search(markaStr,modelStr,condStr, pojemnoscOd,pojemnoscDo,rokOd, rokDo,minPrice,maxPrice,miastoStr);
                }
                if(salonButton.isSelected()){
                    search(markaStr,modelStr,condStr, pojemnoscOd,pojemnoscDo,rokOd, rokDo,minPrice,maxPrice,salonStr);
                }
            }    
            //          EXTRA DATA NOT NEEDED       //
            else{
                if(MiastoButton.isSelected()){
                    search(markaStr,modelStr,condStr,minPrice,maxPrice,miastoStr);
                }
                if(salonButton.isSelected()){
                    search(markaStr,modelStr,condStr,minPrice,maxPrice,salonStr);
                }
            }
        }
        else{
            //      SHOW FROM ALL CITIES AND SALONS        //
             //      EXTRA DATA NEEDED       //
            if(ExtraCarInfoButton.isSelected()){
                search(markaStr,modelStr,condStr,pojemnoscOd,pojemnoscDo,rokOd,rokDo,minPrice,maxPrice);
            }
            //          EXTRA DATA NOT NEEDED       //
            else{
                search(markaStr,modelStr,condStr,minPrice,maxPrice);
            }
        }
    }        
    /////////////////////////////////////////////////////////
    
    
    
    private void search(String marka,String model, String kondycja, double pojemnoscOd,double pojemnoscDo,int rokOd,int rokDo,double minPrice, double maxPrice){
        carsList.clear();
        
        if(marka == null)
            marka = "";
        if(model == null)
            model = "";
        if(kondycja == null)
            kondycja = "";
        
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            for(Vechicle car : entry.getValue().getCars()){
                 if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                    if((car.getPojemnoscSilnika() >= pojemnoscOd || pojemnoscOd == -1) && (car.getPojemnoscSilnika() <= pojemnoscDo || pojemnoscDo == -1))
                        if((car.getRokProdukcji() >= rokOd || rokOd == -1) && (car.getRokProdukcji() <= rokDo || rokDo == -1)){
                            if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                                //      THIS CAR FITS SEARCH        //
                                //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                                CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego()));
                                //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                        }
                } 
            }
        }
    }
    
    private void search(String marka,String model, String kondycja, double minPrice, double maxPrice){
        carsList.clear();
        if(marka == null)
            marka = "";
        if(model == null)
            model = "";
        if(kondycja == null)
            kondycja = "";
        
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            for(Vechicle car : entry.getValue().getCars()){
                 //      THIS CAR FITS SEARCH        //
                if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                    if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                        //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                        carsList.add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego())); 
                        //CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika()));
                        //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                }
            }
        }  
        //CarTable.getItems().setAll(carsList);
    }
    
    private void search(String marka,String model, String kondycja, double minPrice, double maxPrice,String miastoOrSalon){
        carsList.clear();
        if(marka == null)
            marka = "";
        if(model == null)
            model = "";
        if(kondycja == null)
            kondycja = "";
        if(miastoOrSalon == null)
            miastoOrSalon = "";
        if(MiastoButton.isSelected()){
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            if(entry.getValue().getMiasto().equalsIgnoreCase(miastoOrSalon) || miastoOrSalon == ""){ 
            for(Vechicle car : entry.getValue().getCars()){
                 //      THIS CAR FITS SEARCH        //
                if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                    if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                         CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego()));
                        //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                        //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                }
            }
            }
        }    
        }
        
        if(salonButton.isSelected()){
            for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            if(entry.getValue().getName().equalsIgnoreCase(miastoOrSalon) || miastoOrSalon == ""){ 
            for(Vechicle car : entry.getValue().getCars()){
                 //      THIS CAR FITS SEARCH        //
                if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                    if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                         CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego()));
                        //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                        //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                }
            }
            }
        }    
        }
    }
    
    private void search(String marka,String model, String kondycja, double pojemnoscOd,double pojemnoscDo,int rokOd,int rokDo,double minPrice, double maxPrice, String miastoOrSalon){
        carsList.clear();
        if(marka == null)
            marka = "";
        if(model == null)
            model = "";
        if(kondycja == null)
            kondycja = "";
        if(miastoOrSalon == null)
            miastoOrSalon = "";
        if(MiastoButton.isSelected()){
            for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
                if(entry.getValue().getMiasto().equalsIgnoreCase(miastoOrSalon)|| miastoOrSalon == ""){ 
                  for(Vechicle car : entry.getValue().getCars()){
                    if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                        if((car.getPojemnoscSilnika() >= pojemnoscOd || pojemnoscOd == -1) && (car.getPojemnoscSilnika() <= pojemnoscDo || pojemnoscDo == -1))
                            if((car.getRokProdukcji() >= rokOd || rokOd == -1) && (car.getRokProdukcji() <= rokDo || rokDo == -1)){
                                if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                                    //      THIS CAR FITS SEARCH        //
                                    CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego()));
                                    //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                                    //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                            }
                    } 
                  }
                }
            }
        }
        if(salonButton.isSelected()){
            for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
                if(entry.getValue().getName().equalsIgnoreCase(miastoOrSalon)|| miastoOrSalon == ""){
                  for(Vechicle car : entry.getValue().getCars()){
                    if((car.getMarka().equalsIgnoreCase(marka) || marka == "") && (car.getModel().equalsIgnoreCase(model) || model == "") && (kondycja.equalsIgnoreCase(car.getItemCondition().toString()) || kondycja == "")){
                        if((car.getPojemnoscSilnika() >= pojemnoscOd || pojemnoscOd == -1) && (car.getPojemnoscSilnika() <= pojemnoscDo || pojemnoscDo == -1))
                            if((car.getRokProdukcji() >= rokOd || rokOd == -1) && (car.getRokProdukcji() <= rokDo || rokDo == -1)){
                                if((car.getCena() >= minPrice || minPrice == -1) && (car.getCena() <= maxPrice || maxPrice == -1))
                                     //      THIS CAR FITS SEARCH        //
                                      CarTable.getItems().add(new TableVechicle(car.getMarka(),car.getModel(),car.getItemCondition().toString(),car.getIlosc(),car.getCena(),car.getRokProdukcji(),car.getPojemnoscSilnika(),entry.getValue().getName(),entry.getValue().getMiasto(),car.isZarezerwowane(),car.getPrzebieg(),car.getOpisSprzedajacego()));
                                    //CarTable.getItems().add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                                    //carsList.add(new TableVechicle(new SimpleStringProperty(car.getMarka()), new SimpleStringProperty(car.getModel()),new SimpleStringProperty(car.getItemCondition().toString()), new SimpleDoubleProperty(car.getCena()), new SimpleIntegerProperty(car.getRokProdukcji()), new SimpleDoubleProperty(car.getPojemnoscSilnika())));
                            }
                    } 
                  }
                }
            }
        }
    }
    
    @FXML
    private void zarezerwuj(){
        TableVechicle tmp = CarTable.getSelectionModel().getSelectedItem();
        if(!tmp.getZarezerwowaneColumn().equals("true")){
            tmp.setZarezerwowaneColumn(true);
            int index = -1;
            for(int i = 0;i < carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().size();++i){
               if( carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().get(i).compareToDetailed(new Vechicle(tmp.getMarkaColumn(),tmp.getModelColumn(),ItemCondition.valueOf(tmp.getItemConditionColumn()),Integer.valueOf(tmp.getIloscColumn()),Double.valueOf(tmp.getCenaColumn()),Integer.valueOf(tmp.getRokProdukcjiColumn()),Double.valueOf(tmp.getPojemnoscSilnikaColumn()),Boolean.valueOf(tmp.getZarezerwowaneColumn()),tmp.getPrzebieg(),tmp.getOpisSprzedajacego())) == 0){
                   index = i;
               }
            }
            if(carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getNumOfCars() == 1){
                index = 0;
            }
            //int index = carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().
            carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().get(index).setZarezerwowane(true);
            carsList.get(CarTable.getSelectionModel().getSelectedIndex()).setZarezerwowaneColumn(true);
           
            try {
            FileOutputStream fileOut = new FileOutputStream("carShowroomContainer.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(carShowroomContainer);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        }
        else{
            errorLabel.setText("Samochód już zarezerwowany");
        }        
        
    }
    
    @FXML
    private void zakup(){
        TableVechicle tmp = CarTable.getSelectionModel().getSelectedItem();
        if(!tmp.getZarezerwowaneColumn().equals("true")){
            int index = -1;
            
            for(int i = 0;i < carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().size();++i){
               if( carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().get(i).compareToDetailed(new Vechicle(tmp.getMarkaColumn(),tmp.getModelColumn(),ItemCondition.valueOf(tmp.getItemConditionColumn()),Integer.valueOf(tmp.getIloscColumn()),Double.valueOf(tmp.getCenaColumn()),Integer.valueOf(tmp.getRokProdukcjiColumn()),Double.valueOf(tmp.getPojemnoscSilnikaColumn()),Boolean.valueOf(tmp.getZarezerwowaneColumn()),tmp.getPrzebieg(),tmp.getOpisSprzedajacego())) == 0){
                   index = i;
               }
            }
            if(carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getNumOfCars() == 1){
                index = 0;
            }
            if(Integer.valueOf(tmp.getIloscColumn()) > 1){
                carsList.get(CarTable.getSelectionModel().getSelectedIndex()).setIloscColumn(Integer.valueOf(carsList.get(CarTable.getSelectionModel().getSelectedIndex()).getIloscColumn()) - 1);
                carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().get(index).setIlosc(Integer.valueOf(carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().get(index).getIlosc()) - 1);
            }else{
                carsList.remove(CarTable.getSelectionModel().getSelectedIndex());
                carShowroomContainer.getCarDealers().get(tmp.getSalonColumn()).getCars().remove(index);
                
            }
            
            try {
            FileOutputStream fileOut = new FileOutputStream("carShowroomContainer.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(carShowroomContainer);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
            boolean add = false;
            ///         MARKA         ///
            List <String> marki = new ArrayList<>();
            List <String> modele = new ArrayList<>();
        
            //          THROUGH EVERY DEALER            //
            for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
                //      THROUGH EVERY CAR       //
                for(Vechicle car : entry.getValue().getCars()){
                    //      THROUGH LISTS       //
                    for(int v = 0;v < marki.size() ; ++v){
                        //      MARKA       //
                        if(car.getMarka().equalsIgnoreCase(marki.get(v))){
                            add = false;
                            break;
                        }
                        else
                            add = true;
                    }
                    if(marki.size() == 0){
                        marki.add(car.getMarka());  
                    }
                    if(add){
                        marki.add(car.getMarka());
                    }
                }
            }
        add = false;
        
        marki.add("Marka");
            MarkaComboBox.getItems().clear();
            for(String s : marki){
                 MarkaComboBox.getItems().add(s);
            }
        }
        else{
            errorLabel.setText("Samochód już zarezerwowany");
        }
        
    }
    
    public ObservableList<TableVechicle> getData(){
        return carsList;
    }
    
    
    @FXML
    public void saveToFavourites(){
        TableVechicle tmp = CarTable.getSelectionModel().getSelectedItem();
        VechicleSerializable tmpVS = new VechicleSerializable(tmp.getMiastoColumn(),tmp.getSalonColumn(),tmp.getMarkaColumn(), tmp.getModelColumn(),ItemCondition.valueOf(tmp.getItemConditionColumn()), Integer.valueOf(tmp.getIloscColumn()), Double.valueOf(tmp.getCenaColumn()), Integer.valueOf(tmp.getRokProdukcjiColumn()), Double.valueOf(tmp.getPojemnoscSilnikaColumn()), Boolean.valueOf(tmp.getZarezerwowaneColumn()), tmp.getPrzebieg(), tmp.getOpisSprzedajacego());
           
        try {
            FileInputStream fileIn = new FileInputStream("savedCars.csv");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            savedCars = (ArrayList<VechicleSerializable>) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
            
        savedCars.add(tmpVS);
        try {
            FileOutputStream fileOut = new FileOutputStream("savedCars.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savedCars);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }        
    
    @FXML
    public void showFavourites(){
        try {
            //DESERIALIZATION
            
            //FileInputStream fileIn = new FileInputStream("car.csv");
            FileInputStream fileIn = new FileInputStream("savedCars.csv");
            ObjectInputStream in = new ObjectInputStream(fileIn);
           
            try {
                savedCars = (List<VechicleSerializable>) in.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        CarTable.getItems().clear();
        for(VechicleSerializable car : savedCars){
            CarTable.getItems().add(car.toTableVechicle());
        }
       
    }        
    
    @FXML
    public void deleteSelected(){
        TableVechicle tmp = CarTable.getSelectionModel().getSelectedItem();

        for(int i = 0; i < savedCars.size(); ++i){
            if(savedCars.get(i).isEqual(tmp)){
                savedCars.remove(i);
            }
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("savedCars.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savedCars);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eksportUlubionych(){
        ExcelCarsIO io = new ExcelCarsIO(savedCars);
        io.saveCarsToExcelFile("favouriteCars.csv");
    }
    
    public void eksportZawartoscSalonu(){
        String salonName = SalonComboBox.getValue();
        for(Map.Entry<String,CarShowroom> entry : carShowroomContainer.getCarDealers().entrySet()){
            if(entry.getValue().getName().equalsIgnoreCase(salonName)){
                ExcelCarShowroomIO io = new ExcelCarShowroomIO(entry.getValue());
                io.saveCarShowroomToExcelFile(salonName.concat(".csv"));
            }
        }
    }
    
    public void importCarShowroom() throws IOException{
        TextField text = new TextField();
        Shareable sh = new Shareable();
        sh.setText("");
        App.setRoot("importWindow");
        /*while(true){
            if(!sh.getText().equals("")){
                break;
            }
        }*/
        //ExcelCarShowroomIO io = new ExcelCarShowroom("import")
    }
    
    public void addToCarShowroom(){
        Shareable sh = new Shareable();
        ExcelCarShowroomIO io = new ExcelCarShowroomIO(sh.getText());
        carShowroomContainer.addCenter(io.getCarShowroom().getName(),io.getCarShowroom());
        
        try {
            FileOutputStream fileOut = new FileOutputStream("carShowroomContainer.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(carShowroomContainer);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void importFavourites() throws IOException{
        TextField text = new TextField();
        Shareable sh = new Shareable();
        sh.setText("");
        App.setRoot("importWindow");
    }
    
    public void addToFavourites(){
        try {
            Shareable sh = new Shareable();
            ExcelCarsIO io = new ExcelCarsIO(sh.getText());
            for(VechicleSerializable vs : io.getCars()){
                savedCars.add(vs);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("savedCars.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savedCars);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    ObservableList<TableVechicle> carsList = FXCollections.observableArrayList(); 
    ObservableList<String> marka = FXCollections.observableArrayList();
    ObservableList<String> model = FXCollections.observableArrayList();
    ObservableList<String> condition = FXCollections.observableArrayList();
    ObservableList<String> miasto = FXCollections.observableArrayList();
    ObservableList<String> salon = FXCollections.observableArrayList();
    
    private Map<String, CarShowroom> carShowroomMap = new HashMap();
    private CarShowroomContainer carShowroomContainer = new CarShowroomContainer(carShowroomMap);
    
    @FXML
    private ComboBox <String> KondycjaComboBox;// = new ComboBox(condition);
    
    @FXML
    private ComboBox <String> ModelComboBox;// = new ComboBox(model);
    
    @FXML
    private ComboBox <String> MarkaComboBox;// = new ComboBox(marka);

     @FXML
     private TextField cenaOd;
     
     @FXML
     private TextField cenaDo;
     
     @FXML
     private RadioButton MiastoButton;
     
     @FXML
     private RadioButton salonButton;
    
     @FXML
     private ComboBox <String> MiastoComboBox;
     
     @FXML
     private ComboBox <String> SalonComboBox;
     
     @FXML
     private Button SzukajButton;
     
     @FXML
     private TextField PojemnośćOd;
     
     @FXML
     private TextField PojemnośćDo;
     
     @FXML
     private TextField RokOd;
     
     @FXML
     private TextField RokDo;
     
     @FXML
     private TableView<TableVechicle> CarTable;
     
     @FXML
     private TableColumn<TableVechicle,String> MarkaColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> ModelColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> KondycjaColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> IloscColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> CenaColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> RokProdukcjiColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> PojemnoscSilnikaColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> SalonColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> MiastoColumn;
     
     @FXML
     private TableColumn<TableVechicle,String> ZarezerwowaneColumn;
     
     //@FXML
     private Tooltip toolTip;
  
     @FXML
     private RadioButton ExtraSearchButton;
     
     @FXML
     private RadioButton ExtraCarInfoButton;
     
     @FXML
     private Label errorLabel;
    
    @FXML
    private Button zakupButton;
    
    @FXML
    private Menu menu;
    
    @FXML
    private MenuItem showSavedItems;
    
    @FXML
    private MenuItem saveToFavourites;
    
    @FXML
    private MenuItem deleteSelected;        
    
    @FXML
    private MenuItem eksportZawartoscSalonu;
    
    @FXML
    private MenuItem eksportUlubionych;
    
    @FXML
    private Menu importMenu;
    
    @FXML
    private MenuItem importUlubione;
    
    @FXML
    private MenuItem importCarShowroom;
    
    @FXML
    private MenuItem reallyImportCarShowroom; 
    
    @FXML
    private MenuItem reallyImportFavourites;
    
    List<VechicleSerializable> savedCars;
}
