<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/user_wall.css"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<div class="all">
    <div class="header">
        <%@include file="logout.jsp"%>
    </div>
    <div class="table">
        <div class="left">
           <%@include file="left.jsp"%>
        </div>
        <div class="right">
            <div class="inform">
                <form action="/login" method="get">
                    <input class="text_name" type="text" name="text_name" value='${name}'  readonly>
                </form>
            </div>
            <div class="wall">
                <div class="post">добавте пост
                    <div class="post_avatar"></div>
                    <form action="/uploadFile" method="post"
                          enctype="multipart/form-data">
                        <input class="post_text" type="text" name="description">
                        <p><input type="file" name="file" multiple accept="image/*,image/jpeg">
                            <input type="submit" value="Отправить"></p>
                        <c:out value="${message}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>
