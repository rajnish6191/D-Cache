<%@ page import="java.util.*" %>

<%@page import="org.jfree.data.category.CategoryDataset"%>
<%@ page import="java.util.*" %>

<%@page import="java.io.File"%>
<%@page import="org.jfree.data.category.CategoryDataset"%>
<%@page import="org.jfree.data.general.DatasetUtilities"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.renderer.category.BarRenderer"%>
<%@page import="org.jfree.chart.plot.CategoryPlot"%>
<%@page import="org.jfree.chart.axis.CategoryAxis"%>
<%@page import="org.jfree.chart.axis.ValueAxis"%>
<%@page import="org.jfree.chart.axis.NumberAxis"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Paint"%>
<%@page import="java.awt.GradientPaint"%>
<%@page import="org.jfree.chart.ChartRenderingInfo"%>
<%@page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@page import="org.jfree.chart.ChartUtilities"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*" %>
<%@page import=" com.student.FormBean.DataFormBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	  	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="teal"><b><i>D-Cache Search Processing Time </b></font></h3></center>
   
  
      
   
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
     
       
        
        <td width="130"><div align="center" class="style8"><b>Database</b></div></td>
        <td width="130"><div align="center" class="style8"><b>MAM</b></div></td>
        <td width="130"><div align="center" class="style8"><b>Server Distance</b></div></td>
        <td width="170"><div align="center" class="style8"><b>M-tree Time(Millis)</b></div></td>
        <td width="170"><div align="center" class="style8"><b>Search Date</b></div></td>
      </tr>
     
      <c:if test="${not empty list3}">
      <c:forEach var="UserInfo" items="${list3}">
        
         
      <tr bgcolor="#CEC9FA" >
   
            <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.query }</span></div></td>
           <td bgcolor="#F4F5F7"><div align="center"><span class="style7">PT_${UserInfo.count }</span></div><br></td>
           <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.distance }</span></div></td>
           <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${UserInfo.time }</div></td>
           <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${UserInfo.sdate }</div></td>
           
       
     </tr>
      </c:forEach>
      </c:if>

      
      <c:if test="${ empty list3}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
       
 </table>
 </br></br>
 
 <!--<%
String title;
List<DataFormBean> list=(List<DataFormBean>)request.getAttribute("list3");
double dd[]=new double[list.size()];
int cnt=0;
    for(DataFormBean insertDataBean:list)
    { 
    
    dd[cnt]=insertDataBean.getTime();
    title=insertDataBean.getIname();
    //dd[cnt+1]=websiteForm.getRepeat();
    ++cnt;
    

  
   }
   
   System.out.println("ddddddddddddddddddddd::::"+dd);
            final double[][] data = new double[][]{dd
                
               
            };

            final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                    "Query Axis ", "", data);

            JFreeChart chart = null;
            BarRenderer renderer = null;
            CategoryPlot plot = null;


  
            final CategoryAxis categoryAxis1=new CategoryAxis("Query");
            final ValueAxis valueAxis = new NumberAxis("Time");
            renderer = new BarRenderer();

  
            plot=new CategoryPlot(dataset,categoryAxis1,valueAxis,renderer);

            plot.setOrientation(PlotOrientation.VERTICAL);
            chart = new JFreeChart("Search Time", JFreeChart.DEFAULT_TITLE_FONT, 
            plot, true);

            chart.setBackgroundPaint(new Color(249, 231, 232));

            Paint p1 = new GradientPaint(
                    0.0f, 0.0f, new Color(16, 89, 172), 0.0f, 0.0f, new Color
                   (201, 201, 244));

            renderer.setSeriesPaint(1, p1);

            Paint p2 = new GradientPaint(
                    0.0f, 0.0f, new Color(255, 35, 35), 0.0f, 0.0f, new Color
                    (255, 180, 180));

            renderer.setSeriesPaint(2, p2);

            plot.setRenderer(renderer);

            try {
                final ChartRenderingInfo info = new ChartRenderingInfo
                (new StandardEntityCollection());
                final File file1 = new File("C:\\barchart.png");
                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
            } catch (Exception e) {
                out.println(e);
            }
%>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
       
        <title>JSP Page</title>
    </head>
    
    <body>
   
       <center> <IMG SRC="C:/barchart.png" WIDTH="600" HEIGHT="400" BORDER="0" USEMAP="#chart">
       </center>

    </body>
</html> 
 
 <br/><br/> 
</body>-->