<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>
<script type="text/javascript">
function hotelDetailsSubmission()
{
	document.getElementById("hoteldetails").submit();
	}
</script>
</head>
<body>
<h1>Hotel Search Results</h1>
<br><br>
<table border="1" >
<tr>
<td>Name</td>
<td>Address</td>
<td>City,State</td>
<td>Zip</td>
<td>Action</td>
</tr>
 <c:forEach items="${hotelDetails}" var="list" varStatus="loop">
 <tr>
 <td><c:out value="${list.getHotelName()}"></c:out></td>
 <td><c:out value="${list.getAddress()}"></c:out></td>
  <td><c:out value="${list.getCity()}"></c:out>, <c:out value="${list.getState()}"></c:out> </td>
   <td><c:out value="${list.getZip()}"></c:out></td>
     <td><a  onclick="loadDoc('${list.getHotelId()}')" href="#" <%--"viewHotel.view?list=${list}"--%>>view details</a></td>   
<%-- <td><form><input type="submit" value="view details"> </form></td> --%>
 </tr>
  </c:forEach>
<script>
function loadDoc(hotel) {
  var xhttp;
  alert(hotel);
  var url="viewHotel.view?list="+hotel;
  if (window.XMLHttpRequest) {
    // code for modern browsers
    xhttp = new XMLHttpRequest();
    } else {
    // code for IE6, IE5
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      document.getElementById("demo").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}
</script>
  
</table>
<div id="demo">
</div>
</body>
</html>