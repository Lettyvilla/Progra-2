package proyecto;

public class Grafico extends javax.swing.JFrame {
    public Grafico() {
        initComponents();
        configuracionVentana();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplProcesador = new javax.swing.JPanel();
        rdnSystemTime = new javax.swing.JRadioButton();
        rdnIdleTime = new javax.swing.JRadioButton();
        rdnUserTime = new javax.swing.JRadioButton();
        btnGraficar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jplMemory = new javax.swing.JPanel();
        rdnTotalMemory = new javax.swing.JRadioButton();
        rdnUsedMemory = new javax.swing.JRadioButton();
        btnGraficar1 = new javax.swing.JButton();
        jplRed = new javax.swing.JPanel();
        rdnNetIN = new javax.swing.JRadioButton();
        rdnNetOut = new javax.swing.JRadioButton();
        rdnNetTotal = new javax.swing.JRadioButton();
        btnGraficar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jplProcesador.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesador"));

        rdnSystemTime.setText("System Time");

        rdnIdleTime.setText("Idle Time");
        rdnIdleTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnIdleTimeActionPerformed(evt);
            }
        });

        rdnUserTime.setText("User Time");
        rdnUserTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnUserTimeActionPerformed(evt);
            }
        });

        btnGraficar.setText("Graficar");

        javax.swing.GroupLayout jplProcesadorLayout = new javax.swing.GroupLayout(jplProcesador);
        jplProcesador.setLayout(jplProcesadorLayout);
        jplProcesadorLayout.setHorizontalGroup(
            jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplProcesadorLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficar)
                    .addComponent(rdnIdleTime)
                    .addComponent(rdnSystemTime)
                    .addComponent(rdnUserTime))
                .addGap(21, 21, 21))
        );
        jplProcesadorLayout.setVerticalGroup(
            jplProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplProcesadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdnSystemTime)
                .addGap(18, 18, 18)
                .addComponent(rdnIdleTime)
                .addGap(18, 18, 18)
                .addComponent(rdnUserTime)
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

        rdnTotalMemory.setText("Memoria Instalada");
        rdnTotalMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnTotalMemoryActionPerformed(evt);
            }
        });

        rdnUsedMemory.setText("Memoria en Uso");
        rdnUsedMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnUsedMemoryActionPerformed(evt);
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
                    .addComponent(rdnUsedMemory)
                    .addComponent(rdnTotalMemory))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jplMemoryLayout.setVerticalGroup(
            jplMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplMemoryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(rdnTotalMemory)
                .addGap(18, 18, 18)
                .addComponent(rdnUsedMemory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficar1)
                .addContainerGap())
        );

        jplRed.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));

        rdnNetIN.setText("MB In");

        rdnNetOut.setText("MB Out");
        rdnNetOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnNetOutActionPerformed(evt);
            }
        });

        rdnNetTotal.setText("MB Total");
        rdnNetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnNetTotalActionPerformed(evt);
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
                    .addComponent(rdnNetOut)
                    .addComponent(rdnNetIN)
                    .addComponent(rdnNetTotal))
                .addGap(19, 19, 19))
        );
        jplRedLayout.setVerticalGroup(
            jplRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplRedLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(rdnNetIN)
                .addGap(18, 18, 18)
                .addComponent(rdnNetOut)
                .addGap(18, 18, 18)
                .addComponent(rdnNetTotal)
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

    private void rdnIdleTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnIdleTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnIdleTimeActionPerformed

    private void rdnUserTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnUserTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnUserTimeActionPerformed

    private void rdnUsedMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnUsedMemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnUsedMemoryActionPerformed

    private void rdnNetOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnNetOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnNetOutActionPerformed

    private void rdnNetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnNetTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnNetTotalActionPerformed

    private void rdnTotalMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnTotalMemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnTotalMemoryActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose ();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void configuracionVentana() {
       this.setTitle("Reporte por gráficos");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnGraficar1;
    private javax.swing.JButton btnGraficar2;
    private javax.swing.JButton btnGraficar3;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jplMemory;
    private javax.swing.JPanel jplProcesador;
    private javax.swing.JPanel jplProcesador2;
    private javax.swing.JPanel jplRed;
    private javax.swing.JRadioButton rdnIdleTime;
    private javax.swing.JRadioButton rdnIdleTime2;
    private javax.swing.JRadioButton rdnNetIN;
    private javax.swing.JRadioButton rdnNetOut;
    private javax.swing.JRadioButton rdnNetTotal;
    private javax.swing.JRadioButton rdnSystemTime;
    private javax.swing.JRadioButton rdnSystemTime2;
    private javax.swing.JRadioButton rdnTotalMemory;
    private javax.swing.JRadioButton rdnUsedMemory;
    private javax.swing.JRadioButton rdnUserTime;
    private javax.swing.JRadioButton rdnUserTime2;
    // End of variables declaration//GEN-END:variables
}
