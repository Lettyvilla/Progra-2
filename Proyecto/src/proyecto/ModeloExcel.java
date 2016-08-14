package proyecto;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

        

public class ModeloExcel {

    Workbook wb = new HSSFWorkbook();
    
    
    
    public void creandoSheets (){
        Sheet sheet1 = wb.getSheet("distribucionDatos");
        Sheet sheet2 = wb.createSheet("Excel");
        try{
            FileOutputStream output = new FileOutputStream ("distribucionDatos.xls");
            wb.write(output);
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String CrearFormulas(File archivo, JTable tabla) {
        String respuesta = "No se pudo hacer el calculo";
        Sheet sheetFormulas = wb.createSheet();
        
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila = -1;
            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[5];
                int indiceColumna = -1;
                while (columnaIterator.hasNext()){
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if (indiceFila == 0){
                        modeloT.addColumn(celda.getStringCellValue());
                    } else {
                        if (celda != null){
                            switch (celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna [indiceColumna] = (int) Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna [indiceColumna] = celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna [indiceColumna] = celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna [indiceColumna] = celda.getDateCellValue();
                            }
                        }
                    }
                }
                if (indiceFila != 0) modeloT.addRow(listaColumna);
            }
            respuesta = "calculo exitoso";
        } catch (Exception e) {

        }

        return respuesta;
    }
    public String Exportar (File archivo, JTable tabla){
        String respuesta = "No se pueden mostrar los resultados";
        int numFila = tabla.getRowCount(), numColumna = tabla.getColumnCount();
        if (archivo.getName().endsWith(".lxs")){
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Excel");
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(i);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                    } else{
                        celda.setCellValue(String.valueOf(tabla.getValueAt(i, i)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta = "Resultado exitoso";
        } catch (Exception e) {
        }
        return respuesta;
    }
}
