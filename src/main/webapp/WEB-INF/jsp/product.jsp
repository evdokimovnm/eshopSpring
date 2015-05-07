<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <p align="right">
            <c:if test="${empty user}">
                <br><a href="/login/product&${product.id}">Login</a>
                <br><a href="/registration">Registration</a>
            </c:if>
            <c:if test="${not empty user}">
                <br/>You are ${user.login}!
                <br/><a href="/logout/product&${product.id}">Logout</a>
            </c:if>
        </p>
        <hr/>
        <p align="left"><b><a href="/productAll">ALL PRODUCT PAGE</a></b><p>
        <br/>
        <br/>
        <br/>
        <br/><br/>
        <p align="center"> <b>PRODUCT PAGE</b>
        <br>id: ${product.id} <%--EL=Expression Language--%><%--== request.getAttribute("product").getId()--%>
       <%-- <br>id: <%=((Product)request.getAttribute("product")).getId()%>--%> <%--Scriplet--%>
        <br>name: ${product.name}
        <br><a href="/productAddToBucket.do?id=${product.id}">Add to bucket</a>
        </p>
        <br><br><br>
        <b>Products in bucket</b>
        <ul>
            <c:forEach var="productInBucket" items="${productsInBucket}">
                <li>
                    <a href="/product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: =
                        ${productInBucket.value}
                    <a href="/productRemoveFromBucket.do?id=${productInBucket.key.id}&ref=${product.id}">X</a>
                </li>
            </c:forEach>
        </ul>
    <c:if test="${not empty productsInBucket}">
        <br><a href="bucket.jsp">Buy</a>
        <br/><a href="/productRemoveAllFromBucket.do?id=${product.id}">Clean bucket</a>
    </c:if>
    </body>
</html>
