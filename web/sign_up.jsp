
<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/15/2019
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="include" uri="/WEB-INF/script.tld" %>
<%
    ServletContext sc = request.getServletContext();
    String support_email = sc.getInitParameter("support-email");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Sign Up</title>
    <include:css file="base.css"/>
</head>
<body>
<h2>Signup Form</h2>
<form action="create" method="post">
    Username: <input type='text' name='username' required/><br/>
    Password: <input name="password" type="password" required/><br/>
    <input type="submit" name="loginBtn" value="Sign Up"/> <a href="login">Login</a>
    <p><strong>${message}</strong></p>
</form>

<footer>
    <h6>If you need any help contact us <a href="<c:url value="#"/>"> <%= support_email %></a></h6>
</footer>
</body>
</html>
