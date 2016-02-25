<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/highcharts.js" type="text/javascript"></script>
<!--<script type="text/javascript">


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

            name: 'Possible values of precison,recall and F-Measure',

            data: [p, r,f ]

         }]

      });

   });



</script>-->
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
					      text: ' Search Processing Time'
					   },
					   xAxis: {
					   },
					   yAxis: {
					      title: {
					         text: ''
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
  
  
  <% Float i=(Float)session.getAttribute("Index");%>
  
   <% Float m=(Float)session.getAttribute("Mtree");%>

  <% Float d=(Float)session.getAttribute("Dcache");%>

<div id="container" style="width: 100%; height: 400px">

</div>
<table id="datatable" border="1" width="20%" cellspacing="0" cellpadding="0">
		
			<thead>
				<tr>
					<th></th>
					<th>Index</th>
					<th>M-tree</th>
					<th>D-cache</th>
					
					
				</tr>
			</thead>
			<tbody>
			<%!String ser[];
			   int val[];
			 %>
			
		
			
				<tr>
				<th></th>
					<td><%=i%></td>
					<td><%=m%></td>
					<td><%=d%></td>
					
					
					
				</tr>
				<%
			
				 %>
			</tbody>
		</table>

  </body>
</html>
