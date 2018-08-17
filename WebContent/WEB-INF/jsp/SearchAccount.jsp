<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="searchAccount" method="get">

	<jsp:include page="Header.jsp"></jsp:include>
		<div align="center">
			<input type="number" name="accountNumber" value="Account Number" required="required"><br>
			<input type="submit" name="searchAccount" value="Search Account"><br>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>