
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.student.FormBean.DataFormBean"%>
<%@page import="com.student.Dao.DataDao"%><%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/displaytag.css" type="text/css">
<link rel="stylesheet" href="css/screen.css" type="text/css">
<link rel="stylesheet" href="css/site.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Using DisplayTag - www.javaworkspace.com</title>

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
 
  <jsp:include page="Header.jsp"></jsp:include>
    <h3><a href="./PivotAction">Search Again</a></h3> 
	
                    <center><font size="4" color="#FF4500">Data Access From DataBase</font>
	<table>
	
	<c:if test="${not empty DataInfo}">
      <c:forEach var="DataInfo" items="${DataInfo}">
  <tr ><td align="center">
  
  <tr align="center"> <td><font size="4">Name: ${DataInfo.iname }</td></font></tr>
  
  
  
  <tr>
  
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data/${DataInfo.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${DataInfo.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${DataInfo.distance } </font></td>
  
  
 
 </tr>
 
   
  
  
  <tr>
                                   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
            
            
            
            
            
            
            
            
            <table>
	
	<c:if test="${not empty DataInfo1}">
      <c:forEach var="DataInfo1" items="${DataInfo1}">
  <tr ><td align="center">
  
  <tr align="center"> <td><font size="4">Name: ${DataInfo1.iname }</td></font></tr>
  
  
  
  <tr>
  
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data1/${DataInfo1.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${DataInfo1.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${DataInfo1.distance } </font></td>
  
  
 
 </tr>
 
   
  
  
  <tr>
                                   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
   
   
   
   
   <table>
	
	<c:if test="${not empty DataInfo2}">
      <c:forEach var="DataInfo2" items="${DataInfo2}">
  <tr ><td align="center">
  
  <tr align="center"> <td><font size="4">Name: ${DataInfo2.iname }</td></font></tr>
  
  
  
  <tr>
  
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data2/${DataInfo2.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${DataInfo2.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${DataInfo2.distance } </font></td>
  
  
 
 </tr>
 
   
  
  
  <tr>
                                   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
            
            
            
             <table>
	
	<c:if test="${not empty DataInfo3}">
      <c:forEach var="DataInfo3" items="${DataInfo3}">
  <tr ><td align="center">
  
  <tr align="center"> <td><font size="4">Name: ${DataInfo3.iname }</td></font></tr>
  
  
  
  <tr>
  
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data3/${DataInfo3.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${DataInfo3.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${DataInfo3.distance } </font></td>
  
  
 
 </tr>
 
   
  
  
  <tr>
                                   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
   
   
   
   
    <table>
	
	<c:if test="${not empty DataInfo4}">
      <c:forEach var="DataInfo4" items="${DataInfo4}">
  <tr ><td align="center">
  
  <tr align="center"> <td><font size="4">Name: ${DataInfo4.iname }</td></font></tr>
  
  
  
  <tr>
  
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data4/${DataInfo4.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${DataInfo4.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${DataInfo4.distance } </font></td>
  
  
 
 </tr>
 
   
  
  
  <tr>
                                   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
	</center>
	
	<h3><a href="./PivotAction">Search Again</a></h3> 
</body>
</html>