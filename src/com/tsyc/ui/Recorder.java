/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsyc.ui;

import com.tsyc.operations.BasicOperations;
import static com.tsyc.operations.BasicOperations.newRecording;
import com.tsyc.operations.Secuencia;
import com.tysc.utils.AudioManager;
import com.tysc.utils.Plotter;
import com.tysc.utils.AudioRecorder;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Yahir
 */
public class Recorder extends javax.swing.JFrame {

    Secuencia secuencia1;
    Secuencia secuencia2;
    
    Thread recorder;
    
    String lastAction;
    boolean hasRecording1 = false;
    boolean hasRecording2 = false;
    
    double[] input1;
    double[] input2;
    double[] output;

    public Recorder() {
        initComponents();
        btnPlayInput1.setEnabled(false);
        btnPlayInput2.setEnabled(false);
        btnPlayOutput.setEnabled(false);
        btnStop.setEnabled(false);
        btnPlotInput1.setEnabled(false);
        btnPlotInput2.setEnabled(false);
        btnPlotOutput.setEnabled(false);
        btnAmp.setEnabled(false);
        btnAtenuacion.setEnabled(false);
        btnDesplazamiento.setEnabled(false);
        btnReflejo.setEnabled(false);
        btnIntCero.setEnabled(false);
        btnIntEscalon.setEnabled(false);
        btnIntLineal.setEnabled(false);
        btnDiezmación.setEnabled(false);
        btnConvolucion.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRecord1 = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPlotInput1 = new javax.swing.JButton();
        btnPlayInput1 = new javax.swing.JButton();
        btnPlotOutput = new javax.swing.JButton();
        btnPlayOutput = new javax.swing.JButton();
        btnAmp = new javax.swing.JButton();
        btnAtenuacion = new javax.swing.JButton();
        btnDesplazamiento = new javax.swing.JButton();
        btnReflejo = new javax.swing.JButton();
        btnIntCero = new javax.swing.JButton();
        btnIntEscalon = new javax.swing.JButton();
        btnIntLineal = new javax.swing.JButton();
        btnDiezmación = new javax.swing.JButton();
        btnConvolucion = new javax.swing.JButton();
        btnSecuencias = new javax.swing.JButton();
        btnRecord2 = new javax.swing.JButton();
        btnPlotInput2 = new javax.swing.JButton();
        btnPlayInput2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRecord1.setText("Grabar Audio 1");
        btnRecord1.setActionCommand("Start");
        btnRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecord1ActionPerformed(evt);
            }
        });

        btnStop.setText("Detener");
        btnStop.setActionCommand("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnPlotInput1.setText("Graficar entrada 1");
        btnPlotInput1.setActionCommand("PlotInput");
        btnPlotInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlotInput1ActionPerformed(evt);
            }
        });

        btnPlayInput1.setText("Reproducir entrada 1");
        btnPlayInput1.setActionCommand("PlayInput");
        btnPlayInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayInput1ActionPerformed(evt);
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

        btnAmp.setText("Amplificación");
        btnAmp.setActionCommand("btnAmp");
        btnAmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmpActionPerformed(evt);
            }
        });

        btnAtenuacion.setText("Atenuación");
        btnAtenuacion.setActionCommand("Atenuacion");
        btnAtenuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenuacionActionPerformed(evt);
            }
        });

        btnDesplazamiento.setText("Desplazamiento");
        btnDesplazamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesplazamientoActionPerformed(evt);
            }
        });

        btnReflejo.setText("Reflejo");
        btnReflejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReflejoActionPerformed(evt);
            }
        });

        btnIntCero.setText("Interpolación Cero");
        btnIntCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntCeroActionPerformed(evt);
            }
        });

        btnIntEscalon.setText("Interpolación Escalón");
        btnIntEscalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntEscalonActionPerformed(evt);
            }
        });

        btnIntLineal.setText("Interpolación lineal");
        btnIntLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntLinealActionPerformed(evt);
            }
        });

        btnDiezmación.setText("Diezmación");
        btnDiezmación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiezmaciónActionPerformed(evt);
            }
        });

        btnConvolucion.setText("Convolución");
        btnConvolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvolucionActionPerformed(evt);
            }
        });

        btnSecuencias.setText("Ingresar Secuencias");
        btnSecuencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuenciasActionPerformed(evt);
            }
        });

        btnRecord2.setText("Grabar Audio 2");
        btnRecord2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecord2ActionPerformed(evt);
            }
        });

        btnPlotInput2.setText("Graficar entrada 2");
        btnPlotInput2.setMaximumSize(new java.awt.Dimension(105, 23));
        btnPlotInput2.setMinimumSize(new java.awt.Dimension(105, 23));
        btnPlotInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlotInput2ActionPerformed(evt);
            }
        });

        btnPlayInput2.setText("Reproducir entrada 2");
        btnPlayInput2.setMaximumSize(new java.awt.Dimension(105, 23));
        btnPlayInput2.setMinimumSize(new java.awt.Dimension(105, 23));
        btnPlayInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayInput2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSecuencias)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRecord2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIntCero, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnIntLineal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAmp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtenuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIntEscalon)
                                .addGap(18, 18, 18)
                                .addComponent(btnDiezmación, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDesplazamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReflejo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnConvolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPlotInput1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPlayInput1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPlayInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPlayOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPlotInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPlotOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSecuencias)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecord1)
                    .addComponent(btnRecord2)
                    .addComponent(btnStop))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlotInput1)
                    .addComponent(btnPlotInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlotOutput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlayInput1)
                    .addComponent(btnPlayOutput)
                    .addComponent(btnPlayInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAmp)
                    .addComponent(btnAtenuacion)
                    .addComponent(btnDesplazamiento)
                    .addComponent(btnReflejo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConvolucion)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIntCero)
                    .addComponent(btnIntLineal)
                    .addComponent(btnIntEscalon)
                    .addComponent(btnDiezmación))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        btnPlotInput1.getAccessibleContext().setAccessibleName("PlotInput");
        btnPlayInput1.getAccessibleContext().setAccessibleName("PlayInput");
        btnPlotOutput.getAccessibleContext().setAccessibleName("btnPlotOutput");
        btnPlayOutput.getAccessibleContext().setAccessibleName("btnPlayOutput");
        btnAmp.getAccessibleContext().setAccessibleName("Amp");
        btnAtenuacion.getAccessibleContext().setAccessibleName("Atenuacion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecord1ActionPerformed
        recorder = new Thread(new AudioRecorder("Grabacion.wav"));
        recorder.start();
        btnRecord1.setEnabled(false);
        btnRecord2.setEnabled(false);
        btnPlayInput1.setEnabled(false);
        btnPlotInput1.setEnabled(false);
        btnPlayInput2.setEnabled(false);
        btnPlotInput2.setEnabled(false);
        btnStop.setEnabled(true);
        
        toggleActions(false);
        
        lastAction = "recording";
        hasRecording1 = true;
    }//GEN-LAST:event_btnRecord1ActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        recorder.stop();
        if(lastAction.equals("recording") && hasRecording1) {
            btnPlotInput1.setEnabled(true);
            btnPlayInput1.setEnabled(true);
            input1 = AudioManager.read("Grabacion.wav");
        }
        if(lastAction.equals("recording") && hasRecording2) {
            btnPlotInput2.setEnabled(true);
            btnPlayInput2.setEnabled(true);
            input2 = AudioManager.read("Grabacion2.wav");
        }
        toggleActions(true);
        btnStop.setEnabled(false);
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPlotInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlotInput1ActionPerformed
        if(lastAction.equals("recording") && hasRecording1) {
            Plotter plotter = new Plotter(input1);
            plotter.plotAudio("input");
            PlotDisplay p = new PlotDisplay("input");
        } else {
            PlotInput chart = new PlotInput("Entrada 1", input1);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true ); 
        }
    }//GEN-LAST:event_btnPlotInput1ActionPerformed

    private void btnPlayInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayInput1ActionPerformed
        btnPlayInput1.setEnabled(false);
        AudioManager.play("Grabacion.wav");
        btnPlayInput1.setEnabled(true);
    }//GEN-LAST:event_btnPlayInput1ActionPerformed

    private void btnPlotOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlotOutputActionPerformed
        
        if(lastAction.equals("recording") && hasRecording1) {
            Plotter plotter = new Plotter(output);
            plotter.plotAudio("output");
            PlotDisplay p = new PlotDisplay("output");
        } else {
            PlotInput chart = new PlotInput("Salida", output);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true ); 
            chart.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }//GEN-LAST:event_btnPlotOutputActionPerformed

    private void btnPlayOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayOutputActionPerformed
        btnPlayOutput.setEnabled(false);
        AudioManager.play("NuevaGrabacion.wav");
        btnPlayOutput.setEnabled(true);
    }//GEN-LAST:event_btnPlayOutputActionPerformed

    private void btnAmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmpActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa la constante de amplificación", null);
        output = BasicOperations.amplificacion(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnAmpActionPerformed

    private void btnAtenuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenuacionActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa la constante de atenuación", null);
        output = BasicOperations.atenuacion(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnAtenuacionActionPerformed

    private void btnDesplazamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesplazamientoActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa los segundos a desplazar", null);
        output = BasicOperations.desplazamiento(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnDesplazamientoActionPerformed

    private void btnReflejoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReflejoActionPerformed
        output = BasicOperations.reflejo(input1);
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnReflejoActionPerformed

    private void btnIntCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntCeroActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa el factor de interpolación", null);
        
        output = BasicOperations.interpolacionCero(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnIntCeroActionPerformed

    private void btnIntEscalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntEscalonActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa el factor de interpolación", null);
        
        output = BasicOperations.interpolacionEscalon(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnIntEscalonActionPerformed

    private void btnIntLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntLinealActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa el factor de interpolación", null);
        
        output = BasicOperations.interpolacionLineal(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnIntLinealActionPerformed

    private void btnDiezmaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiezmaciónActionPerformed
        String k = JOptionPane.showInputDialog(this, "Ingresa el factor de diezmación", null);
        
        output = BasicOperations.diezmacion(input1, Integer.parseInt(k));
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnDiezmaciónActionPerformed

    private void btnConvolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvolucionActionPerformed
        if(lastAction.equals("recording")) {
            secuencia1 = new Secuencia(input1);
            secuencia2 = new Secuencia(input2);
        }
        
        Secuencia convolucion = secuencia1.convolucionar(secuencia2);
        output = convolucion.valores;
        
        JOptionPane.showMessageDialog(null, "Se aplicó convolución entre las secuancias 1 y 2");
        
        btnPlayOutput.setEnabled(true);
        btnPlotOutput.setEnabled(true);
    }//GEN-LAST:event_btnConvolucionActionPerformed
    private void btnSecuenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuenciasActionPerformed
        
        secuencia1 = userInput("Ingresa la primera secuencia");
        input1 = secuencia1.valores;
        
        System.out.println("Primera secuancia: " + Arrays.toString(input1));
        
        secuencia2 = userInput("Ingresa la segunda secuencia");
        input2 = secuencia2.valores;
        
        System.out.println("Segunda secuancia: " + Arrays.toString(input2));
        
        toggleActions(true);
        lastAction = "input";
        btnConvolucion.setEnabled(true);
        btnPlotInput1.setEnabled(true);
        btnPlotInput2.setEnabled(true);
    }//GEN-LAST:event_btnSecuenciasActionPerformed

    private void btnRecord2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecord2ActionPerformed
        recorder = new Thread(new AudioRecorder("Grabacion2.wav"));
        recorder.start();
        btnRecord1.setEnabled(false);
        btnRecord2.setEnabled(false);
        btnPlayInput1.setEnabled(false);
        btnPlotInput1.setEnabled(false);
        btnPlayInput2.setEnabled(false);
        btnPlotInput2.setEnabled(false);
        btnStop.setEnabled(true);
        toggleActions(false);
        lastAction = "recording";
        hasRecording2 = true;
    }//GEN-LAST:event_btnRecord2ActionPerformed

    private void btnPlotInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlotInput2ActionPerformed
        if(lastAction.equals("recording") && hasRecording2) {
            Plotter plotter = new Plotter(input2);
            plotter.plotAudio("input");
            PlotDisplay p = new PlotDisplay("input");
        } else {
            PlotInput chart = new PlotInput("Entrada 2", input2);
            chart.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true ); 
        }
    }//GEN-LAST:event_btnPlotInput2ActionPerformed

    private void btnPlayInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayInput2ActionPerformed
        btnPlayInput1.setEnabled(false);
        AudioManager.play("Grabacion2.wav");
        btnPlayInput1.setEnabled(true);
    }//GEN-LAST:event_btnPlayInput2ActionPerformed

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
    
    public void toggleActions(boolean state) {
        btnRecord1.setEnabled(state);
        btnRecord2.setEnabled(state);
        
        btnAmp.setEnabled(state);
        btnAtenuacion.setEnabled(state);
        btnDesplazamiento.setEnabled(state);
        btnReflejo.setEnabled(state);
        btnIntCero.setEnabled(state);
        btnIntEscalon.setEnabled(state);
        btnIntLineal.setEnabled(state);
        btnDiezmación.setEnabled(state);
        btnConvolucion.setEnabled(state);
    }
    
    public Secuencia userInput(String title) {
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Secuencia: "));
        myPanel.add(xField);
        myPanel.add(Box.createVerticalStrut(15));
        myPanel.add(new JLabel("¿Es periódica? S/N: "));
        myPanel.add(yField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                        title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            boolean periodica = yField.getText().equalsIgnoreCase("s");
            return new Secuencia(xField.getText(), periodica);
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmp;
    private javax.swing.JButton btnAtenuacion;
    private javax.swing.JButton btnConvolucion;
    private javax.swing.JButton btnDesplazamiento;
    private javax.swing.JButton btnDiezmación;
    private javax.swing.JButton btnIntCero;
    private javax.swing.JButton btnIntEscalon;
    private javax.swing.JButton btnIntLineal;
    private javax.swing.JButton btnPlayInput1;
    private javax.swing.JButton btnPlayInput2;
    private javax.swing.JButton btnPlayOutput;
    private javax.swing.JButton btnPlotInput1;
    private javax.swing.JButton btnPlotInput2;
    private javax.swing.JButton btnPlotOutput;
    private javax.swing.JButton btnRecord1;
    private javax.swing.JButton btnRecord2;
    private javax.swing.JButton btnReflejo;
    private javax.swing.JButton btnSecuencias;
    private javax.swing.JButton btnStop;
    // End of variables declaration//GEN-END:variables
}
