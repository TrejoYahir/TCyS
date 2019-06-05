/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyc.ui;

import com.tyc.utils.AudioManager;
import com.tyc.utils.Plotter;
import com.tyc.utils.AudioRecorder;

/**
 *
 * @author Yahir
 */
public class Recorder extends javax.swing.JFrame {

    Thread recorder;
    public Recorder() {
        initComponents();
        btnPlayInput.setEnabled(false);
        btnPlayOutput.setEnabled(false);
        btnStop.setEnabled(false);
        btnPlotInput.setEnabled(false);
        btnPlotOutput.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPlotInput = new javax.swing.JButton();
        btnPlayInput = new javax.swing.JButton();
        btnPlotOutput = new javax.swing.JButton();
        btnPlayOutput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setText("Grabar");
        btnStart.setActionCommand("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Detener");
        btnStop.setActionCommand("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnPlotInput.setText("Graficar entrada");
        btnPlotInput.setActionCommand("PlotInput");
        btnPlotInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlotInputActionPerformed(evt);
            }
        });

        btnPlayInput.setActionCommand("PlayInput");
        btnPlayInput.setLabel("Reproducir entrada");
        btnPlayInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayInputActionPerformed(evt);
            }
        });

        btnPlotOutput.setText("Graficar salida");
        btnPlotOutput.setActionCommand("PlotOutput");
        btnPlotOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlotOutputActionPerformed(evt);
            }
        });

        btnPlayOutput.setText("Reproducir salida");
        btnPlayOutput.setActionCommand("PlayOutput");
        btnPlayOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPlotOutput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPlotInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlayInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPlayOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlotInput)
                    .addComponent(btnPlayInput))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlotOutput)
                    .addComponent(btnPlayOutput))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        btnPlotInput.getAccessibleContext().setAccessibleName("PlotInput");
        btnPlayInput.getAccessibleContext().setAccessibleName("PlayInput");
        btnPlotOutput.getAccessibleContext().setAccessibleName("btnPlotOutput");
        btnPlayOutput.getAccessibleContext().setAccessibleName("btnPlayOutput");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        recorder = new Thread(new AudioRecorder());
        recorder.start();
        btnStart.setEnabled(false);
        btnPlayInput.setEnabled(false);
        btnPlotInput.setEnabled(false);
        btnStop.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        recorder.stop();
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnPlotInput.setEnabled(true);
        btnPlayInput.setEnabled(true);
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPlotInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlotInputActionPerformed
        System.out.println("Leyendo el archivo de audio");
        double[] data = AudioManager.read("Grabacion.wav");
        
        Plotter plotter = new Plotter("Gráfica de audio", data);
        plotter.plotAudio();
        PlotDisplay p = new PlotDisplay();
    }//GEN-LAST:event_btnPlotInputActionPerformed

    private void btnPlayInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayInputActionPerformed
        btnPlayInput.setEnabled(false);
        AudioManager.play("Grabacion.wav");
        btnPlayInput.setEnabled(true);
    }//GEN-LAST:event_btnPlayInputActionPerformed

    private void btnPlotOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlotOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlotOutputActionPerformed

    private void btnPlayOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayOutputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Recorder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayInput;
    private javax.swing.JButton btnPlayOutput;
    private javax.swing.JButton btnPlotInput;
    private javax.swing.JButton btnPlotOutput;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    // End of variables declaration//GEN-END:variables
}
