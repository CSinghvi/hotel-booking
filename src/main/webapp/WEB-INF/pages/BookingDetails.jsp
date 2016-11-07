<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Details</title>
</head>
<body>
<h1>Booking details</h1>
<br>
<c:forEach items="${hotelDetails1}" var="info">
<c:out value="${info.getHotelName()}"></c:out>
<br>
<c:out value="${info.getAddress()}"></c:out>,<c:out value="${info.getCity()}"></c:out>,<c:out value="${info.getZip()}"></c:out>
<br>
<c:out value="${info.getState()}"></c:out>
<br><br>
<c:out value="${info.getRate()}"></c:out>
<br><br>
<c:out value="${info.getHotelId()}"></c:out>


<form:form action="placeOrder.view?hotelid=${info.getHotelId()}&email=${custDetails.get(0).getEmail()}"  method="post" commandName="reservationDetails">
<div style="position: fixed;left:400px;border:thick;height:400px;width:600px;top:50px;   ">

<c:forEach items="${custDetails}" var="list">
Email : <c:out value="${list.getEmail()}"></c:out>
</c:forEach>
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
<input type="submit" value="Place Reservation">
</form:form>


</c:forEach>


<%-- <c:out value="${hotelDetails1}"></c:out> --%>
</div>

</body>
</html>