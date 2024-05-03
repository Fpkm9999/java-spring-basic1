<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-05-02
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>read 페이지</title>
    <style>
        .container {
            margin-top: 20px;
        }
        .table td, .table th {
            vertical-align: middle;
        }
        .btnAdd, .btnRemove {
            margin-top: 10px;
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h5 class="card-title">조회 페이지</h5>
    <div class="card">
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <th scope="col">Title</th>
                    <td>${dto.title}</td>
                    <th scope="col">Writer</th>
                    <td>${dto.writer}</td>
                    <th scope="col">Hit</th>
                    <td>${dto.hit}</td>
                    <th scope="col">addDate</th>
                    <td>${dto.addDate}</td>
                    <th scope="col">no</th>
                    <td>${dto.no}</td>
                </tr>
            </table>
            <button class="btn btn-primary btnAdd">수정</button>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    <%-- 핵심은 /board/modify로 이동되는 것과 no 값을 전달하는 것 --%>
    document.addEventListener('DOMContentLoaded', function () {
        const btnAdd = document.querySelector('.btnAdd');
        btnAdd.addEventListener('click', function () {
            location.href = '/board/modify?no=${dto.no}';
        });
    });


</script>
</body>
</html>
