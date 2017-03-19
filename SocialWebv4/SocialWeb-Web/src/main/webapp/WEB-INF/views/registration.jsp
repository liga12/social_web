<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/registration" method="post">
    <table>
        <tr>
            <td><input type="text" placeholder="Введите имя" required name="firstname"/></td>
        </tr>
        <tr>
            <td><input type="text" placeholder="Введите фамилию" required name="lastname"/></td>
        </tr>
        <tr>
            <td><input type="text" placeholder="Введите email" required name="email"/></td>
        </tr>
        <tr>
            <td><input type="text" placeholder="Введите логин" required name="login"/></td>
        </tr>
        <tr>
            <td><input type="password" placeholder="Введите пароль" required name="password"/></td>
        </tr>
        <tr>
            <td><input type="password" placeholder="Повторите пароль" required name="passwordtwo"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="registration" value="Регистрация"/>
            </td>
        </tr>
    </table>
</form>
<c:out value="${data}"/>
</body>
</html>
