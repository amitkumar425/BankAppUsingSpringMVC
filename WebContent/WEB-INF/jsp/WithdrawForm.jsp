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
<form action="withdraw" method="get">

<jsp:include page="Header.jsp"></jsp:include>
	
	<jstl:if test="${sessionScope.denominationStatus eq 0 }">
	
		<div align="center" >
		
			<table>
				<tr>
					<td><input type="number" name="accountNumber" required="required" placeholder="Account Number">
				</tr>
				
				<tr>
					<td><input type="number" name="amountToBeWithdrawn" required="required" placeholder="Amount" min="0"> </td>
				</tr>
				
				<tr>
					<td> <input type="submit" name="submit" value="WITHDRAW"> </td>
				</tr>
			</table>
		
		</div>
	
	</jstl:if>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</form>
	
</body>
</html>