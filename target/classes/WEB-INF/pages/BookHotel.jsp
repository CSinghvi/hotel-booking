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
<script type="text/javascript">
function myfunction(){
	
	var x = document.getElementById("mySelect").value;
	loadDoc(x);
	
// 	var temp0="<tr><td>Option</td>	<td>Is option correct</td></tr>";

// 	for(i=1;i<=x;i++)
// 		{
// 		 temp0+="<tr><td><input type='text' name='opt"+i+"' onsubmit='return validateForm(name)'></td><td><input type='radio' name='myradio' value='"+i+"'  id="+i+" onsubmit='return validateForm(name)'> </td></tr>";
// 		}
// 	 document.getElementById("demo").innerHTML=temp0;
}

function validateForm(name) {
    var x = document.forms["myform"]["Question"].value;
    if (x == null || x == "") {
        alert(name+" must be filled out");
        return false;
           }
    var y = document.forms["myform"]["choose"].value;
        if (y == "0") {
        alert(y+"Minimum 2 options should be selected");
        return false;
           }
        for(j=1;j<=y;j++)
		{      
        	var comb="opt"+j;
        	var z = document.forms["myform"][comb].value;
    if (z == null || z == "") {
        alert("enter the options");
        return false;
           }
		}
        
        var j;
        var c=0;
        for(j=0;j<y;j++)
        	{
        		var ans=document.getElementsByName("myradio")[j].checked;
        	  		if(ans==true)
        			{
        				c++;
        			}
        	}
        if(!(c==1))
        	{
        	alert("Select answer!!");
        	return false;
        	} 
 
}

</script>

</head>
<body>

<form action="GenerateQuizController" id="form" name="myform" onsubmit="return validateForm(name)" >



City: <select id="mySelect" name="choose"  onchange="myfunction()" > 
<option   id=0   value="0"  >Select</option>

<c:forEach items="${hotelDetails}" var="city">
<option   id=2   value="${city}"  >
<c:out value="${city}" />
</option>
</c:forEach>

</select>



<script>
function loadDoc(city) {
  var xhttp;
  alert(city);
  var url="viewHotel.view?list="+city;
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
  



<div id="demo">
</div>


	
	<br><br><br> <input type="submit" value="Submit">  
	 <a href="index.jsp"><button type="button">cancel</button></a> 

<input type="reset" value="clear"> 
</form>



</body>
</html>