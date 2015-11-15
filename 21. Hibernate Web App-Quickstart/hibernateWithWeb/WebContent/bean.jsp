<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bean</title>
</head>
<body>
	<jsp:useBean id="contact" class="hibernate2.Contact"/>
	<jsp:setProperty name="contact" property="*"/>
	<%
		contact.saveDetails();
		out.println("Inserted data : ");
	 %>
	 <jsp:getProperty name="contact" property="firstName"/>
	 <jsp:getProperty name="contact" property="lastName"/>
	 <jsp:getProperty name="contact" property="email"/>
</body>
</html>