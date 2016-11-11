<%@page import="java.io.PrintWriter"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Hotel</title>

</head>
<body>

<br>
<%-- <c:forEach items="${login}" var="info"> --%>
<c:out value="${login.getEmail()}"></c:out>
<%-- </c:forEach> --%>


<form:form action="login.view" id="form"  name="myform"  method="post" commandName="details">


City: <form:select id="mySelect" name="choose" path="city" onchange="myfunction()" > 
<option   id=0   value="0"  >Select</option>

<c:forEach items="${hotelDetails}" var="city">
<option   id=2   value="${city}"  >
<c:out value="${city}" />
</option>
</c:forEach>

</form:select>

<script>
function myfunction(){
	var x = document.getElementById("mySelect").value;
	var xhttp=new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		      document.getElementById("demo").innerHTML = xhttp.responseText;
		    }
		  };
		  xhttp.open("GET","getHotelName.view?list="+x, true);
		  xhttp.send();
}

</script>


<br><br><br>  
<div id="div2">
Hotel :<form:select id="demo" name="hotel" path="hotelId">
</form:select>
</div>

<br>
<!--   <p>check-in Date :<input  type="date" name="check_in" ></p> -->
 
<!--  <br> -->
<!--   <p>check-out Date :<input type="date" name="check_out" ></p>       -->
   
  <br><br>
Check-In<form:input path="checkIn" />
<br><br>
<form:errors path="checkIn" style="color:red"></form:errors>
<br><br>
Check-Out<form:input path="checkOut" />
<br><br>
<form:errors path="checkOut" style="color:red"></form:errors>
<br><br>
<form:errors path="invalidDate" style="color:red"></form:errors>
<br><br> 
   
   	
<br>
<p>Number of rooms : <form:input type="number" path="room" name="rooms" /> </p>	
<br>
<form:errors path="room" style="color:red"></form:errors>	
	<br><input type="submit" value="Submit">  
	 <a href="index.jsp"><button type="button">cancel</button></a> 

<input type="reset" value="clear"> 
</form:form>


  







</body>
</html>