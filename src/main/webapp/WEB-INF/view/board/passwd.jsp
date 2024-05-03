<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-05-01
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>passwd 페이지</title>
</head>
<body>
<h2>${reason == "incorrect" ? "틀린 비밀번호 입니다.":"비밀번호를 입력해주세요!"}</h2>
<form action="/board/passwd" method="post">
    <input type="hidden" name="no" value="${no}">
    <input type="hidden" name="mode" value="${mode}">
    <input type="password" name="passwd" placeholder="비밀번호"><br>
    <input type="submit" value="${mode == "remove" ? "삭제" : "수정"}">
</form>


</body>
</html>