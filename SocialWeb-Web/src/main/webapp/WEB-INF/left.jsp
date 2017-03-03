<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/user_wall.css"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="avatar">
</div>
<div class="bottoms">
    <form action="/login" method="get">
        <input class="bottom" type="submit" name="change_avatar" value="аватар">
        <input class="bottom" type="submit" name="bookmark" value="закладки">
        <input class="bottom" type="submit" name="friend" value="друзья">
        <input class="bottom" type="submit" name="setting" value="настройки">
        <input class="bottom" type="submit" name="news" value="новости">
    </form>
</div>
</body>
</html>
