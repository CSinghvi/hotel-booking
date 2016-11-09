<%@page import="java.io.PrintWriter"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Hotel</title>

</head>
<body>

<form action="login.view" id="form"  name="myform"  method="post">


City: <select id="mySelect" name="choose"  onchange="myfunction()" > 
<option   id=0   value="0"  >Select</option>

<c:forEach items="${hotelDetails}" var="city">
<option   id=2   value="${city}"  >
<c:out value="${city}" />
</option>
</c:forEach>

</select>

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
Hotel :<select id="demo" name="hotel">
</select>
</div>

<br>
  <p>check-in Date :<input type="date" name="Check_in" ></p>
 
 <br>
  <p>check-out Date :<input type="date" name="Check_out" ></p>      
   	
	
	
	<br><br> <input type="submit" value="Submit">  
	 <a href="index.jsp"><button type="button">cancel</button></a> 

<input type="reset" value="clear"> 
</form>



  







</body>
</html>