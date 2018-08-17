<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
	 .division{
	 	display: none;
	 
	 }
	</style>



</head>
<body>

<form action="BankAccountController" method="get">

<jsp:include page="Header.jsp"></jsp:include>
	<div align="center">
		<input type="text" name="customerName" placeholder="Your Name" required="required"><br>
		<input type="date" name="dateOfBirth" placeholder="Your DOB" onchange="ageValidation(this)" required="required"><br>
		<input type="number" name="contactNumber" placeholder="Phone Number" min="6000000000" max="9999999999" required="required"><br>
		<input type="text" name="nationality" placeholder="Nationality" required="required"><br>
		<input type="radio" name="gender" value="male" >Male
		<input type="radio" name="gender" value="female" >Female
		<input type="radio" name="gender" value="others" >Others
		<br>
		<input type="email" name="emailID" placeholder="Email ID" required="required"><br>
		<input type="text" name="houseNo" placeholder="Your House Number" required="required"><br>
		<input type="text" name="street" placeholder="Street Number" required="required"><br>
		<input type="text" name="city" placeholder="City Name" required="required"><br>
		<input type="text" name="state" placeholder="State Name" required="required"><br>
		<input type="number" name="pinCode" placeholder="Pin Code" required="required" min="111111" max="999999"><br>
		
		<select name="accountType" onchange="checkAccountType(this);">
			<option value="none">Select Account</option>
			<option value="savingAccount" >Saving Account </option>
			<option value="currentAccount">Current Account</option>
		</select><br>
	</div>

	<div class="division" id="savingAccount" align="center">
		<input onclick="checkSalaryType(this);" type="radio" name="isSalaried" value="salaried">Salaried
		<input onclick="checkSalaryType(this);" type="radio" name="isSalaried" value="notSalaried">Not Salaried 
	</div><br>
	
	<div class="division" id="salaried" align="center">
		<input type="number" name="savSalbalance" placeholder="Opening Account Balance" min="0">
	</div>
	
	<div class="division" id="notSalaried" align="center">
		<input type="number" name="savNotbalance" placeholder="Opening Account Balance" min="5000">
	</div>
	
	
	<div class="division" id="currentAccount" align="center">
		<input type="number" name="odLimit" placeholder="Over Draft Limit" min="0">
		<input type="number" name="curbalance" placeholder="Opening Account Balance" min="10000">
	</div>
	
	<div align="center">
		<input type="submit" name="submit" value="SUBMIT" >
		<input type="reset" name="reset" value="RESET" onclick="clearAll()">
	</div>
<jsp:include page="Footer.jsp"></jsp:include>
</form>

</body>


	<script type="text/javascript">
		
	  function checkAccountType(divToBeShown){
			if(divToBeShown.value=="savingAccount"){
				document.getElementById('notSalaried').style.display="none";
				document.getElementById('salaried').style.display="none";
				document.getElementById('currentAccount').style.display="none";
				document.getElementById('savingAccount').style.display="block";
			}else if(divToBeShown.value=="currentAccount"){
				document.getElementById('notSalaried').style.display="none";
				document.getElementById('salaried').style.display="none";
				document.getElementById('currentAccount').style.display="block";
				document.getElementById('savingAccount').style.display="none";
			}
		}
		
		function checkSalaryType(isSalaried){
			if(isSalaried.value=="salaried"){
				document.getElementById('currentAccount').style.display="none";
				document.getElementById('savingAccount').style.display="none";
				document.getElementById('notSalaried').style.display="none";
				document.getElementById('salaried').style.display="block";
			}else if(isSalaried.value=="notSalaried"){
				document.getElementById('currentAccount').style.display="none";
				document.getElementById('savingAccount').style.display="none";
				document.getElementById('salaried').style.display="none";
				document.getElementById('notSalaried').style.display="block";
			}
		}
		
		function clearAll(){
			document.getElementById('currentAccount').style.display="none";
			document.getElementById('savingAccount').style.display="none";
			document.getElementById('notSalaried').style.display="none";
			document.getElementById('salaried').style.display="none";
		}
		
		
		function ageValidation(inputDate){
			var ageDifferenceMinutes = Date.now()-(new Date(inputDate.value)).getTime();
			var ageDate = new Date(ageDifferenceMinutes);
			if(Math.abs(ageDate.getUTCFullYear()-1970) < 10){
				alert("Minimum age should be 18");
				ageDifferenceMinutes.value=0;
			}
		}
		
	</script>

</html>