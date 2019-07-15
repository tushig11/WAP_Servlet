<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/15/2019
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="include" uri="/WEB-INF/script.tld" %>

<%
    ServletContext sc = request.getServletContext();
    String support_email = sc.getInitParameter("support-email");
%>

<html>
<head>
    <title>Success</title>
    <include:css file="base.css"/>
    <include:js file="jquery-1.12.4.js"/>
    <include:js file="jquery-ui.js"/>
    <include:js file="base.js"/>
</head>
<body>
    <div class="nav">
        <%--    <a href="" id="logo"><include:img file="logo.png" alt="My Logo"/> </a>--%>
        <a href="#">Hello ${user}</a>
        <a href="login">Checkout</a>
        <c:if test="${user!='Guest'}"><a href="logout">Log out</a></c:if>
        <a href="#">Cart : [${cart.getSize()}]</a>
    </div>
    <div id="success">
        <h1>Thank you! Your order will be shipped soon!</h1>
    </div>
    <div class="container">
        <div class="allProduct">

            <c:forEach items="${myCart.getProducts()}" var="product">
                <div class="product">
                    <a target="_blank" href="#">
                        <include:img file="${product.getPicturePath()}" alt="${product.getPicturePath()}"/>
                    </a>
                    <div class="productTitle"><c:out value="${product.getName()}" /></div>
                    <div class="productDesc">
                        <span class="productPrice">Price: <c:out value="${product.getPrice()}" /></span>
                    </div>
                </div>
            </c:forEach>
            <strong>Total price: </strong>${myCart.getTotal()}
        </div>
    </div>
    <footer>
        <h6>If you need any help contact us <a href="<c:url value="#"/>"><%= support_email %></a></h6>
    </footer>
</body>
</html>
