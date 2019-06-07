package com.tsyc.ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 

public class PlotInput extends ApplicationFrame {
   
   public PlotInput( String applicationTitle , double[] data ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         null,           
         null,            
         null,            
         createDataset(data),          
         PlotOrientation.VERTICAL,           
         false, false, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( double[] data) {      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      
      for(int i = 0; i < data.length; i++) {
          dataset.addValue(data[i],"values",String.valueOf(i));
      }            

      return dataset; 
   }
  
}