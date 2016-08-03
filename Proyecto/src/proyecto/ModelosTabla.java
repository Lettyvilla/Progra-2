/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Letty
 */
public class ModelosTabla extends AbstractTableModel {

    private ColeccionDatos myRefStats;

    private String[] encabezados = {"Server", "Min Disk", "Avg Disk",
        "Max Disk", "Min Pros", "Avg Pros","Max Pros","Min Mem", "Avg Mem","Max Mem",
        "Min Net", "Avg Net","Max Net"};

    public ModelosTabla(ColeccionDatos col) {
        myRefStats = col;
    }

    @Override
    public int getRowCount() {
        return myRefStats.contarDato();
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        ServerStat stat = myRefStats.obtenerDato(fila);
        switch (columna) {
            case 0:
                return stat.getServer();                
            case 1:
                return stat.getMinCPU();
            case 2:
                return stat.getAvgCPU();
            case 3:
                return stat.getMaxCPU();
            case 4:
                return stat.getMinMem();
            case 5:
                return stat.getAvgMem();
            case 6:
                return stat.getMaxMem();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int col) {
        return encabezados[col];
    }
}

