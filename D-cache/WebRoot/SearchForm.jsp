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
                   
		
<center><h3><font color="teal"><b><i>User Search Info</b></font></h3></center>
   
  
      
   
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
     
       
        <td width="110"><div align="center" class="style8"><b>User Name</b></div></td>
        <td width="130"><div align="center" class="style8"><b>Query Name</b></div></td>
        <td width="130"><div align="center" class="style8"><b>Time(second)</b></div></td>
        <td width="130"><div align="center" class="style8"><b>Search Date</b></div></td>
      </tr>
     
      <c:if test="${not empty list}">
      <c:forEach var="UserInfo" items="${list}">
         
      <tr bgcolor="#CEC9FA" >
    
        
       
            <td bgcolor="#F4F5F7"><div align="center" class="style7">${UserInfo.loginid }</div></td>
            <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.query }</span></div></br></td>
           <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${UserInfo.time }</div></td>
            <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${UserInfo.sdate }</div></td>
           
       
     </tr>
      </c:forEach>
      </c:if>

      
      <c:if test="${ empty list}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
       
 </table>
 </body>