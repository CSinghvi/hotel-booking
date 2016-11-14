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
<style>
body{
   content: "";
   position:absolute;
   z-index: -1;
   top: 0;
   bottom: 0;
   left: 0;
   right: 0;
   background-image: url("./Image/Booking.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
    opacity: 0.7;
/*     filter:alpha(opacity=90); */
    height:100%;
    width:100%;
    float:top;
 }
 
 #demo{
 width:140px;   
}

 #mySelect{
 width:140px;   
}
 </style>
</head>
<body>
<div style="position:absolute; margin-left:5%;top:0%;">

<form:form action="login.view" id="form"  name="myform"  method="post" commandName="details">

<table>
<tr>
<td>City:</td><td> <form:select id="mySelect" name="choose" path="city" onchange="myfunction()" > 
<option   id=0   value="0"  >Select</option>

<c:forEach items="${hotelDetails}" var="city">
<option   id=2   value="${city}"  >
<c:out value="${city}" />
</option>
</c:forEach>

</form:select ></td></tr>
<tr>
<td></td><td><form:errors path="city" style="color:red"></form:errors></td></tr>	
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


<br><br> 
<div id="div2">
<tr><td>
Hotel :</td><td><form:select id="demo" name="hotel" path="hotelId">
</form:select></td></tr>
<form:errors path="hotelId" style=
"color:red"></form:errors>	
</div>


<!--   <p>check-in Date :<input  type="date" name="check_in" ></p> -->
 
<!--  <br> -->
<!--   <p>check-out Date :<input type="date" name="check_out" ></p>       -->
   
  <br>
<tr><td>Check-In:</td><td><form:input path="checkIn" /><td>
<br>
<tr><td></td><td><form:errors path="checkIn" style="color:red"></form:errors></td></tr>
<br>
<tr><td>Check-Out:</td><td><form:input path="checkOut" /></td></tr>
<br>
<tr><td></td><td><form:errors path="checkOut" style="color:red"></form:errors></td></tr>
<br>
<tr><td></td><td><form:errors path="invalidDate" style="color:red"></form:errors></td></tr>

   
   	
<br>
<tr><td>Number of rooms :</td><td> <form:input type="number" path="room" name="rooms" /></td></tr>
<br>
<tr><td></td><td><form:errors path="room" style="color:red"></form:errors></td></tr>	
<tr><td><input type="submit" value="Submit"> </td><td> 
	 <a href="index.jsp"><button type="button">cancel</button></a></td> 


</table>
</form:form>


</div>


</body>
</html>