/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Interfaz() {
        initComponents();
        configuracionVentana();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTabla = new javax.swing.JButton();
        btnGrafico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCaptura2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTabla.setText("Tabla");
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });

        btnGrafico.setText("Gráfico");
        btnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText(" Power Shell");

        btnCaptura2.setText("Captura");
        btnCaptura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptura2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaptura2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(btnCaptura2)
                .addGap(36, 36, 36)
                .addComponent(btnTabla)
                .addGap(18, 18, 18)
                .addComponent(btnGrafico)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        Tabla venTabla = new Tabla();
    }//GEN-LAST:event_btnTablaActionPerformed

    private void btnCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaActionPerformed

    }//GEN-LAST:event_btnCapturaActionPerformed

    private void btnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoActionPerformed
        Grafico venGrafico = new Grafico();
    }//GEN-LAST:event_btnGraficoActionPerformed

    private void btnCaptura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptura2ActionPerformed
        // TODO add your handling code here:
        CapturaDatos venCaptura = new CapturaDatos ();
        venCaptura.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnCaptura2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaptura2;
    private javax.swing.JButton btnGrafico;
    private javax.swing.JButton btnTabla;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void configuracionVentana() {
        this.setTitle("Proyecto-Progra 2");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
