/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import com.mycompany.mavenproject1.fromlab2.ItemCondition;
import com.mycompany.mavenproject1.fromlab2.Vechicle;
import com.mycompany.mavenproject1.fromlab2.VechicleSerializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Kamil
 */
public class ExcelCarsIO {
    private List<VechicleSerializable> cars;

    public List<VechicleSerializable> getCars() {
        return cars;
    }

    public void setCars(List<VechicleSerializable> cars) {
        this.cars = cars;
    }
    
    
    
    public ExcelCarsIO(List<VechicleSerializable> cars) {
        this.cars = cars;
    }

    public ExcelCarsIO(String nameOfFile) throws IOException {
        cars = new ArrayList<>();
        XSSFWorkbook workbook = null; 
        try {
            FileInputStream fileIn = new FileInputStream(nameOfFile);
            workbook = new XSSFWorkbook(fileIn);
            XSSFSheet carsSheet = workbook.getSheet("Cars");
            boolean first = true;
            Row row = carsSheet.getRow(0);
            Cell cell = row.getCell(1);
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
                    int ilosc = (int) cell.getNumericCellValue();
                    cell = row.getCell(4);
                    double cena = cell.getNumericCellValue();
                    cell = row.getCell(5);
                    int rokProdukcji = (int) cell.getNumericCellValue();
                    cell = row.getCell(6);
                    double pojemnoscSilnika = cell.getNumericCellValue();
                    cell = row.getCell(7);
                    boolean zarezerwowane = cell.getBooleanCellValue();
                    cell = row.getCell(8);
                    int przebieg = (int) cell.getNumericCellValue();
                    cell = row.getCell(9);
                    String opis =  cell.getStringCellValue();
                    cell = row.getCell(10);
                    String miasto = cell.getStringCellValue();
                    cell = row.getCell(11);
                    String salon = cell.getStringCellValue();
                    VechicleSerializable tmp = new VechicleSerializable(miasto,salon,marka,model,ItemCondition.valueOf(condition),ilosc,cena,rokProdukcji,pojemnoscSilnika,zarezerwowane,przebieg,opis);
                    cars.add(tmp);
                }
            } 
            workbook.close();
        }    
        catch(Exception e){
            System.err.println(e);
        }
        
    }
    
    public void saveCarsToExcelFile(String nameOfFile){
        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet carsSheet = workbook.createSheet("Cars");
        Row row = carsSheet.createRow(0);
        Cell cell = row.createCell(0);
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
        
        cell = row.createCell(10);
        cell.setCellValue("Miasto");
        
        cell = row.createCell(11);
        cell.setCellValue("Salon");
        
        int counter = 1;
        for(VechicleSerializable v : cars){
            row = carsSheet.createRow(counter);
            
            cell = row.createCell(0);
            cell.setCellValue(v.getMarka());
        
            cell = row.createCell(1);
            cell.setCellValue(v.getModel());
        
            cell = row.createCell(2);
            cell.setCellValue(v.getItemCondition().toString());
        
            cell = row.createCell(3);
            cell.setCellValue((v.getIlosc()));
        
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
            
            cell = row.createCell(10);
            cell.setCellValue(v.getMiasto());
            
            cell = row.createCell(11);
            cell.setCellValue(v.getSalon());
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
