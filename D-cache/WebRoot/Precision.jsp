<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.student.FormBean.DataFormBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Precision.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/highcharts.js" type="text/javascript"></script>
<script type="text/javascript">
var chart1; // globally available
$(document).ready(function() {

      chart1 = new Highcharts.Chart({

         chart: {

            renderTo: 'container',

            type: 'bar'

         },

         title: {

            text: 'Ontology Model'

         },

         xAxis: {

            categories: ['Precision', 'Recall', 'F-Measure']

         },

         yAxis: {

            title: {

               text: 'Values'

            }

         },

         series: [{

            name: 'Jane',

            data: [precision,recall,fmeasure]

         }]

      });

   });


</script>
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
  
  <body>
  <table>	<tr>
  <td>
  <jsp:include page="Header.jsp"/>
  <%
  HttpSession session1=request.getSession();
   %>
  </td></tr></table>


			<%
				if (session.getAttribute("user")!= null) {
			%>

			<h2>
				<font color="#406070"><br>
					<strong> <%=session.getAttribute("user")%>
					</strong>
				</font>
			</h2>

			<%
				}
			%>
				
  <form action="./MyJsp.jsp" method="post">
  <table width="" border="1" align="center" >
    
      <tr bgcolor="#FFFFE0">
   
    <td width="350"><div align="center" class="style8">Index Construction Times</td>
   <%
   
   Float Index = (Float)session1.getAttribute("time");
   session.setAttribute("Index",Index);
   %>
    <td width="110"><div align="center" class="style8"><%=Index%></td>

   
   
   </tr>
   <tr bgcolor="#FFFFE0">
    <td width="350"><div align="center" class="style8">M-Tree Construction Times</td>

  <%  Float Mtree = (Float)session1.getAttribute("time1");
  session.setAttribute("Mtree",Mtree);
  
  %>
    <td width="110"><div align="center" class="style8"><%=Mtree%></td>

   
   
   </tr>
   <tr bgcolor="#FFFFE0">
    <td width="350"><div align="center" class="style8">D-Cache Search Processing Time</td>
    <%
    Float Dcache = (Float)session1.getAttribute("time2");
    
      session.setAttribute("Dcache",Dcache);
    %>
    
     <td width="110"><div align="center" class="style8"><%=Dcache%></td></tr><tr></tr>
     <tr>
    <!--<tr bgcolor="#FFFFE0">
     <td width="150"></td>--><tr></tr>
   <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Graph" /></td></tr></table>
   </form>
      <div id="container" style="width: 100%; height: 400px"></div>
  </body>
</html>
