<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lowest Priced hotels</title>
<style>
body{
   content: "";
   position:absolute;
   z-index: -1;
   top: 0;
   bottom: 0;
   left: 0;
   right: 0;
   background-image: url("./Image/activity.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
    opacity: 5;
/*     filter:alpha(opacity=90); */
    height:100%;
    width:100%;
    float:top;
       font-weight: bolder;
    font-family:monospace;
 }
</style>
</head>
<body>
<div style="position:absolute; margin-left:5%;top:10%;">
City: <select id="mySelect" name="choose" onchange="myfunction()" > 
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
		  xhttp.open("GET","getlowestHotel.view?list="+x, true);
		  xhttp.send();
}

</script>

<br><br> 
<div id="demo">

</div>

<br>
<a href="index.jsp"><button type="button">Return to Home Page</button></a> 
</div>
</body>
</html>