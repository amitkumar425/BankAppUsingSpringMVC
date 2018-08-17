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

	<jstl:if test="${sessionScope.accountFound eq null }">
		<jstl:redirect url="AccountNotFound"></jstl:redirect>
	</jstl:if>
	
		<table align="center" >
			<tr>
				<th>Account Number</th>
				<th>Customer ID</th>
				<th>Account Type</th>
				<th>Account Balance</th>
				<th>Overdraft Limit</th>
				<th>Salary Account ?</th>
			</tr>
			<tr>
					<td>${sessionScope.accountFound.accountNumber }</td>			
					<td>${sessionScope.accountFound.accountHolder.customerId }</td>			
					<td>${sessionScope.accountFound.accountType }</td>			
					<td>${sessionScope.accountFound.accountBalance }</td>	
					
					<jstl:choose>
						<jstl:when test='${sessionScope.accountFound.accountType.equals("savingAccount") }'>
							<td>N/A</td>
							<td>${sessionScope.accountFound.salary }</td>
						</jstl:when>
						<jstl:otherwise>
							<td>${sessionScope.accountFound.odLimit }</td>	
							<td>N/A</td>
						</jstl:otherwise>
					</jstl:choose>		
			</tr>
			
		</table>
		<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>