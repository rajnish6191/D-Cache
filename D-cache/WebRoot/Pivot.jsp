
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import=" com.student.FormBean.DataFormBean"%>
<%@page import="com.student.Dao.DataDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <META HTTP-EQUIV=REFRESH CONTENT=30>
 
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

<jsp:include page="Header.jsp"></jsp:include>
  
  
                <%

ArrayList<DataFormBean> acb=new DataDao().getAllCatagery();

request.setAttribute("Data",acb);

 %>
<body>
	
	     <center>
	<form action="./PivotDataAction?page=ResultDisply.jsp"> 
	
	<center>
	<h3>Pivot D-Cache Data<h3>
	<table border="1" width="70">
	
	
	<tr bgcolor="#8FBC8F">
	<td><b>ImageName</b></td>
	<td><b>ServerDistance</b></td>
	<td><b>SelectDistance</b></td>
	</tr>
					

					<tr>
					
					
					          <td>
								<font color=blue><b>Java</b> </font>
							</td>
                            
							<td><font color=blue><b>50</b> </font></td>
                             <td>
							    <input type="radio" name="dis" value="50"
								CHECKED>
							</td>
							
					</tr>
					
					
					
					
					
					
					
					<tr>
					
					
					          <td>
								<font color=blue><b>PHP</b> </font>
							</td>
                            
							<td><font color=blue><b>60</b> </font></td>
                             <td>
							    <input type="radio" name="dis" value="60"
								CHECKED>
							</td>
							
					</tr>
					
					
					
					
					
					<tr>
					
					
					          <td>
								<font color=blue><b>Dotnet</b> </font>
							</td>
                            
							<td><font color=blue><b>70</b> </font></td>
                             <td>
							    <input type="radio" name="dis" value="70"
								CHECKED>
							</td>
							
					</tr>
					
					
					
					
					
					
					<tr>
					
					
					          <td>
								<font color=blue><b>Spring</b> </font>
							</td>
                            
							<td><font color=blue><b>80</b> </font></td>
                             <td>
							    <input type="radio" name="dis" value="80"
								CHECKED>
							</td>
							
					</tr>
					
					
					
					
					
					<tr>
					
					
					          <td>
								<font color=blue><b>Hibernate</b> </font>
							</td>
                            
							<td><font color=blue><b>90</b> </font></td>
                             <td>
							    <input type="radio" name="dis" value="90"
								CHECKED>
							</td>
							
					</tr>
					
	
	</table>
	

	<tr><br/>
	<td><font color="#BB8H22">Enter Image Name</font></td>
	<td><input type=text name="title"/></td>
	<td><input type="image"  alt="submit"  src="images/sr.png" height="50" width="100"></td>
	</tr>
	</table></center></form></center>
	</body>
 </html>