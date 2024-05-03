<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-05-02
  Time: 오전 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modify 페이지</title>
</head>
<body>


<form method="post" >
    <input type="hidden" name="no" value="${dto.no}">
    <div>
        <label>제목     :
            <input type="text" placeholder="제목" name="title" value="${dto.title}">
        </label>
    </div>

    <div>
        <label>본문     :
            <textarea name="content" placeholder="본문">${dto.content}</textarea>
        </label>
    </div>
    <button type="submit">수정</button>
</form>

<script>
    <%-- 핵심은 /board/modify로 이동되는 것과 no 값을 전달하는 것 --%>
    document.addEventListener('DOMContentLoaded', function () {
        const btnAdd = document.querySelector('.btnAdd');
        btnAdd.addEventListener('click', function () {
            location.href = '/board/modify?no=${dto.no}';
        });
    });
</script>
<%-- 삭제 기능--%>
<form action="/board/remove" method="post">
    <input type="hidden" name="no" value="${dto.no}">
</form>
<button class="btnRemove">삭제</button>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const btnRemove = document.querySelector('.btnRemove');
        const frm = document.querySelector('form[action="/board/remove"]');

        btnRemove.addEventListener('click', function () {
            if (confirm("삭제하시겠어요?")) {
                frm.submit();
            }
        })
    })
</script>



</body>
</html>
