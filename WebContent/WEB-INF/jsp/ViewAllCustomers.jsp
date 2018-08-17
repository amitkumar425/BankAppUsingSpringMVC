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
	<form action="">
	
	<jsp:include page="Header.jsp"></jsp:include>
		<jstl:if test="${sessionScope.accountList.size()==0 }">
			<jstl:redirect url="NoAccountFound"></jstl:redirect>
		</jstl:if>
	
	<table align="center" >
		<tr>
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Account Number</th>
			<th>Account Balance</th>
			<th>Email ID</th>
			<th>Phone Number</th>
			<th>Date Of Birth </th>
			<th>Update Link</th>
		</tr>
		
		<jstl:forEach var="account" items="${sessionScope.accountList }" >
			<tr>
				<td>${account.accountHolder.customerId }</td>
				<td>${account.accountHolder.customerName }</td>
				<td>${account.accountNumber }</td>
				<td>${account.accountBalance }</td>
				<td>${account.accountHolder.emailId }</td>
				<td>${account.accountHolder.contactNumber }</td>
				<td>${account.accountHolder.dateOfBirth }</td>
				<td><a href="update?accountNumber=${account.accountNumber }" >UPDATE</a></td>
			</tr>
		</jstl:forEach>
		
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
	</form>
	
</body>
</html>