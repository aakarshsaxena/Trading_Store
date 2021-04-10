<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

<div class="container">
<h2>${requestScope.response}</h2>
  <header>
   <h1>Welcome to Trade Store</h1>
  </header>
  <div class="starter-template">
   <table border="1">
    <tr>
     <th>Trade Id</th>
     <th>Version</th>
     <th>Counter Party ID</th>
     <th>Book ID</th>
     <th>Maturity Date</th>
     <th>Created Date</th>
     <th>Expired</th>
    </tr>
    <c:forEach var="data" items="${tradeData}">
     <tr>
      <td>${data.tradeId}</td>
      <td>${data.version}</td>
      <td>${data.counterPartyId}</td>
      <td>${data.bookId}</td>
      <td>${data.maturityDate}</td>
      <td>${data.createdDate}</td>
      <td>${data.isExpired}</td>
     </tr>
    </c:forEach>
   </table>
  </div>

 </div>
 
 <a href="<spring:url value='/addNew'/>">Add New</a>

<script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>