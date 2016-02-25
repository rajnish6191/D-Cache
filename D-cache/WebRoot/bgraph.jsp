<%@ page import="java.awt.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.axis.*"%>
<%@ page import="org.jfree.chart.entity.*"%>
<%@ page import="org.jfree.chart.labels.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.renderer.category.*"%>
<%@ page import="org.jfree.chart.urls.*"%>
<%@ page import="org.jfree.data.category.*"%>
<%@ page import="org.jfree.data.general.*"%>

<%
session=request.getSession();
Vector<String> v1=new Vector<String>();
Vector<String> v2=new Vector<String>();
				 v2 = (Vector<String>) session.getAttribute("fv");
				 System.out.println("fv is:::"+v2);
				for(int m=0;m<v2.size();m++)
				v1.add(v2.get(m));
				System.out.println("The vector is:::"+v1);
				
				int count=0;
		String s[]=new String[v1.size()];
		
		Vector vv=new Vector();	
	for(int x=0;x<s.length;x++){
	if(s[x]!=null)
	vv.add(s[x]);
	}		
	System.out.println("VV is::"+vv);
	String ss[]=new String[vv.size()];
	for(int x=0;x<vv.size();x++){
	ss[x]=(String)vv.get(x);
	}	
	for(int x=0;x<ss.length;x++)
	System.out.println("ss is::"+ss[x]);
	System.out.println(":::::::::::::::"+session.getAttribute("fv"));
%>
<%! String ser[];
	int[] val;%>

<%
					if (v1.size() == 0) {
				%>

<%
					} else {
					
					ser=new String[v1.size()];	
					val=new int[v1.size()];
					//for (int i = 0; i < vv.size(); i++) {
						for (int i = 0; i < v1.size(); i++) {
						System.out.println("::::::::::::v1.get(i):::::::::::"+v1.get(i));
						//if(s[i]!=null){	
							String str[] =((String) v1.get(i)).split(":");
							ser[i] = str[0];
							val[i]  = Integer.parseInt(str[1]);
							//}
				
					}
					
					}
				

			final DefaultCategoryDataset dedataset=new DefaultCategoryDataset();
           // final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(                    "Team ", "Value", data);
            final CategoryDataset dataset = dedataset;
            
           
           
			for(int i=0;i<ser.length;i++){
			
			dedataset.addValue(val[i], "Processing Range",ser[i] );
			
			
			}
        
	JFreeChart chart = ChartFactory.createBarChart(
            "Record DeDuplication graph",       // chart title
            "Domain",               // domain axis label
            "Number of Book",                  // range axis label
            dataset,                  // data
           PlotOrientation.VERTICAL, // orientation
           //PlotOrientation.HORIZONTAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        
        //chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.orange);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
                0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,
                0.0f, 0.0f, new Color(64, 0, 0));
        //renderer.setSeriesPaint(0, gp0);
        //renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(
                        Math.PI / 6.0));
			
         plot.setRenderer(renderer);

            try {
                final ChartRenderingInfo info = new ChartRenderingInfo
                (new StandardEntityCollection());
                final File file1 = new File("c:/barchart.png");
                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
            } catch (Exception e) {
                out.println(e);
            }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>

		<link rel="stylesheet" type="text/css" href="jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
	
	</head>
  <body bgcolor="#DBC5CB">
  <jsp:include page="UserMenu.jsp" /></br>
			<%
				if (request.getParameter("status") != null) {
			%>	
				<font color="#406070"><br>
					<strong> <%=request.getParameter("status")%></strong>
					<%=session.getAttribute("loginuser")%> 
					
				</font>
			<%
				}
			%>	
  
	<table align="center">
    
  </table>
		<center><IMG SRC="c:/barchart.png" WIDTH="600" HEIGHT="400" BORDER="0"
			USEMAP="#chart">
			</center>
	</body>
</html>