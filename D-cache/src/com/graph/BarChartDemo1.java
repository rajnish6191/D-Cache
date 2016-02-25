package com.graph;
// Decompiled Using: FrontEnd Plus v2.02 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

//package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

import com.student.Db.ConnectionFactory;

import java.sql.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.util.*;

public class BarChartDemo1 extends ApplicationFrame
{
		
 public static Connection conn;

    public BarChartDemo1(String s)throws Exception
    {
        super(s);
        
        conn=ConnectionFactory.getConnection();
         
         
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()throws Exception
    {
       
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        
        
        		 Statement szzz=conn.createStatement();
				  ResultSet rzzz=szzz.executeQuery("select * from filelist");
				  
				  
				  
				  
				  
				  while(rzzz.next())
				  {
				  	
				  	int count=0;
				  String detail=rzzz.getString("filenames");
				   
			      Statement szzz1=conn.createStatement();
				  ResultSet rzzz1=szzz1.executeQuery("select * from req where file='"+detail+"'");
				  
				  
				  while(rzzz1.next())
				  {
				  	count++;
				  	
				  	
				  }
           
            		defaultcategorydataset.addValue(count, "Filelist vs RquestRange", detail);
               
                  }
                
                
              
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Request Details", "Filelist", "RquestRange", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeCrosshairVisible(true);
        categoryplot.setRangeCrosshairPaint(Color.blue);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, gradientpaint1);
        barrenderer.setSeriesPaint(2, gradientpaint2);
        barrenderer.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.52359877559829882D));
        return jfreechart;
    }

    public static JPanel createDemoPanel()throws Exception
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])throws Exception
    {
        BarChartDemo1 barchartdemo1 = new BarChartDemo1("JFreeChart: BarChartDemo1.java");
        barchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo1);
        barchartdemo1.setVisible(true);
    }
}
