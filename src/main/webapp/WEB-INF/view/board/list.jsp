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
                Featured
            </div>
            <div class="card-body">
                <%-- 2024-04-25 12:28 작업 --%>
                <%--  부트5 에서 게시판 코드복붙        --%>
                <h5 class="card-title">Special title treatment</h5>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">no</th>
                        <th scope="col">writer</th>
                        <th scope="col">title</th>
                        <th scope="col">addDate</th>
                        <th scope="col">content</th>
                        <th scope="col">passwd</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="board" items="${dtoList}">
                        <tr>
                            <td>${board.no}</td>
                            <td>${board.writer}</td>
                            <td>${board.title}</td>
                            <td>${board.addDate}</td>
                            <td>${board.content}</td>
                            <td>${board.passwd}</td>

                            <td>${board.hit}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
</body>
</html>