<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
   <jsp:include page="Header.jsp"></jsp:include>
  <body>
   
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
    <caption>U R Account Details</caption>
   <tr bgcolor="#FFF0F5"><th><b>SearchItemName</b></th ><th ><b>ServiceTax</b></th><th ><b>ReductionTax</b></th><th ><b>PayingAmount</b></th><th ><b>TotalAmountPaied</b></th><th ><b>PayingDate</b></th><th ><b>DataFrom</b></th>
    </tr>
<c:if test="${not empty SearchInfo}">
      <c:forEach var="SearchInfo" items="${SearchInfo}">
<tr>
<td>${SearchInfo.sdata }</td>
<td>${SearchInfo.price }</td>
<td>${SearchInfo.preduction }</td>
<td>${SearchInfo.payamount }</td>
<td>${SearchInfo.pprice }</td>

<td>${SearchInfo.sdate }</td>
<td>${SearchInfo.datafrom }</td>

</tr>
</c:forEach>
</c:if>
</table>
   
   
   <br/>  <br/>  <br/>
    <jsp:include page="./Footer.jsp"></jsp:include>
  </body>
</html>
