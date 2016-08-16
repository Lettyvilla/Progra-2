package proyecto;

import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;

public class Grafico extends javax.swing.JFrame {

    public Grafico() {
        initComponents();
        configuracionVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplProcesador = new javax.swing.JPanel();
        rbtnSystemTime = new javax.swing.JRadioButton();
        rbtnIdleTime = new javax.swing.JRadioButton();
        rbtnUserTime = new javax.swing.JRadioButton();
        btnGraficarProcesador = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jplMemory = new javax.swing.JPanel();
        rbtnTotalMemory = new javax.swing.JRadioButton();
        rbtnUsedMemory = new javax.swing.JRadioButton();
        btnGraficarMemoria = new javax.swing.JButton();
        jplRed = new javax.swing.JPanel();
        rbtnNetIN = new javax.swing.JRadioButton();
        rbtnNetOut = new javax.swing.JRadioButton();
        rbtnNetTotal = new javax.swing.JRadioButton();
        btnGraficarRed = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jplProcesador.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesador"));

        rbtnSystemTime.setText("System Time");

        rbtnIdleTime.setText("Idle Time");
        rbtnIdleTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnIdleTimeActionPerformed(evt);
            }
        });

        rbtnUserTime.setText("User Time");
        rbtnUserTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnUserTimeActionPerformed(evt);
            }
        });

        btnGraficarProcesador.setText("Graficar");
        btnGraficarProcesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarProcesadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplProcesadorLayout = new javax.swing.GroupLayout(jplProcesador);
        jplProcesador.setLayout(jplProcesadorLayout);
        jplProcesadorLayout.setHorizontalGroup(
            jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplProcesadorLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficarProcesador)
                    .addComponent(rbtnIdleTime)
                    .addComponent(rbtnSystemTime)
                    .addComponent(rbtnUserTime))
                .addGap(21, 21, 21))
        );
        jplProcesadorLayout.setVerticalGroup(
            jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplProcesadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnSystemTime)
                .addGap(18, 18, 18)
                .addComponent(rbtnIdleTime)
                .addGap(18, 18, 18)
                .addComponent(rbtnUserTime)
                .addGap(18, 18, 18)
                .addComponent(btnGraficarProcesador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jplMemory.setBorder(javax.swing.BorderFactory.createTitledBorder("Memoria"));

        rbtnTotalMemory.setText("Memoria Instalada");
        rbtnTotalMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTotalMemoryActionPerformed(evt);
            }
        });

        rbtnUsedMemory.setText("Memoria en Uso");
        rbtnUsedMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnUsedMemoryActionPerformed(evt);
            }
        });

        btnGraficarMemoria.setText("Graficar");
        btnGraficarMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarMemoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplMemoryLayout = new javax.swing.GroupLayout(jplMemory);
        jplMemory.setLayout(jplMemoryLayout);
        jplMemoryLayout.setHorizontalGroup(
            jplMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplMemoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficarMemoria)
                .addGap(46, 46, 46))
            .addGroup(jplMemoryLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jplMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnUsedMemory)
                    .addComponent(rbtnTotalMemory))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jplMemoryLayout.setVerticalGroup(
            jplMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplMemoryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(rbtnTotalMemory)
                .addGap(18, 18, 18)
                .addComponent(rbtnUsedMemory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficarMemoria)
                .addContainerGap())
        );

        jplRed.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));

        rbtnNetIN.setText("MB In");

        rbtnNetOut.setText("MB Out");
        rbtnNetOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNetOutActionPerformed(evt);
            }
        });

        rbtnNetTotal.setText("MB Total");
        rbtnNetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNetTotalActionPerformed(evt);
            }
        });

        btnGraficarRed.setText("Graficar");
        btnGraficarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarRedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplRedLayout = new javax.swing.GroupLayout(jplRed);
        jplRed.setLayout(jplRedLayout);
        jplRedLayout.setHorizontalGroup(
            jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplRedLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficarRed)
                    .addComponent(rbtnNetOut)
                    .addComponent(rbtnNetIN)
                    .addComponent(rbtnNetTotal))
                .addGap(19, 19, 19))
        );
        jplRedLayout.setVerticalGroup(
            jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplRedLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(rbtnNetIN)
                .addGap(18, 18, 18)
                .addComponent(rbtnNetOut)
                .addGap(18, 18, 18)
                .addComponent(rbtnNetTotal)
                .addGap(18, 18, 18)
                .addComponent(btnGraficarRed)
                .addContainerGap())
        );

        jLabel1.setText("Grafico de datos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jplProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jplMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jplRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jplMemory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jplRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jplProcesador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnIdleTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnIdleTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnIdleTimeActionPerformed

    private void rbtnUserTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnUserTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnUserTimeActionPerformed

    private void rbtnUsedMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnUsedMemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnUsedMemoryActionPerformed

    private void rbtnNetOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNetOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnNetOutActionPerformed

    private void rbtnNetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNetTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnNetTotalActionPerformed

    private void rbtnTotalMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTotalMemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTotalMemoryActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGraficarProcesadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarProcesadorActionPerformed

        try {
            XYSeries SystmeTime = new XYSeries("System Time");
            XYSeries IdleTime = new XYSeries("Idle Time");
            XYSeries UserTime = new XYSeries("User Time");
            // Introduccion de datos
            Workbook leerExcel = Workbook.getWorkbook(new File("Metricas.xls"));
            Sheet pagina1 = leerExcel.getSheet(0);

            int filas = pagina1.getRows();
            int muestra = 0;
            for (int fila = 1; fila < filas; fila++) {
                SystmeTime.add(muestra, (Double.parseDouble(pagina1.getCell(4, fila).getContents())));
                UserTime.add(muestra, (Double.parseDouble(pagina1.getCell(5, fila).getContents())));
                IdleTime.add(muestra, (Double.parseDouble(pagina1.getCell(6, fila).getContents())));
                muestra++;
            }

            //Seleciona que graficar
            XYSeriesCollection dataset = new XYSeriesCollection();
            if (rbtnIdleTime.isSelected() && rbtnSystemTime.isSelected() && rbtnUserTime.isSelected()) {
                dataset.addSeries(IdleTime);
                dataset.addSeries(SystmeTime);
                dataset.addSeries(UserTime);
            } else if (rbtnIdleTime.isSelected() && rbtnSystemTime.isSelected()) {
                dataset.addSeries(IdleTime);
                dataset.addSeries(SystmeTime);
            } else if (rbtnSystemTime.isSelected() && rbtnUserTime.isSelected()) {
                dataset.addSeries(SystmeTime);
                dataset.addSeries(UserTime);
            } else if (rbtnIdleTime.isSelected() && rbtnUserTime.isSelected()) {
                dataset.addSeries(IdleTime);
                dataset.addSeries(UserTime);
            } else if (rbtnIdleTime.isSelected()) {
                dataset.addSeries(IdleTime);
            } else if (rbtnUserTime.isSelected()) {
                dataset.addSeries(UserTime);
            } else {
                dataset.addSeries(SystmeTime);
            }

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Grafico Porcesador", // Título del grafico
                    "Muestras", // Etiqueta Coordenada X
                    "Bytes por Segundo", // Etiqueta Coordenada Y
                    dataset, // Datos
                    PlotOrientation.VERTICAL,
                    true, // Muestra la leyenda de los procesos
                    false,
                    false
            );

            // Mostramos la grafica en pantalla
            ChartFrame frame = new ChartFrame("Grafico Procesador", chart);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGraficarProcesadorActionPerformed

    private void btnGraficarMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarMemoriaActionPerformed

        try {
            XYSeries MemoryInstalled = new XYSeries("Memoria Instalada");
            XYSeries MemoryUsed = new XYSeries("Memoria en Uso");

            // Introduccion de datos
            Workbook leerExcel = Workbook.getWorkbook(new File("Metricas.xls"));
            Sheet pagina1 = leerExcel.getSheet(0);

            int filas = pagina1.getRows();
            int muestra = 0;
            for (int fila = 1; fila < filas; fila++) {
                MemoryInstalled.add(muestra, (Double.parseDouble(pagina1.getCell(10, fila).getContents())));
                MemoryUsed.add(muestra, (Double.parseDouble(pagina1.getCell(11, fila).getContents())));

                muestra++;
            }

            //Seleciona que graficar
            XYSeriesCollection dataset = new XYSeriesCollection();
            if (rbtnTotalMemory.isSelected() && rbtnUsedMemory.isSelected()) {
                dataset.addSeries(MemoryInstalled);
                dataset.addSeries(MemoryUsed);
            } else if (rbtnTotalMemory.isSelected()) {
                dataset.addSeries(MemoryInstalled);
            } else {
                dataset.addSeries(MemoryUsed);
            }

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Grafico Memoria", // Título del grafico
                    "Muestras", // Etiqueta Coordenada X
                    "Megabytes", // Etiqueta Coordenada Y
                    dataset, // Datos
                    PlotOrientation.VERTICAL,
                    true, // Muestra la leyenda de los procesos
                    false,
                    false
            );

            // Mostramos la grafica en pantalla
            ChartFrame frame = new ChartFrame("Grafico Memoria", chart);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnGraficarMemoriaActionPerformed

    private void btnGraficarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarRedActionPerformed

        try {
            XYSeries NetworkIn = new XYSeries("Network IN");
            XYSeries NetworkOut = new XYSeries("Network OUT");
            XYSeries NetworkTotal = new XYSeries("Network Total");
            // Introduccion de datos
            Workbook leerExcel = Workbook.getWorkbook(new File("Metricas.xls"));
            Sheet pagina1 = leerExcel.getSheet(0);

            int filas = pagina1.getRows();
            int muestra = 0;
            for (int fila = 1; fila < filas; fila++) {
                NetworkIn.add(muestra, (Double.parseDouble(pagina1.getCell(7, fila).getContents())));
                NetworkOut.add(muestra, (Double.parseDouble(pagina1.getCell(8, fila).getContents())));
                NetworkTotal.add(muestra, (Double.parseDouble(pagina1.getCell(9, fila).getContents())));
                muestra++;
            }

            //Seleciona que graficar
            XYSeriesCollection dataset = new XYSeriesCollection();
            if (rbtnNetIN.isSelected() && rbtnNetOut.isSelected() && rbtnNetTotal.isSelected()) {
                dataset.addSeries(NetworkIn);
                dataset.addSeries(NetworkOut);
                dataset.addSeries(NetworkTotal);
            } else if (rbtnNetIN.isSelected() && rbtnNetOut.isSelected()) {
                dataset.addSeries(NetworkIn);
                dataset.addSeries(NetworkOut);
            } else if (rbtnNetIN.isSelected() && rbtnNetTotal.isSelected()) {
                dataset.addSeries(NetworkIn);
                dataset.addSeries(NetworkTotal);
            } else if (rbtnNetOut.isSelected() && rbtnNetTotal.isSelected()) {
                dataset.addSeries(NetworkOut);
                dataset.addSeries(NetworkTotal);
            } else if (rbtnNetIN.isSelected()) {
                 dataset.addSeries(NetworkIn);                
            } else if (rbtnNetOut.isSelected()) {
                dataset.addSeries(NetworkOut);                
            } else {
                dataset.addSeries(NetworkTotal);
            }

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Grafico Network", // Título del grafico
                    "Muestras", // Etiqueta Coordenada X
                    "Megabytes por Segundo", // Etiqueta Coordenada Y
                    dataset, // Datos
                    PlotOrientation.VERTICAL,
                    true, // Muestra la leyenda de los procesos
                    false,
                    false
            );

            // Mostramos la grafica en pantalla
            ChartFrame frame = new ChartFrame("Grafico Network", chart);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnGraficarRedActionPerformed

    private void configuracionVentana() {
        this.setTitle("Reporte por gráficos");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficarMemoria;
    private javax.swing.JButton btnGraficarProcesador;
    private javax.swing.JButton btnGraficarRed;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jplMemory;
    private javax.swing.JPanel jplProcesador;
    private javax.swing.JPanel jplRed;
    private javax.swing.JRadioButton rbtnIdleTime;
    private javax.swing.JRadioButton rbtnNetIN;
    private javax.swing.JRadioButton rbtnNetOut;
    private javax.swing.JRadioButton rbtnNetTotal;
    private javax.swing.JRadioButton rbtnSystemTime;
    private javax.swing.JRadioButton rbtnTotalMemory;
    private javax.swing.JRadioButton rbtnUsedMemory;
    private javax.swing.JRadioButton rbtnUserTime;
    // End of variables declaration//GEN-END:variables
}
