<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/security" method="post">
    <table>
        <tr>
            <td><label for="login">Login</label></td>
            <td><input type="text" placeholder="Введите логин" required name="login" id="login"/></td>
        </tr>

        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" placeholder="Введите пароль" required name="password" id="password"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="enter" value="Ввойти"/>
            </td>
            <%--<td>--%>
                <%--<input type="submit" name="registration" value="Регистрация"/>--%>
            <%--</td>--%>
        </tr>
    </table>
</form>
<form action="/registrationPage" method="post">
    <input type="submit" name="registration" value="Регистрация"/>
</form>
<c:out value='${data}'/>
</body>
</html>
