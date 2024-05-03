<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-05-01
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>등록 페이지</title>
</head>
<body>
<form method="post">
    <div>
        <label>제목     :
            <input type="text" placeholder="제목" name="title">
        </label>
    </div>
    <div>
        <label>작성자   :
            <input type="text" placeholder="작성자" name="writer">
        </label>
    </div>
    <div>
        <label>비밀번호 :
            <input type="password" placeholder="비밀번호" name="passwd">
        </label>
    </div>
    <div>
        <label>
            <textarea name="content" placeholder="본문">본문</textarea>
        </label>
    </div>
    <button type="submit">글쓰기</button>
</form>
</body>
</html>
