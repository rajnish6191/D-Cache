package com.graph;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import com.student.Db.ConnectionFactory;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.record.formula.Ptg;
import sun.swing.AccumulativeRunnable;
import com.student.Db.ConnectionFactory;
import com.student.FormBean.DataFormBean;
import com.student.Util.DateWrapper;




public class LineChartDemo2 extends ApplicationFrame
{
	

	/*public LineChartDemo2()
	{
		
		con=ConnectionFactory.getConnection();	
	}
*/
	Connection con=ConnectionFactory.getConnection();	
    public LineChartDemo2(String s)throws Exception
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        jpanel.setLocation(100,200);
        setContentPane(jpanel);
    }

    private XYDataset createDataset()throws Exception
    {
    	
        XYSeries xyseries = new XYSeries("Time");
         
        int count=0;
        int count1=0;
        int count2=0;
        
        				Statement sa1=con.createStatement();
						ResultSet rsa1=sa1.executeQuery("select q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid");
					//	System.out.println("list of product");
						while(rsa1.next())
						{
						count++;
						
							
						}
    	xyseries.add(0,0);
       xyseries.add(1,count);
         
       XYSeries xyseries1 = new XYSeries("Total number of query");
        	Statement sa11=con.createStatement();
						ResultSet rsa11=sa11.executeQuery("select s.imagename from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid");
						//System.out.println("list of product");
						while(rsa11.next())
						{
							
						count1++;
							
						}
		xyseries1.add(0,0);
       xyseries1.add(1,count1);
						
						 /* XYSeries xyseries2 = new XYSeries("Patients");
        	Statement sa111=con.createStatement();
			ResultSet rsa111=sa111.executeQuery("select * from patient");
			System.out.println("list of product");
						while(rsa111.next())
						{
							
						count2++;
							
						}
      */
       
     //	xyseries2.add(0,0);
       //xyseries2.add(1,count2);
       
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        //xyseriescollection.addSeries(xyseries2);
      
        return xyseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Performance", "", "Range", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
      //  xyplot.setDomainPannable(true);
     //  xyplot.setRangePannable(true);
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        xylineandshaperenderer.setBaseShapesFilled(true);
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public JPanel createDemoPanel()throws Exception
    {
        JFreeChart jfreechart = createChart(createDataset());
        ChartPanel chartpanel = new ChartPanel(jfreechart);
       // chartpanel.setMouseWheelEnabled(true);
        return chartpanel;
    }

    public static void main(String args[])throws Exception
    {
    
       
				        LineChartDemo2 linechartdemo2 = new LineChartDemo2("Time and Query details");
				        linechartdemo2.pack();
				          linechartdemo2.setVisible(true); 
        
        
    }
}
