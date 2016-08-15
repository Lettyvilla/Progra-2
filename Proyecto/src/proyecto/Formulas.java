package proyecto;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class Formulas {
    
    Workbook wb = new HSSFWorkbook();
    
    
    public void Creando (){
        
      
        Sheet sheet0 = wb.createSheet("copy");
        
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
        
        Cell DISKREAD1= sheet.createRow(1).createCell(1);
        Cell DISKREAD2= sheet.createRow(1).createCell(2);
        Cell DISKREAD3= sheet.createRow(1).createCell(3);
        Cell DISKREAD4= sheet.createRow(1).createCell(4);
        Cell DISKERITE1= sheet.createRow(2).createCell(1);
        Cell DISKERITE2= sheet.createRow(2).createCell(2);
        Cell DISKERITE3= sheet.createRow(2).createCell(3);
        Cell DISKERITE4= sheet.createRow(2).createCell(4);
        Cell DISKTRANSFER1= sheet.createRow(3).createCell(1);
        Cell DISKTRANSFER2= sheet.createRow(3).createCell(2);
        Cell DISKTRANSFER3= sheet.createRow(3).createCell(3);
        Cell DISKTRANSFER4= sheet.createRow(3).createCell(4);
        Cell PROCESSORTIME1= sheet.createRow(4).createCell(1);
        Cell PROCESSORTIME2= sheet.createRow(4).createCell(2);
        Cell PROCESSORTIME3= sheet.createRow(4).createCell(3);
        Cell PROCESSORTIME4= sheet.createRow(4).createCell(4);
        Cell USERTIME1= sheet.createRow(5).createCell(1);
        Cell USERTIME2= sheet.createRow(5).createCell(2);
        Cell USERTIME3= sheet.createRow(5).createCell(3);
        Cell USERTIME4= sheet.createRow(5).createCell(4);
        Cell PRIVILIGEDTIME1= sheet.createRow(6).createCell(1);
        Cell PRIVILIGEDTIME2= sheet.createRow(6).createCell(2);
        Cell PRIVILIGEDTIME3= sheet.createRow(6).createCell(3);
        Cell PRIVILIGEDTIME4= sheet.createRow(6).createCell(4);
        Cell NETWORKIN1= sheet.createRow(7).createCell(1);
        Cell NETWORKIN2= sheet.createRow(7).createCell(2);
        Cell NETWORKIN3= sheet.createRow(7).createCell(3);
        Cell NETWORKIN4= sheet.createRow(7).createCell(4);
        Cell NETWORKPOUT1= sheet.createRow(8).createCell(1);
        Cell NETWORKPOUT2= sheet.createRow(8).createCell(2);
        Cell NETWORKPOUT3= sheet.createRow(8).createCell(3);
        Cell NETWORKPOUT4= sheet.createRow(8).createCell(4);
        Cell NETWORKTOTAL1= sheet.createRow(9).createCell(1);
        Cell NETWORKTOTAL2= sheet.createRow(9).createCell(2);
        Cell NETWORKTOTAL3= sheet.createRow(9).createCell(3);
        Cell NETWORKTOTAL4= sheet.createRow(9).createCell(4);
        Cell MEMORYUSED1= sheet.createRow(10).createCell(1);
        Cell MEMORYUSED2= sheet.createRow(10).createCell(2);
        Cell MEMORYUSED3= sheet.createRow(10).createCell(3);
        Cell MEMORYUSED4= sheet.createRow(10).createCell(4);
        
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
       
      
        DISKREAD2.setCellFormula("MAX('C:"+"\\"+"Users"+"\\"+"villalle.AUTH"+"\\"+"Documents"+"\\"+"NetBeansProjects"+"\\"+"Progra-2"
                + "\\"+"Proyecto"+"\\"+"[distribucionDatos.csv]distribucionDatos'!$C$2:$C$4)");
        
        
        try{
            FileOutputStream output = new FileOutputStream ("Formulas.xls");
            wb.write(output);
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

