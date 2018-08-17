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
	<form action="fundTransfer">
		
		<jsp:include page="Header.jsp"></jsp:include>
		
	<jstl:if test="${sessionScope.fundTransferStatus eq 0 }">
		<div align="center">
			<input type="number" name="fromAccountNumber" required="required" placeholder="Sender Account Number">
			<input type="number" name="toAccountNumber" required="required" placeholder="Receiver Account Number">
			<input type="number" name="amountToTransfer" required="required" placeholder="Amount To Transfer">
			<input type="submit" name="fundTransfer" value="Transfer Amount" >
		</div>
	</jstl:if>

	<jstl:if test="${sessionScope.fundTransferStatus eq -1 }">
		<div align="center">
			<jstl:set var="fundTransferStatus" value="0" scope="session" ></jstl:set>
			<h4>Invalid Account Number/Amount</h4>
			<a href="FundTransfer.jsp">Try Again</a>
		</div>
	</jstl:if>
	
	<jstl:if test="${sessionScope.fundTransferStatus eq 1 }">
		<jstl:set var="fundTransferStatus" value="0" scope="session" ></jstl:set>
		<h4 align="center">${sessionScope.fundTransfer  } Amount Transfered Successfully From : ${sessionScope.donerAccountNumber } To : ${sessionScope.receipientAccountNumber } </h4>
	</jstl:if>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>