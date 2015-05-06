<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
    <body>
    <%--<c:if test="${empty user}">--%>
            <br><br><p align="center"><b>Please input login and password:</b></p>
            <form:form method="post" commandName="user" action="/registration">
                <table>
                    <tr>
                        <td>Login:</td>
                        <td><form:input path="login"/></td>
                        <td><form:errors path="login" cssClass="error"/> </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:input path="password"/></td>
                        <td><form:errors path="password"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Ok"></td>
                    </tr>
                </table>
            </form:form>
            <hr>
            <form action="/registration" method="post">
                <p align="center">
                    <br>Username  :<input type="text" name="login" />
                    <br>Password  :<input type="password" name="password" />
                    <br>
                    <br><b>Please input your E-mail:</b>
                    <br>
                    <br>E-mail  :<input type="text" name="email"/>
                    <br><br><input type="submit" value="Ok" />
                </p>
            </form>
        <%--</c:if>--%>

        <c:if test="${not empty user}">
            <p align="center">
            <br/>Registration has been successful! Your login is ${user.login}
            <br/> You may go to <a href="/productAll.do">ALL PRODUCTS PAGE</a>
            </p>
        </c:if>

    </body>
</html>
