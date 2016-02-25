
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.student.FormBean.DataFormBean"%>
<%@page import="com.student.Dao.DataDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 
 
	<link rel="stylesheet" type="text/css" href="jquery.autocomplete.css" />
	
	
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
	
	      
	
	
	<table>
	<tr>
	
	
	<td>
	
	<center>
	<table border="1" width="70">
	
	
	<tr bgcolor="#8FBC8F">
	<td><b>Select</b></td>
	<td><b>ImageID</b></td>
	<td><b>Image Name</b></td>
	<td><b>c</b></td>
	<c:if test="${not empty v}">
      <c:forEach var="Data" items="${v}">
	<tr background="n">
	 
    <td><input type="radio" name="rad" value="sanjay" CHECKED="checked"></td>
	<td>${Data.imageid}</td>
	<td>${Data.iname}</td>
	
	
	
	</c:forEach>
	</c:if>
	
	</tr>
	</table>
	</table>
	</center>
	<center>
	<form action="./GetDataAction?page=ResultDisply.jsp">
	
	
	
	<fieldset>
	
	<input type="text" id="title" name="title" size="50"/>
	<input type="text" id="distance" name="distance" size="10"/>
	<input type="image"  alt="submit"  src="images/g4.jpg" >
	
	</fieldset>
	
	
	<script>
		$("#title").autocomplete("getdata.jsp");
	</script>
	
	</form>
	</center>
	
	<br/><br/>
	
</body>
 <jsp:include page="Footer.jsp"></jsp:include>

</html>