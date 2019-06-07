/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsyc.operations;

import com.tysc.utils.AudioManager;
import javax.swing.JOptionPane;

/**
 *
 * @author itzel
 */
public class BasicOperations {
    
    // Amplificación. Multiplicamos las muestras por una constante k
    public static double[] amplificacion(double[] input, int k){
        double[] output = new double[input.length];
        for(int i=0; i < input.length; i++){
            output[i] = input[i]*k;
        }
        System.out.println("SE AMPLIFICÓ EL SONIDO");
        JOptionPane.showMessageDialog(null, "Se amplificó la secuancia 1");
        newRecording(output);
        return output;
    }
    
    // Atenuación. Dividimos las muestras entre una constante k
    public static double[] atenuacion(double[] input, int k){
        double[] output = new double[input.length];
        for(int i=0; i < input.length; i++){
            output[i] = input[i]/k;
        }
        System.out.println("SE ATENUÓ EL SONIDO");
        JOptionPane.showMessageDialog(null, "Se atenuó la secuancia 1");
        newRecording(output);
        return output;
    }
    
    // Desplazamiento. Recorremos las muestras s segundos
    public static double[] desplazamiento(double[] input, int s){
        double[] output = new double[input.length];
        
        float recordTime = AudioManager.getDuration("Grabacion.wav");
        System.out.println("Segundos a recorrer: " + s);
        
        if(recordTime >= s){
            float samplesPerSecond = input.length / recordTime;
            int startingPoint = (int) Math.floor(Math.abs(samplesPerSecond * s));
            
            System.out.println("Duración: " + recordTime);
            System.out.println("Cantidad de muestras: " + input.length);
            System.out.println("Muestras por segundo: " + samplesPerSecond);
            System.out.println("Muestra de inicio: " + startingPoint);
            
            if(s > 0){
                for (int i = 0, j = startingPoint; i < input.length; i++) {
                    if(i < input.length - startingPoint) {
                        output[i] = input[j++];
                    } else {
                        output[i] = 0;
                    }
                }
            } else {
                if(s == 0) {
                    System.arraycopy(input, 0, output, 0, input.length);
                } else {
                    for (int i = 0, j=0; i < input.length; i++) {
                        if(i < startingPoint){
                            output[i] = 0;
                        }else{
                            output[i] = input[j++];
                        }
                    }
                }
            }
            newRecording(output);
            return output;
        }else{
            System.out.println("No es posible ");
            return input;
        }
   
    }
    
    // Reflejo. Invertimos las muestras
    public static double[] reflejo(double[] input){
        double[] output = new double[input.length];
        for(int i=0; i < input.length; i++){
            output[(input.length-1) - i] = input[i];
        }        
        System.out.println("SE REFLEJÓ EL SONIDO");
        JOptionPane.showMessageDialog(null, "Se reflejó la secuancia 1");
        newRecording(output);
        return output;
    }
    
    // Dezmación. Quitamos muestras
    public static double[] diezmacion(double[] input, int k){
        int size = (input.length%k == 0) ? input.length/k : (input.length/k) + k;
        double output [] = new double[size];
        System.out.println("Tamano original: " + input.length);
        System.out.println("Nuevo tamano:  " + size);
        int j = 0;
        
        for (int i = 0; i < input.length; i++) {
            if(i%k == 0) {
                output[j] = input[i];
                j++;
            }
        }
        System.out.println("Recorrido " + j);
        System.out.println("SE APLICÓ LA DIEZMACIÓN");
        JOptionPane.showMessageDialog(null, "Se aplicó la diezmación a la secuancia 1");
        newRecording(output);
        return output;
    }
    
    // Interpolación cero. Agregamos muestras con valor cero
    public static double[] interpolacionCero(double[] input, int k){
        double[] output = new double[input.length*k];
        for(int i=0, j=0; i < input.length*k; i = i + k, j++){
            output[i] = input[j];
        }
        System.out.println("Tamaño original: " + input.length);
        System.out.println("Tamaño nuevo: " + output.length);
        System.out.println("SE APLICÓ INTERPOLACIÓN CERO");
        JOptionPane.showMessageDialog(null, "Se aplicó interpolación a cero a la secuancia 1");
        newRecording(output);
        return output;
    }
    
    // Interpolación cero. Agregamos muestras con valor igual al anterior
    public static double[] interpolacionEscalon(double[] input, int k){
        int cont = 0;
        double[] output = new double[input.length*k];
        for(int i=0, j=0; i < input.length * k; i = i + k, j++){
            output[i] = input[j];
            while(cont < k){
                output[i+cont] = input[j];
                cont++;
            }
            cont=0;
        }
        System.out.println("SE APLICÓ INTERPOLACIÓN ESCALÓN");
        JOptionPane.showMessageDialog(null, "Se aplicó interpolación escalón a la secuancia 1");
        System.out.println("Tamaño original: " + output.length);
        System.out.println("Tamaño nuevo: " + output.length);
        newRecording(output);
        return output;
    }
    
    // Interpolación cero. Agregamos muestras con valor calculado
    public static double[] interpolacionLineal(double[] input, int k){
        int cont = 1;
        double vi;
        double vf;
        double factor = 0;
        double[] output = new double[input.length*k];
        for(int i=0, j=0; i < input.length * k; i = i + k, j++){
            output[i] = input[j];
            vi = input[j];
            if(j+1 < input.length-1){
                vf = input[j+1];
                factor = calcularFactor(vi, vf, k);
            }
            while(cont < k){
                output[i+cont] = input[j] + factor;
                factor *= k;
                cont++;
            }
            cont=1;
        }
        System.out.println("SE APLICÓ INTERPOLACIÓN LINEAL");
        JOptionPane.showMessageDialog(null, "Se aplicó interpolación lineal a la secuancia 1");
        System.out.println("Tamaño original: " + input.length);
        System.out.println("Tamaño nuevo: " + output.length);
        newRecording(output);
        return output;
    }
    
    private static double calcularFactor(double i, double f, int k){
        double r = 0;
        if(f >= i){
            r = Math.abs(i - f) / (double) k;
        }else{
            r = (double) -1 * Math.abs(i - f) / (double) k;
        }
        return r;
    }
    
    public static void newRecording(double[] grabacion){
        AudioManager.save("NuevaGrabacion.wav", grabacion);
    }
}
