<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="size" value="${requestScope.listSize}"/>
<c:if test="${size > 0}">
    <table border="1" cellpadding="10" width="100%">
        <tr>
            <td width=\"5%\">Имя автора</td>
            <td width=\"10%\">Отчество автора</td>
            <td>Фамилия автора</td>
            <td width=\"10%\">Название книги</td>
            <td width=\"10%\">Имя</td>
            <td width=\"10%\">Отчество</td>
            <td width=\"10%\">Фамилия</td>
            <td width=\"10%\">Телефон</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="list">
            <tr>
                <td><c:out value="${list.get(0)}"></c:out></td>
                <td><c:out value="${list.get(1)}"></c:out></td>
                <td><c:out value="${list.get(2)}"></c:out></td>
                <td><c:out value="${list.get(3)}"></c:out></td>
                <td><c:out value="${list.get(4)}"></c:out></td>
                <td><c:out value="${list.get(5)}"></c:out></td>
                <td><c:out value="${list.get(6)}"></c:out></td>
                <td><c:out value="${list.get(7)}"></c:out></td>
            </tr>
        </c:forEach>
        <tr>
        </tr>
    </table>
</c:if>
<c:if test="${size < 1}">Ничего не нашел </c:if>
</body>
</html>