<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript">
		function ageValidation(inputDate){
			var ageDifferenceMinutes = Date.now()-(new Date(inputDate.value)).getTime();
			var ageDate = new Date(ageDifferenceMinutes);
			if(Math.abs(ageDate.getUTCFullYear()-1970) < 10){
				alert("Minimum age should be 18");
				ageDifferenceMinutes.value=0;
			}
		}
	</script>

</head>
<body>

<form action="writeUpdate">
	<jsp:include page="Header.jsp"></jsp:include>
	<table align="center" >
		<tr>
			<td>Customer ID</td>
			<td><input type="text" name="customerID" readonly="readonly" value="${sessionScope.accountToBeUpdated.accountHolder.customerId }">
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><input type="text"  name="customerName" value="${sessionScope.accountToBeUpdated.accountHolder.customerName }">
		</tr>
		<tr>
			<td>Account Number</td>
			<td><input type="number" name="accountNumber" readonly="readonly" value="${sessionScope.accountToBeUpdated.accountNumber }">
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" value="${sessionScope.accountToBeUpdated.accountHolder.emailId }">
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" name="phoneNumber" value="${sessionScope.accountToBeUpdated.accountHolder.contactNumber }">
		</tr>
		<tr>
			<td>Date Of Birth</td>
			<td><input type="date" name ="dob" value="${sessionScope.accountToBeUpdated.accountHolder.dateOfBirth }" onchange="ageValidation(this)">
		</tr>
		<tr>
			<td><input type="submit" name="update" value="UPDATE">
			<td><input type="reset" name="reset" value="CLEAR">
		</tr>
	</table>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
	
</body>
</html>