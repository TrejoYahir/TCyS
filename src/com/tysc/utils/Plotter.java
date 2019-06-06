/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tysc.utils;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yahir
 */
public class Plotter {
    
    private final double[] data;

    public Plotter(double[] data) {
        this.data = data;
    }
    
    public void plotAudio(String suffix) {
        final ExecutorService executorService = Executors.newFixedThreadPool(8);
        
        double[] data1 = Arrays.copyOfRange(data, 0, data.length/8-1);
        final Future<Void> res1 = executorService.submit(new PlotterTask("plot1-" + suffix, data1));
        
        double[] data2 = Arrays.copyOfRange(data, data.length/8, 2*data.length/8-1);
        final Future<Void> res2 = executorService.submit(new PlotterTask("plot2-" + suffix, data2));
        
        double[] data3 = Arrays.copyOfRange(data, 2*data.length/8, 3*data.length/8-1);
        final Future<Void> res3 = executorService.submit(new PlotterTask("plot3-" + suffix, data3));
        
        double[] data4 = Arrays.copyOfRange(data, 3*data.length/8, 4*data.length/8-1);
        final Future<Void> res4 = executorService.submit(new PlotterTask("plot4-" + suffix, data4));
        
        double[] data5 = Arrays.copyOfRange(data, 4*data.length/8, 5*data.length/8-1);
        final Future<Void> res5 = executorService.submit(new PlotterTask("plot5-" + suffix, data5));
        
        double[] data6 = Arrays.copyOfRange(data, 5*data.length/8, 6*data.length/8-1);
        final Future<Void> res6 = executorService.submit(new PlotterTask("plot6-" + suffix, data6));
        
        double[] data7 = Arrays.copyOfRange(data, 6*data.length/8, 7*data.length/8-1);
        final Future<Void> res7 = executorService.submit(new PlotterTask("plot7-" + suffix, data7));
        
        double[] data8 = Arrays.copyOfRange(data, 7*data.length/8, data.length-1);
        final Future<Void> res8 = executorService.submit(new PlotterTask("plot8-" + suffix, data8));
        
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plotter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Graficas generadas");
        
    }
    
}