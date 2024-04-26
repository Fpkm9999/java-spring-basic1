<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-04-25
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
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
<!--<h1>Hello, world!</h1>-->
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                        <a class="nav-link" href="#">Features</a>
                        <a class="nav-link" href="#">Pricing</a>
                        <a class="nav-link disabled">Disabled</a>
                    </div>
                </div>
            </div>
        </nav>
        <!--       기존의 헤더 <h1>Header</h1>-->
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
                                <th scope="col">Tno</th>
                                <th scope="col">Title</th>
                                <th scope="col">Writer</th>
                                <th scope="col">DueDate</th>
                                <th scope="col">Finished</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%-- 2024-04-26 2교시 10:05 추가--%>
                            <%--                  <c:forEach var="dto" items="${dtoList}">--%>
                            <%--                    <tr>--%>
                            <%--                      <th scope="row">${dto.tno}</th>--%>
                            <%--                      <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none">${dto.title}</a> </td>--%>
                            <%--                      <td>${dto.writer}</td>--%>
                            <%--                      <td>${dto.dueDate}</td>--%>
                            <%--                      <td>${dto.finished}</td>--%>
                            <%--                    </tr>--%>
                            <%--                  </c:forEach>--%>

                            <c:forEach var="dto" items="${responseDTO.dtoList}">
                                <tr>
                                    <th scope="row">${dto.tno}</th>
                                    <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none">
                                        <c:out value="${dto.title}"/></a></td>
                                    <td>${dto.writer}</td>
                                    <td>${dto.dueDate}</td>
                                    <td>${dto.finished}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <%-- 페이징 처리 2024-04-26 16:34 --%>
                            <%-- https://getbootstrap.com/docs/5.1/components/pagination/ --%>
                        </table>
                            <div class="float-end">
                                <ul class="pagination flex-wrap">
                                    <c:if test="${responseDTO.prev}">
                                        <li class="page-item">
                                            <a class="page-link">Previous</a>
                                        </li>
                                    </c:if>
                                    <c:forEach var="num" begin="${responseDTO.start}" end="${responseDTO.end}">
                                        <li class="page-item"><a class="page-link" href="#">${num}</a> </li>
                                    </c:forEach>
                                    <c:if test="${responseDTO.next}">
                                        <li class="page-item">
                                            <a class="page-link">Next</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>

<%--                            --%>
<%--                            <nav aria-label="...">--%>
<%--                                <ul class="pagination">--%>
<%--                                    <li class="page-item disabled">--%>
<%--                                        <a class="page-link">Previous</a>--%>
<%--                                    </li>--%>
<%--                                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                                    <li class="page-item active" aria-current="page">--%>
<%--                                        <a class="page-link" href="#">2</a>--%>
<%--                                    </li>--%>
<%--                                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                                    <li class="page-item">--%>
<%--                                        <a class="page-link" href="#">Next</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                            </nav>--%>


                        <%--            <h5 class="card-title">Special title treatment</h5>--%>
                        <%--            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>--%>
                        <%--            <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                    </div>
                </div>
            </div>
            <!--            <h1>Content</h1>-->
        </div>
    </div>
    <div class="row footer">
        <!--        <h1>Footer</h1>-->
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>