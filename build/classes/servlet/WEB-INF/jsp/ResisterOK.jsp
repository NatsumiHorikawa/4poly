<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import="model.Login" %>
        <%
        Login loginUser = (Login) session.getAttribute("user");
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録完了</title>
</head>
<link rel ="stylesheet" href="register.css">
<body>
<p>新規登録しました。</p><br>
<hr>
ようこそ<%= loginUser.getUserID() %>さん
<br>
<ul class="list">
<p>持ってるリストへ</p>
<p>欲しいものリストへ</p>
<p><a href ="/BookShelf/NewLogin?menu=2">ログアウト</a></p>
</ul>
</body>
</html>