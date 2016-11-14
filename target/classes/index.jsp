<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Reservation</title>
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
 }
</style>
</head>
<body>
<div style="position:absolute; margin-left:5%;top:10%;">
<h1>Welcome to Hotel booking application</h1>
</div>
<div style="position:absolute; margin-left:10%;top:30%;">
<br>
<a href="fetch.view">Book a room</a><br><br>
<br>
<a href="lowest.view">View Lowest Priced Hotels</a><br><br>

</div>
</body>
</html>