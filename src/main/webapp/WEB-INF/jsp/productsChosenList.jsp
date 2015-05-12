<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ChosenProductsPage</title>
</head>

<body>
    <p align="right">
        <c:if test="${empty user}">
            <br><a href="/login/productChoose&${from}">Login</a>
            <br><a href="/registration">Registration</a>
        </c:if>
        <c:if test="${not empty user}">
            <br>You are ${user.login}!
            <br><a href="/logout/productChoose&${from}">Logout</a>
        </c:if>
    </p>
    <hr>
    <br>
    <c:if test="${user.role eq 'manager'}">
        <h1 align="center">Manager version</h1>
    </c:if>
    <br><h2>Chosen products</h2>
    <br>
    <ul>
        <c:forEach var="productList" items="${productList}">
            <li>
                <a href="/product/${productList.id}">${productList.name}</a>
                <c:if test="${user.role eq 'manager'}">
                <a href="/productRemove/${productList.id}"> X</a>
                </c:if>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${empty productList}">
        <b>Sorry, we don't have such products now</b>
        <br><a href="/productAll">All products</a>
    </c:if>
</body>
</html>
