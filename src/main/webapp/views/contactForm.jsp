<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function checkClientValidation() {
			var result = ValidateForm();	
			if (result) {
				var form = document.getElementById("registration");
				form.submit();
			}
		}

		function ValidateForm() {
			document.getElementById("showHints").innerText="";
			document.getElementById("showHints1").innerText="";
			document.getElementById("showHints2").innerText="";
			
			var ret = true;
			
			if (document.getElementById("contactName").value == "") {
				document.getElementById("showHints").innerText += "* Contact Name is Required.\n";
				ret = false;
			}
			var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z\-\.])+\.([A-Za-z]{2,4})$/;
			if (reg.test(contactEmail.value) == false) {
				document.getElementById("showHints1").innerHTML += "* Enter Valid Email Id.\n";
				ret = false;
			}
			var number = /^\d{10}$/;
			if (number.test(document.getElementById("contactNumber").value) == false) {
				document.getElementById("showHints2").innerHTML += "* Enter a Valid Number.\n";
				ret = false;
			}
			return ret;
		}
	</script>
</head>


	<h3>Contact Info</h3>
	<p>${msg}</p>
	<!-- <div class="container"> -->
	<form:form action="addDetails" modelAttribute="contact" method="POST" id="registration" >
		<table>
			<tr>
				<form:hidden path="contactId"/>
				<td>Name:</td>
				<td><form:input path="contactName" id="contactName" /></td>
				<td><p id="showHints" ></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="contactEmail" id="contactEmail"/></td>
				<td><p id="showHints1" ></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input path="contactNumber" id="contactNumber" /></td>
				<td><p id="showHints2" ></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="button" value="Sumbit" onclick="checkClientValidation()"/></td>
			</tr>
		</table>
	</form:form>
	
	<a href="viewContacts">View All Contacts</a>
</body>
</html>