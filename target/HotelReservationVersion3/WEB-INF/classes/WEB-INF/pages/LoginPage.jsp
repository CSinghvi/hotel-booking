<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<script type="text/javascript">

function hotelDetailsSubmission()
{
	document.getElementById("hoteldetails").submit();
	}
</script>
<style>


  .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>

<c:out value="${details}"></c:out>
<p><form:form action="login.view?hotelid=${details}" method="post"  name="hoteldetails"  commandName="loginform" onsubmit="hotelDetailsSubmission()">
<c:set var="hotel" scope="session" value="${details}"/>

<p>Enter your email</p>
<form:input style="padding:5px; " type="email" path="email" placeholder="enter your email" name="email" /></p>
<form:errors path="email" cssClass="error"/>
     <p>Enter your password</p>
      <p><form:input style="padding:5px; " type="password"  path="password" placeholder="enter your password" name="pwd" /></p>
      <form:errors path="password" cssClass="error"/>
    
       <p><input  type="submit" value="Login" name="login" />
       &nbsp;
       <input  type="reset" value="clear"></p>
       </form:form>
<%--        <form action="login.view" id="hoteldetails" method="post"  commandName="details"> --%>
<%--     <input type="hidden" value=<c:out value="${details}"></c:out> name="hotelid"> --%>
<%--     </form> --%>
  <br><br><br>
 <c:out value="${errmsg}"></c:out>      
        
</body>
</html>