
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="user_wall.css"/>
<a href="http://devcolibri.com/3408"
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<div class="all">
    <div class="header">header
    </div>
    <div class="table">
        <div class="left">
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
        </div>
        <div class="right">
            <div class="inform">
                <form action="/login" method="get">
                    <input class="text_name" type="text" name="text_name" value='${name}'>
                </form>
            </div>
            <div class="wall">
                <div class="post">добавте пост
                    <div class="post_avatar"></div>
                    <form action="/login" method="get">
                        <input class="post_text" type="text" name="text_name" >
                        <p><input type="file" name="photo" multiple accept="image/*,image/jpeg">
                            <input type="submit" value="Отправить"></p>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>