<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel details</title>

<link rel="stylesheet" type="text/css" href="script/pop.css">
<script type="text/javascript">
function hotelDetailsSubmission()
{
	document.getElementById("hoteldetails").submit();
	}
</script>
</head>
<body>
	hello hotel details page
${hotelDetails}


<br>
<button class="pop" id="myBtn">Book Hotel</button>
</div>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">×</span>
      <h2>Login</h2>
    </div>
    <div class="modal-body">
      
      <p><form:form action="login.view" method="post"  name="hoteldetails"  commandName="loginform" onsubmit="hotelDetailsSubmission()"><p>Enter your email</p><form:input style="padding:5px; " type="email" path="email" placeholder="enter your email" name="email" /></p>
     <p>Enter your password</p>
      <p><form:input style="padding:5px; " type="password"  path="password" placeholder="enter your password" name="pwd" /></p>
    </div>
    <div class="modal-footer">
       <p><input class="pop" type="submit" value="Login" name="login" />
       &nbsp;
       <input class="pop" type="reset" value="clear">
       
       </p>
        </form:form>
    </div>
    <form action="login.view" id="hoteldetails" method="post"  commandName="hotelDetails">
    <input type="hidden" value="${hotelDetails}" name=hotelDetails >
    </form>
  </div>
  <script type="text/javascript"  src="script/popup.js">

</script>
  <div>${errmsg}</div>
</body>
</html>