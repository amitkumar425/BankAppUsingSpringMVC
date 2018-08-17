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

	<jstl:choose>
		<jstl:when test="${sessionScope.denomination.size() eq 0}">
			<h4>Invalid/Insufficient Amount </h4>
		</jstl:when>
		
		<jstl:otherwise>
			<table align="center" >
					<tr>
						<th>Denomination</th>
						<th>Number Of Notes</th>
					</tr>
			
				<jstl:forEach var="de" items="${sessionScope.denomination.keySet() }" >
					<tr>
						<td>${de } : ${sessionScope.denomination.get(de) }</td>
					</tr>
				</jstl:forEach>
			</table>
		</jstl:otherwise>
	</jstl:choose>
		<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>