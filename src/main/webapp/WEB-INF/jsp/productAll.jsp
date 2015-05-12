<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>AllProductsPage</title>
    </head>

    <body>

        <br>
        <c:if test="${user.role eq 'manager'}">
            <h1 align="center">Manager version</h1>
        </c:if>
        <br><h2 align="center">ALL PRODUCTS PAGE</h2>

        <br><h3>Choose type of product for getting list with this type</h3>
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
                    <c:if test="${user.role eq 'manager'}">
                    <a href="/productRemove/${productList.id}"> X</a>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
        <c:if test="${user.role eq 'manager'}">
            <br/><b>Add new product:</b>
            <form action="/productAdd" method="post">
                <br>Product name:<input type="text" name="productName">
                <br>Product type:
                    <select name="productType" size="1">
                        <c:forEach var="productTypeList" items="${productTypeList}">
                            <option value="${productTypeList.type}">${productTypeList.type}</option>
                        </c:forEach>
                    </select>
                <br><input type="submit" value="Add">
            </form>
        </c:if>
    </body>
</html>


