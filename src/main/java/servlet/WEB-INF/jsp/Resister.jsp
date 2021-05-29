<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<link rel ="stylesheet" href="register.css">
<body>
<form action="/BookShelf/NewLogin" method="post">
<div class="parent">
<h2>新規登録</h2>
</div>
<hr>
<div class="parent">
<p>新規登録します。以下にユーザーIDとパスワードを入力してください。</p></div>
<div class="parent">ユーザーID：<input type="text" name="userID"><br><br></div>
<div class="parent">パスワード：<input type="password" name="pass"><br><br></div>
<div class="parent"><input type="submit" value="登録"></div>

</form>
</body>
</html>