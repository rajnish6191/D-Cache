
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
	
	
</head>
<body bgcolor="#FFC0CB">
 
  <jsp:include page="Header.jsp"></jsp:include>
    <h3><a href="./PivotAction">Search Again</a></h3> 
	
                    <center><font size="4" color="#000080">Data Access From Cache Memory</font>
	<table>
	
	<c:if test="${not empty Data}">
      <c:forEach var="Data" items="${Data}">
  <tr ><td align="center">
  
   <td><font size="4">Name: ${Data.iname }</font></td></tr>
  <tr>
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data/${Data.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${Data.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${Data.distance } </font></td>
 </tr>
  <tr>
   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
            
            
            
            <table>
	
	<c:if test="${not empty Data1}">
      <c:forEach var="Data1" items="${Data1}">
  <tr ><td align="center">
  
   <td><font size="4">Name: ${Data1.iname }</font></td></tr>
  <tr>
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data1/${Data1.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${Data1.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${Data1.distance } </font></td>
 </tr>
  <tr>
   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>
            
  <table>
	
	<c:if test="${not empty Data2}">
      <c:forEach var="Data2" items="${Data2}">
  <tr ><td align="center">
  
   <td><font size="4">Name: ${Data2.iname }</font></td></tr>
  <tr>
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data2/${Data2.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${Data2.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${Data2.distance } </font></td>
 </tr>
  <tr>
   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>          
            
        <table>
	
	<c:if test="${not empty Data3}">
      <c:forEach var="Data3" items="${Data3}">
  <tr ><td align="center">
  
   <td><font size="4">Name: ${Data3.iname }</font></td></tr>
  <tr>
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data3/${Data3.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${Data3.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${Data3.distance } </font></td>
 </tr>
  <tr>
   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>    
            
         
   <table>
	
	<c:if test="${not empty Data4}">
      <c:forEach var="Data4" items="${Data4}">
  <tr ><td align="center">
  
   <td><font size="4">Name: ${Data4.iname }</font></td></tr>
  <tr>
  <td bgcolor="" ><img alt="SeeImage
  Here" id="previewField" src="data4/${Data4.image }" height="130" width="150" ></td>
   <td><font color="red" size="3">Description</font><font color="green" size="2">:${Data4.description } </font><br/><br/><font color="red" size="3"><i>Distance :</i> <font color="green" size="2">${Data4.distance } </font></td>
 </tr>
  <tr>
   <td colspan="4">....................................................................................</td></tr>
          
          </c:forEach>
          </c:if>
            </table>         
            
            
            
	
	<h3><a href="./PivotAction">Search Again</a></h3> 
</body>
</html>