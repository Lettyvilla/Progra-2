package proyecto;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class Formulas {
    
    Workbook wb = new HSSFWorkbook();
    
    public void creandoFormulas (){
        Sheet sheet = wb.createSheet("Formulas");
        
        Cell cell = sheet.createRow(0).createCell(0);
        Cell cell2 = sheet.createRow(0).createCell(1);
        Cell cell3 = sheet.createRow(0).createCell(2);
        Cell cell4 = sheet.createRow(0).createCell(3);
        Cell cell5 = sheet.createRow(0).createCell(4);
        Cell cell6 = sheet.createRow(1).createCell(0);
        Cell cell7 = sheet.createRow(2).createCell(0);
        Cell cell8 = sheet.createRow(3).createCell(0);
        Cell cell9 = sheet.createRow(4).createCell(0);
        Cell cell10 = sheet.createRow(5).createCell(0);
        Cell cell11= sheet.createRow(6).createCell(0);
        Cell cell12= sheet.createRow(7).createCell(0);
        Cell cell13= sheet.createRow(8).createCell(0);
        Cell cell14= sheet.createRow(9).createCell(0);
        Cell cell15= sheet.createRow(10).createCell(0);
        
        cell.setCellValue("Proceso");
        cell2.setCellValue("Minimo");
        cell3.setCellValue("Maximo");
        cell4.setCellValue("Promedio");
        cell5.setCellValue("Perceptil");
        cell6.setCellValue("DISKREAD");
        cell7.setCellValue("DISKERITE");
        cell8.setCellValue("DISKTRANSFER");
        cell9.setCellValue("PROCESSORTIME");
        cell10.setCellValue("USERTIME");
        cell11.setCellValue("PRIVILIGEDTIME");
        cell12.setCellValue("NETWORKIN");
        cell13.setCellValue("NETWORKPOUT");
        cell14.setCellValue("NETWORKTOTAL");
        cell15.setCellValue("MEMORYUSED");
        
              
        try{
            FileOutputStream output = new FileOutputStream ("Formulas.xls");
            wb.write(output);
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
