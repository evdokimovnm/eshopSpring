<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration page</title>
</head>

    <body>
    <c:if test="${empty regState}">
        <br><h2 align="center">Registration page</h2>
        <c:if test="${loginOrEmailExist}">
            <p align="center">
                <br>Such login or e-mail already exist, please input another!
                <br>
                <br><a href="/productAll">all products page</a>
            </p>
        </c:if>

        <br><br><p align="center"><b>Please input login and password:</b></p>
        <form:form method="post" commandName="user" action="/registration">
            <table align="center">
                <tr>
                    <td>Login:</td>
                    <td><form:input path="login"/></td>
                    <td><form:errors path="login"/> </td>
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
                    <td></td>
                    <td align="center"><input type="submit" value="Ok"></td>
                </tr>
            </table>
        </form:form>
        <hr>
    </c:if>

    <c:if test="${regState}">
        <p align="center">
            <br>Registration has been successful! Your login is ${user.login}
            <br> You may go to <a href="/productAll">ALL PRODUCTS PAGE</a>
        </p>
    </c:if>

    </body>
</html>
