<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<link rel ="stylesheet" href="register.css">
<body>
<div class="parent"><h1>エラー</h1></div>
<hr>
<div class="parent"><p>IDもしくはパスワードが空白です</p></div>
<div class="parent"><p>再度、やり直してください</p></div>
<hr>
<div class="parent">
<!-- <a href="/BookShelf/NewLogin?menu=1">ログイン画面へ戻る</a> -->
<jsp:forward page="/WEB-INF/jsp/login.jsp">ログイン画面へ戻る
<%-- <jsp:param name="パラメータ名" value="パラメータ値"/> --%>
</jsp:forward>
</div>
</body>
</html>