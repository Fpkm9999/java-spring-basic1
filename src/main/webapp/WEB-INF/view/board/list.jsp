<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-05-01
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<h1>Board List</h1>
<div class="row content">
    <div class="col">
        <div class="card">
            <div class="card-header">

                <div class="card-body">
                    <%-- 2024-04-25 12:28 작업 --%>
                    <%--  부트5 에서 게시판 코드복붙        --%>
                    <h5 class="card-title">board 게시판</h5>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">no</th>
                            <th scope="col">title</th>
                            <th scope="col">writer</th>
                            <th scope="col">조회수</th>
                            <th scope="col">addDate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="board" items="${dtoList}">
                            <tr>
                                <td>${board.no}</td>
                                <td><a href="/board/read?no=${board.no}" class="text-decoration-none">${board.title}</a>
                                </td>
                                <td>${board.writer}</td>
                                <td>${board.hit}</td>
                                <td>${board.addDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </div>
</div>


</body>
</html>