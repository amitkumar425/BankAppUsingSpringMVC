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

<form action="depositIntoAccount" method="get">
	<jsp:include page="Header.jsp"></jsp:include>
	
	<jstl:if test="${sessionScope.depositStatus eq 0 }">
		<jstl:set var="depositStatus" value="1" scope="session" ></jstl:set>
		<div align="center">
			<table>
					<tr>
						<td><input type="number" name="accountNumber" required="required" placeholder="Account Number">
					</tr>
					
					<tr>
						<td><input type="number" name="amountToBeDeposited" required="required" placeholder="Amount" min="0"> </td>
					</tr>
					
					<tr>
						<td> <input type="submit" name="submit" value="DEPOSIT"> </td>
					</tr>
			</table>
		</div>
		
	</jstl:if>
	
	<jstl:if test="${sessionScope.deposit eq -1 }">
		<jstl:set var="depositStatus" value="0" scope="session" ></jstl:set>
		<h3 align ="center" >Invalid Account Number</h3>
	</jstl:if>
	
	<jstl:if test="${sessionScope.deposit gt 1 }">
		<jstl:set var="depositStatus" value="0" scope="session" ></jstl:set>
		<h4 align="center" >Balance Deposited Successfully : ${sessionScope.deposit } </h4>
	</jstl:if>
	<jsp:include page="Footer.jsp"></jsp:include>
</form>
	
</body>
</html>