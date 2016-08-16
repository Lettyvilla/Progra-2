/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



/**
 *
 * @author Carlos
 */
public class Tabla extends javax.swing.JFrame {
    
    private DefaultTableModel modelo;
    public static int con =0;
    
    /**
     * Creates new form Tabla
     */
    public Tabla() {
        initComponents();
        configuracionVentana();
        
        modelo = new DefaultTableModel();
        jtDatos.setModel(modelo);
        
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnResultados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de Calculos");

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtDatos);
        if (jtDatos.getColumnModel().getColumnCount() > 0) {
            jtDatos.getColumnModel().getColumn(0).setResizable(false);
            jtDatos.getColumnModel().getColumn(1).setResizable(false);
            jtDatos.getColumnModel().getColumn(2).setResizable(false);
            jtDatos.getColumnModel().getColumn(3).setResizable(false);
        }

        btnSalir.setText("Volver ventana principal");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnResultados.setText("Resultados");
        btnResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(btnResultados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnSalir)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnResultados)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadosActionPerformed
        // TODO add your handling code here:
        JFileChooser buscar = new JFileChooser();
        buscar.setFileFilter(new FileNameExtensionFilter("Archivos",".xls"));
        int opcion = buscar.showOpenDialog(this);
        File archivoExcel = null;
            if (opcion == JFileChooser.APPROVE_OPTION){
                archivoExcel = buscar.getSelectedFile().getAbsoluteFile();
                try{
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    for (int pagina =1; pagina<leerExcel.getNumberOfSheets(); pagina++)
                    {
                        Sheet pagina1 = leerExcel.getSheet(pagina);
                        int columnas = pagina1.getColumns();
                        int filas = pagina1.getRows();
                        Object data[] = new Object [columnas];
                        for (int fila= 0; fila<filas; fila++){
                            for (int columna =0; columna<columnas; columna++){
                                if (fila==0){
                                    modelo.addColumn(pagina1.getCell(columna, fila).getContents());
                                }
                                System.out.println(pagina1.getCell(columna, fila).getContents());
                                if (fila>=1)
                                    data[columna] = pagina1.getCell(columna, fila).getContents();
                            }
                            modelo.addRow(data);
                        }
                    }
                    modelo.removeRow(0);
                }
                catch (IOException | BiffException ex){
                    Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        btnResultados.setEnabled(false);
    }//GEN-LAST:event_btnResultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResultados;
    private javax.swing.JButton btnSalir;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDatos;
    // End of variables declaration//GEN-END:variables

    private void configuracionVentana() {
       this.setTitle("Tabla de reportes");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
