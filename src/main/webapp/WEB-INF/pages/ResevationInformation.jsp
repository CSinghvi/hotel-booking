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
</style>
</head>
<body>

Booked on &nbsp; <c:out value="${date}"></c:out>
<br><br><br>
<!-- <table border="1" style="padding:2px; "> -->
<!-- <tr> -->
<!-- <th>Hotel Name</th> -->
<!-- <th>Address</th> -->
<!-- <th>City,State</th> -->
<!-- <th>Check in Date</th> -->
<!-- <th>Check Out Date</th> -->
<!-- <th>Confirmation number</th> -->
<!-- </tr> -->
<!-- </table> -->
<c:forEach items="${reserveList}" var="list">
<!-- <table border="1" style="padding:2px; "> -->
<!-- <tr> -->
<%-- <td><c:out value="${list.getHotel().getHotelName()}"></c:out></td> --%>
<%-- <td><c:out value="${list.getHotel().getAddress()}"></c:out></td> --%>
<%-- <td>${list.getHotel().getCity()},${list.getHotel().getState()}</td> --%>
<%-- <td><c:out value="${list.getCheckIn()}"></c:out></td> --%>
<%-- <td><c:out value="${list.getCheckOut()}"></c:out></td> --%>
<%-- <td><c:out value="${list.getConfirmationNumber()}"></c:out></td> --%>
<%-- <td><c:out value="${list.getHotel().getRate()}"></c:out></td> --%>
<!-- </tr> -->
<!-- </table> -->

Your Hotel Booking order id is &nbsp; <c:out value="${list.getConfirmationNumber()}"></c:out>
<br><br><br>
Amount Payable is INR :<c:out value="${list.getHotel().getRate()}"></c:out>
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

<%-- Email : <c:out value="${list.getEmail()}"></c:out> --%>
</c:forEach>
</body>
</html>