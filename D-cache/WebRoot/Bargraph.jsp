<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.student.Dao.RegisterDAO"%>
<%@page import=" com.student.FormBean.DataFormBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<jsp:include page="Header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>
		
		
		<!-- 1. Add these JavaScript inclusions in the head of your page -->
		<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/highcharts.js"></script>
		
		<!-- 1a) Optional: add a theme file -->
		<!--
			<script type="text/javascript" src="../js/themes/gray.js"></script>
		-->
		
		<!-- 1b) Optional: the exporting module -->
		<script type="text/javascript" src="js/modules/exporting.js"></script>
		
		
		<!-- 2. Add the JavaScript to initialize the chart on document ready -->
		<script type="text/javascript">
		
			/**
			 * Visualize an HTML table using Highcharts. The top (horizontal) header 
			 * is used for series names, and the left (vertical) header is used 
			 * for category names. This function is based on jQuery.
			 * @param {Object} table The reference to the HTML table to visualize
			 * @param {Object} options Highcharts options
			 */
			Highcharts.visualize = function(table, options) {
				// the categories
				options.xAxis.categories = [];
				$('tbody th', table).each( function(i) {
					options.xAxis.categories.push(this.innerHTML);
				});
				
				// the data series
				options.series = [];
				$('tr', table).each( function(i) {
					var tr = this;
					$('th, td', tr).each( function(j) {
						if (j > 0) { // skip first column
							if (i == 0) { // get the name and init the series
								options.series[j - 1] = { 
									name: this.innerHTML,
									data: []
								};
							} else { // add values
								options.series[j - 1].data.push(parseFloat(this.innerHTML));
							}
						}
					});
				});
				
				var chart = new Highcharts.Chart(options);
			}
				
			// On document ready, call visualize on the datatable.
			$(document).ready(function() {			
				var table = document.getElementById('datatable'),
				options = {
					   chart: {
					      renderTo: 'container',
					      defaultSeriesType: 'column'
					   },
					   title: {
					      text: 'Search Query '
					   },
					   xAxis: {
					   },
					   yAxis: {
					      title: {
					         text: 'Searching Time'
					      }
					   },
					   tooltip: {
					      formatter: function() {
					         return '<b>'+ this.series.name +'</b><br/>'+
					            this.y +' '+ this.x.toLowerCase();
					      }
					   }
					};
				
			      					
				Highcharts.visualize(table, options);
			});
				
		</script>
		
	</head>
	<body>
	
	
		<div id="container" style="width: 700px; height: 400px; margin: 0 auto"></div>
		
		
		<table id="datatable" border="1" width="20%" cellspacing="0" cellpadding="0">
		
			<thead>
				<tr>
					<th bgcolor="#CEF6EC">Search Query</th>
					<th bgcolor="#CEF6EC">Search Time</th>
				</tr>
			</thead>
			<tbody>
			<%!String ser[];
			   long val[];
			 %>
			<%
		Vector<String> v2=new RegisterDAO().searchgraph1();
		System.out.println(v2+"v2 datatata");
		  ser=new String[v2.size()];
		  val=new long[v2.size()];
		
		for(int i=0;i<v2.size();i++)
		{
		   String str[]=((String)v2.get(i)).split(":");
		   ser[i]= str[0];
		   val[i]  = Integer.parseInt(str[1]);
		
		 %>
			
				<tr>
					<th><%=ser[i]%></th>
					<td><%=val[i]%></td>
				</tr>
				<%
				}
				 %>
			</tbody>
		</table>	
	</body>
</html>
