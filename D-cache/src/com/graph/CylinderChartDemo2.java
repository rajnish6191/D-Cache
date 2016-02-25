package com.graph;
// Decompiled Using: FrontEnd Plus v2.02 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 



import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

import com.student.Db.ConnectionFactory;

import java.sql.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.util.*;
// Referenced classes of package demo:
//            CylinderRenderer

public class CylinderChartDemo2 extends ApplicationFrame
{
	
	public static Connection conn;
	
   /* static class CustomCylinderRenderer extends CylinderRenderer
    {

        public Paint getItemPaint(int i, int j)
        {
            return colors[j % colors.length];
        }

        private Paint colors[];

        public CustomCylinderRenderer(Paint apaint[])
        {
            colors = apaint;
        }
    }*/


    public CylinderChartDemo2(String s)throws Exception
    {
        super(s);
        
        
        conn=ConnectionFactory.getConnection();
        
        ChartPanel chartpanel = (ChartPanel)createDemoPanel();
        chartpanel.setPreferredSize(new Dimension(500, 500));
        chartpanel.setLocation(150,20);
        setContentPane(chartpanel);
    }

    private static CategoryDataset createDataset() throws Exception
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
           
            		defaultcategorydataset.addValue(count, "S1", detail);
               
                  }
                
                
              
              
                
                
        return defaultcategorydataset;
        
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)throws Exception
    {
        JFreeChart jfreechart = ChartFactory.createBarChart3D("Number of Requester", "Table Rquest", "", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
      //  categoryplot.setRangePannable(true);
        Paint apaint[] = createPaint();
        //CustomCylinderRenderer customcylinderrenderer = new CustomCylinderRenderer(apaint);
       //customcylinderrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        //customcylinderrenderer.setBaseOutlinePaint(Color.gray);
       // customcylinderrenderer.setBaseOutlineStroke(new BasicStroke(0.3F));
        //customcylinderrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        //categoryplot.setRenderer(customcylinderrenderer);
     //   ChartUtilities.applyCurrentTheme(jfreechart);
        return jfreechart;
    }

    private static Paint[] createPaint()throws Exception
    {
        Paint apaint[] = new Paint[5];
        apaint[0] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.black);
        apaint[1] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.blue);
        apaint[2] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.green);
        apaint[3] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.magenta);
        apaint[4] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.orange);
        return apaint;
    }

    public static JPanel createDemoPanel()throws Exception
    {
        JFreeChart jfreechart = createChart(createDataset());
        ChartPanel chartpanel = new ChartPanel(jfreechart);
       // chartpanel.setMouseWheelEnabled(true);
        return chartpanel;
    }

    public static void main(String args[])throws Exception
    {
    	 CylinderChartDemo2 cylinderchartdemo2 = new CylinderChartDemo2("User details");
				        cylinderchartdemo2.pack();
				        cylinderchartdemo2.setVisible(true);
        
    }
}
