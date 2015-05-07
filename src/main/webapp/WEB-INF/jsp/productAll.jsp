<%@ page import="net.evdokimov.eshopSpring.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>AllProductsPage</title>
    </head>

    <body>
        <p align="right">
            <c:if test="${empty user}">
                <br><a href="/login/productAll">Login</a>
                <br><a href="/registration">Registration</a>
            </c:if>
            <c:if test="${not empty user}">
                <br/>You are ${user.login}!
                <br><a href="/logout/productAll">Logout</a>
            </c:if>
        </p>
        <hr>
        <br>
        <%
            if (session.getAttribute("user") != null && ((User)session.getAttribute("user")).getRole().equals("manager")) {
        %>
        <h1 align="center">Manager version</h1>
        <%
            }
        %>
        <br/><h2 align="center">ALL PRODUCTS PAGE</h2>

        <br/><h3>Choose type of product for getting list with this type</h3>
        <ul>
            <c:forEach var="productTypeList" items="${productTypeList}">
                <li>
                    <a href="/productChoose/${productTypeList.id}">${productTypeList.type}</a>
                </li>
            </c:forEach>
        </ul>
        <br/><h3>ALL PRODUCTS LIST</h3>
        <ul>
            <c:forEach var="productList" items="${productList}">
                <li>
                    <a href="/product/${productList.id}">${productList.name}</a>
                    <%
                        if (session.getAttribute("user") != null && ((User)session.getAttribute("user")).getRole().equals("manager")) {
                    %>
                    <a href="/productRemove/${productList.id}"> X</a>
                    <%
                        }
                    %>
                </li>
            </c:forEach>
        </ul>



        <%if (session.getAttribute("user") != null && ((User)session.getAttribute("user")).getRole().equals("manager")) { %>
        <br/><b>Add new product:</b>
        <form action="/productAdd" method="post">
            <br/>Product name:<input type="text" name="productName">
            <br/>Product type:
                <select name="productType" size="1">
                    <c:forEach var="productTypeList" items="${productTypeList}">
                        <option value="${productTypeList.type}">${productTypeList.type}</option>
                    </c:forEach>
                </select>
            <br/><input type="submit" value="Add">
        </form>
        <%}%>
    </body>
</html>


