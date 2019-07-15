<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/14/2019
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="include" uri="/WEB-INF/script.tld" %>

<%
    ServletContext sc = request.getServletContext();
    String support_email = sc.getInitParameter("support-email");

    Cookie cookie = null;
    Cookie[] cookies = null;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("member")){
                request.setAttribute("user", cookies[i].getValue());
            }
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Login</title>
    <include:css file="base.css"/>
</head>
<body>
    <h2>Login Form</h2>
    <form action="login" method="post">
    Username: <input type='text' name='username' value="<c:if test = "${user != null}"><c:out value = "${user}" /></c:if>"/><br/>
    Password: <input name="password" type="password" /><br/>
    Remember me: <input type='checkbox' name='remember' value='checked' <c:if test = "${user != null}"><c:out value = "checked"/></c:if>/><br/>
        <input type="submit" name="loginBtn" value="Login"/> <a href="create">Sign up</a>
    <p><strong>${message}</strong></p>
    </form>

    <footer>
    <h6>If you need any help contact us <a href="<c:url value="index.jsp"/>"> <%= support_email %></a></h6>
    </footer>
</body>
</html>