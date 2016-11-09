<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serch Page</title>
</head>
<body>
<h1>Search Hotels</h1>
<br><br>
<form action="fetch.view"  >
<label>Search String:</label>
<p><input type="text" name="name"/></p>
<p><input type="submit" value="Find Hotels"></p>
</form>
</body>
</html>