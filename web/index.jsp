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
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Home</title>

  <%--    Created by custom Tag--%>
  <include:css file="base.css"/>
  <include:js file="jquery-1.12.4.js"/>
  <include:js file="jquery-ui.js"/>
  <include:js file="base.js"/>
</head>

<body>
  <header></header>

  <div class="nav">
<%--    <a href="" id="logo"><include:img file="logo.png" alt="My Logo"/> </a>--%>
    <a href="#">Hello ${user}</a>
    <a href="login">Checkout</a>
    <c:if test="${user!='Guest'}"><a href="logout">Log out</a></c:if>
    <a href="#">Cart : [${cart.getSize()}]</a>
  </div>

  <div class="container">
    <c:forEach items="${products}" var="product">
      <div class="product">
        <a target="_blank" href="#">
          <include:img file="${product.getPicturePath()}" alt="${product.getPicturePath()}"/>
        </a>
        <div class="productTitle"><c:out value="${product.getName()}" /></div>
        <div class="productDesc">
          <span class="productPrice">
            Price: <c:out value="${product.getPrice()}" />
          </span>
          <span class="addToCart">
                <form action="" method="post">
                    <input class="hiddenProd" name="productId" value="${product.getId()}"/>
                    <input type="submit" value ="Add to cart" />
                </form>
          </span>
        </div>
      </div>
    </c:forEach>
  </div>

  <footer>
    <h6>If you need any help contact us <a href="<c:url value="#"/>"><%= support_email %></a></h6>
  </footer>
</body>
</html>