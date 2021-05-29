<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
    <form action="/BookShelf/LoginServlet" method="post">
        ユーザー名：<input type="text" name="userID"><br>
        パスワード：<input type="password" name="pass"><br>
        <input type="submit" value="ログイン">
    </form>
</body>
</html>