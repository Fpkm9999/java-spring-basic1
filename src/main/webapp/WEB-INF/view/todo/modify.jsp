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
                        <%-- 폼 태그 추가 수정 반영을 위한 --%>
                        <%-- title, duedate 는 수정이 필요하므로 readonly 지운다. finished 도 활성화 하기위해 disabled 지움--%>
                        <form action="/todo/modify" method="post">
                            <%-- --%>
                            <input type="hidden" name="page" value="${pageRequestDTO.page}">
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">

                            <%-- 2024-04-26 09:30 작업 --%>
                            <div class="input-group mb-3">
                                <scan class="input-group-text">Tno</scan>
                                <input type="text" name="tno" class="form-control" value="${dto.tno}" readonly>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">Title</span>
                                <input type="text" name="title" class="form-control" value="${dto.title}">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">DueDate</span>
                                <input type="date" name="dueDate" class="form-control" value="${dto.dueDate}">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">Writer</span>
                                <input type="text" name="writer" class="form-control" value="${dto.writer}" readonly>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    Finished &nbsp;
                                </label>
                                <input type="checkbox" name="finished"
                                       class="form-check-input" ${dto.finished ? "checked" : ""}>
                            </div>
                            <div class="my-4">
                                <div class="float-end">
                                    <%--  modify  페이지 수정 사항 2--%>
                                    <button type="button" class="btn btn-danger">Remove</button>
                                    <button type="button" class="btn btn-primary">Modify</button>
                                    <button type="button" class="btn btn-secondary">List</button>
                                </div>
                            </div>
                        </form>
                        <%-- 2024-04-26 2교시 10:05 추가--%>
                        <script>
                            <%-- 수정 클릭시 이벤트 --%>
                            <%-- modify 버튼 기능 추가--%>
                            const frmModify = document.querySelector("form");

                            document.querySelector(".btn-danger").addEventListener("click", function () {
                                // to1do 안에 remove 로 들어오면 삭제. 방법은 post 방식
                                frmModify.action = '/todo/remove';
                                frmModify.method = 'post';
                                frmModify.submit();
                                // 이제 mapping remove 작업
                            })

                            <%-- 기존 코드 --%>
                            document.querySelector(".btn-primary").addEventListener("click", function () {
                                self.location = "/todo/modify?tno=" + ${dto.tno};
                                <%--self.location = "/todo/modify?tno=" + ${dto.tno} +'&${pageRequestDTO.link}' ;--%>
                                console.log(self.location);
                            });

                            document.querySelector(".btn-secondary").addEventListener("click", function () {
                                // self.location = "/todo/list";
                                self.location = "/todo/list?${pageRequestDTO.link}";

                            })
                        </script>
                        <%-- 체크박스를 위한 폼매터 작업 2024-04-26 12:00 --%>
                        <script>
                            const serverValidResult = {};
                            <c:forEach items="${errors}" var="error">
                            serverValidResult['${error.getField()}'] = '${error.defaultMessage}';

                            </c:forEach>
                            console.log(serverValidResult);
                        </script>
                        <script>
                            const frmView = document.querySelector("form");

                            document.querySelector(".btn-danger").addEventListener("click",function (e){
                                frmView.action = "/todo/remove";
                                frmView.method = "post";
                                frmView.submit();
                            });
                            document.querySelector(".btn-primary").addEventListener("click",function (e) {
                                frmView.action = "/todo/modify";
                                frmView.method = "post";
                                frmView.submit();
                            })

                        </script>
                            <%-- 체크박스를 위한 폼매터 작업 2024-04-26 12:00 END --%>

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