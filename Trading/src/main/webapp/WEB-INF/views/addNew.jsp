<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form id="contactform1" name="contactform" method="post" modelAttribute="trade" style="text-align:center;">
		<input type="text" name="tradeId" id="tradeId" placeholder="Enter Trade ID">
		<br><br>
		<input type="text" name="version" id="version" placeholder="Enter Version">
		<br><br>
		<input type="text" name="counterPartyId" id="counterPartyId" placeholder="Enter Counter Party ID">
		<br><br>
		<input type="text" name="bookId" id="bookId" placeholder="Enter Book ID">
		<br><br>
		<input type="date" name="maturityDate" id="maturityDate" placeholder="Enter Maturity Date">
		<br><br>
		<input type="submit" name="submit" value="Add">
		<br>
	</form:form>
	<h2>${requestScope.response}</h2>

</body>
</html>