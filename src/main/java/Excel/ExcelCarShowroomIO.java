/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import com.mycompany.mavenproject1.fromlab2.CarShowroom;
import com.mycompany.mavenproject1.fromlab2.ItemCondition;
import com.mycompany.mavenproject1.fromlab2.Vechicle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 *
 * @author Kamil
 */
public class ExcelCarShowroomIO {
    private CarShowroom carShowroom;

    public CarShowroom getCarShowroom() {
        return carShowroom;
    }

    public void setCarShowroom(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    
    public ExcelCarShowroomIO(String nameOfFile){
        //2 DO -> read CarShowroom from file
        carShowroom = new CarShowroom();
        //carShowroom.getCars() = new ArrayList<>();
           XSSFWorkbook workbook = null; 
        try {
            FileInputStream fileIn = new FileInputStream(nameOfFile);
            workbook = new XSSFWorkbook(fileIn);
            XSSFSheet infoSheet = workbook.getSheet("General info");
            XSSFSheet carsSheet = workbook.getSheet("Cars");
            boolean first = true;
            Row row = infoSheet.getRow(0);
            Cell cell = row.getCell(1);
            this.carShowroom.setName(cell.getStringCellValue());
            
            row = infoSheet.getRow(1);
            cell = row.getCell(1);
            this.carShowroom.setMiasto(cell.getStringCellValue());
            
            row = infoSheet.getRow(2);
            cell = row.getCell(1);
            this.carShowroom.setNumOfCars((int) cell.getNumericCellValue());
            
            row = infoSheet.getRow(3);
            cell = row.getCell(1);
            this.carShowroom.setMaxNumOfCars((int) cell.getNumericCellValue());
                            
           
            for (Iterator<Row> it = carsSheet.iterator(); it.hasNext();) {
                row = it.next();
                if(first){
                    first = false; 
                }
                else{
                    cell = row.getCell(0);
                    String marka = cell.getStringCellValue();
                    cell = row.getCell(1);
                    String model = cell.getStringCellValue();
                    cell = row.getCell(2);
                    String condition = cell.getStringCellValue();
                    cell = row.getCell(3);
                    int ilosc = (int)cell.getNumericCellValue(); 
                    cell = row.getCell(4);
                    double cena = cell.getNumericCellValue();
                    cell = row.getCell(5);
                    int rokProdukcji = (int)cell.getNumericCellValue();
                    cell = row.getCell(6);
                    double pojemnoscSilnika = cell.getNumericCellValue();
                    cell = row.getCell(7);
                    boolean zarezerwowane = cell.getBooleanCellValue();
                    cell = row.getCell(8);
                    int przebieg = (int) cell.getNumericCellValue();
                    cell = row.getCell(9);
                    String opis =  cell.getStringCellValue();
                    Vechicle tmp = new Vechicle(marka,model,ItemCondition.valueOf(condition),ilosc,cena,rokProdukcji,pojemnoscSilnika,zarezerwowane,przebieg,opis);
                    carShowroom.getCars().add(tmp);
                }
            }
         workbook.close();
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }    
    public ExcelCarShowroomIO(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }
    
    
    public void saveCarShowroomToExcelFile(String nameOfFile){
        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet infoSheet = workbook.createSheet("General info");
        XSSFSheet carsSheet = workbook.createSheet("Cars");
        
        //GENERAL INFO
        
        //name
        Row row = infoSheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Nazwa salonu");
        cell = row.createCell(1);
        cell.setCellValue(carShowroom.getName());
        //////
        //miasto
        row = infoSheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("Miasto");
        cell = row.createCell(1);
        cell.setCellValue(carShowroom.getMiasto());
        ////////
        //numOfCars
        row = infoSheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("Ilosc pojazdow");
        cell = row.createCell(1);
        cell.setCellValue(Integer.valueOf(carShowroom.getNumOfCars()));
        ///////////
        //maxNumOfCars
        row = infoSheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("Maksymalna ilosc pojazdow");
        cell = row.createCell(1);
        cell.setCellValue(Integer.valueOf(carShowroom.getMaxNumOfCars()));
        //////////////
        
        ///////////////////////////////
        
        //cars info
        row = carsSheet.createRow(0);
        
        cell = row.createCell(0);
        cell.setCellValue("Marka");
        
        cell = row.createCell(1);
        cell.setCellValue("Model");
        
        cell = row.createCell(2);
        cell.setCellValue("Condition");
        
        cell = row.createCell(3);
        cell.setCellValue("Ilosc");
        
        cell = row.createCell(4);
        cell.setCellValue("Cena");
        
        cell = row.createCell(5);
        cell.setCellValue("Rok produkcji");
        
        cell = row.createCell(6);
        cell.setCellValue("Pojemnosc silnika");
        
        cell = row.createCell(7);
        cell.setCellValue("Zarezerwowane");
        
        cell = row.createCell(8);
        cell.setCellValue("Przebieg");
        
        cell = row.createCell(9);
        cell.setCellValue("Opis sprzedajacego");
        
        int counter = 1;
        for(Vechicle v : carShowroom.getCars()){
            row = carsSheet.createRow(counter);
            
            cell = row.createCell(0);
            cell.setCellValue(v.getMarka());
        
            cell = row.createCell(1);
            cell.setCellValue(v.getModel());
        
            cell = row.createCell(2);
            cell.setCellValue(v.getItemCondition().toString());
        
            cell = row.createCell(3);
            cell.setCellValue(v.getIlosc());
            //cell.setCellValue(String.valueOf(v.getIlosc()));
        
            cell = row.createCell(4);
            cell.setCellValue((v.getCena()));
        
            cell = row.createCell(5);
            cell.setCellValue((v.getRokProdukcji()));
        
            cell = row.createCell(6);
            cell.setCellValue((v.getPojemnoscSilnika()));
        
            cell = row.createCell(7);
            cell.setCellValue((v.isZarezerwowane()));
        
            cell = row.createCell(8);
            cell.setCellValue((v.getPrzebieg()));
        
            cell = row.createCell(9);
            cell.setCellValue(v.getOpisSprzedajacego());
            counter++;
        }
        
        try (FileOutputStream outputStream = new FileOutputStream(nameOfFile)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
