package proyecto;

import java.awt.Panel;
import java.util.Locale;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.jfree.chart.ChartFactory;
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
        btnGraficar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jplMemory = new javax.swing.JPanel();
        rbtnTotalMemory = new javax.swing.JRadioButton();
        rbtnUsedMemory = new javax.swing.JRadioButton();
        btnGraficar1 = new javax.swing.JButton();
        jplRed = new javax.swing.JPanel();
        rbtnNetIN = new javax.swing.JRadioButton();
        rbtnNetOut = new javax.swing.JRadioButton();
        rbtnNetTotal = new javax.swing.JRadioButton();
        btnGraficar3 = new javax.swing.JButton();
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

        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplProcesadorLayout = new javax.swing.GroupLayout(jplProcesador);
        jplProcesador.setLayout(jplProcesadorLayout);
        jplProcesadorLayout.setHorizontalGroup(
            jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplProcesadorLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficar)
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
                .addComponent(btnGraficar)
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

        btnGraficar1.setText("Graficar");

        javax.swing.GroupLayout jplMemoryLayout = new javax.swing.GroupLayout(jplMemory);
        jplMemory.setLayout(jplMemoryLayout);
        jplMemoryLayout.setHorizontalGroup(
            jplMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplMemoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficar1)
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
                .addComponent(btnGraficar1)
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

        btnGraficar3.setText("Graficar");

        javax.swing.GroupLayout jplRedLayout = new javax.swing.GroupLayout(jplRed);
        jplRed.setLayout(jplRedLayout);
        jplRedLayout.setHorizontalGroup(
            jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplRedLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficar3)
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
                .addComponent(btnGraficar3)
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
        this.dispose ();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        if (rbtnIdleTime.isSelected()&& rbtnSystemTime.isSelected()&& rbtnUserTime.isSelected()){
            new Graficar();
            XYSplineRenderer renderer = new XYSplineRenderer();
            XYSeriesCollection dataset = new XYSeriesCollection();

            ValueAxis x = new NumberAxis();
            ValueAxis y = new NumberAxis();

            XYSeries serie = new XYSeries("Datos");
            XYPlot plot;
            
            
        }
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void configuracionVentana() {
       this.setTitle("Reporte por gráficos");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnGraficar1;
    private javax.swing.JButton btnGraficar3;
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
