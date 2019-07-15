<%--
  Created by IntelliJ IDEA.
  User: nev0
  Date: 7/15/2019
  Time: 2:17 AM
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
    <title>Checkout</title>
    <include:css file="base.css"/>
</head>
<body>
    <header></header>
    <div class="nav">
        <%--    <a href="" id="logo"><include:img file="logo.png" alt="My Logo"/> </a>--%>
        <a href="login">Checkout</a>
        <a href="logout">Log out</a>
        <a href="#">Cart : [${cart.getSize()}]</a>
    </div>
    <div class="container1">
        <div class="myList">
            <c:forEach items="${myProducts}" var="product">
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
                        <input type="submit" name="btn1" value ="Remove"/>
                    </form>
              </span>
                    </div>
                </div>
            </c:forEach>
            <a href="success">Confirm checkout</a>
        </div>
        <div class="allProduct">
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
                        <input type="submit" name="btn2" value="Add to cart" />
                    </form>
              </span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <footer>
        <h6>If you need any help contact us <a href="<c:url value="index.jsp"/>"><%= support_email %></a></h6>
    </footer>
</body>
</html>
