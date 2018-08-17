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
	<jsp:include page="Header.jsp"></jsp:include>
		<div align="center">
			<h3>Account Creation Successful</h3><br>
			<h4>Account Number/User ID : ${createdAccount.accountNumber }</h4><br>
			<h3>Initial Account Balance : ${createdAccount.accountBalance } </h3><br>
		</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>