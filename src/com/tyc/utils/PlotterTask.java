/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyc.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Yahir
 */
public class PlotterTask implements Callable<Void> {

    private final String name;
    private final double[] data;

    public PlotterTask(String name, double[] data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public Void call() throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<data.length/8; i++){
            dataset.addValue(data[i],"Audio Saliente",String.valueOf(i));
        }
        createChart(dataset);
        return null;
    }
    
    private void createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("", null, null, dataset, PlotOrientation.VERTICAL, false, false, false);
        chart.setPadding(new RectangleInsets(0, 0, 0, 0));
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.getDomainAxis().setVisible(false);
        categoryPlot.getRangeAxis().setVisible(false);
        categoryPlot.setForegroundAlpha(0.85f);
        categoryPlot.getRangeAxis().setRange(-0.5, 0.5);
        
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        br.setMaximumBarWidth(.00001);  
        br.setDrawBarOutline(false);
        br.setShadowVisible(false);
        
        try {
            ChartUtilities.saveChartAsPNG(new File(name + ".png"), chart, 1920, 1080);
            
            File imageFile = new File(name + ".png");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            
            bufferedImage = cropImage(bufferedImage, 105, 8, 1710, 1064);
            File pathFile = new File(name + "-cropped.png");
            ImageIO.write(bufferedImage,"png", pathFile);
        } catch (IOException ex) {
            Logger.getLogger(Plotter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

}