<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Details</title>
<style type="text/css">
table{
	padding:10px; 
}
th,td
{
padding:10px; 
}

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
    opacity: 0.7;
/*     filter:alpha(opacity=90); */
    height:100%;
    width:100%;
    float:top;
    font-weight: bolder;
    font-family:inherit;
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
Booked on &nbsp; <c:out value="${date}"></c:out>
<br><br><br>

<c:forEach items="${reserveList}" var="list">


Your Hotel Booking order id is &nbsp; <c:out value="${list.getConfirmationNumber()}"></c:out>
<br><br><br>
Amount Payable is INR :<c:out value="${list.getBill()}"></c:out>
<br><br>
<table style="padding:2px; ">
<tr><td>Number of rooms Booked</td><td>:<c:out value="${list.getOccupied()}"></c:out></td></tr>
<tr><td>Hotel Name</td><td>:<c:out value="${list.getHotel().getHotelName()}"></c:out></td></tr>
<tr><td>Address</td><td>:<c:out value="${list.getHotel().getAddress()},${list.getHotel().getCity()},${list.getHotel().getState()}"></c:out></td></tr>
<tr><td>Check in Date</td><td>:<c:out value="${list.getCheckIn()}"></c:out></td></tr>
<tr><td>Check out Date</td><td>:<c:out value="${list.getCheckOut()}"></c:out></td></tr>
</table>
<br><br>
<a href="index.jsp">Back to Home</a>


</c:forEach>
</div>
</body>
</html>