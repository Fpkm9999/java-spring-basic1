<%--
  Created by IntelliJ IDEA.
  User: fpkm9
  Date: 2024-04-30
  Time: 오전 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/test02" method="post">
    <div>
        <span>Title</span>
        <input type="text" name="title">
    </div>
    <div>
        <span>DueDate</span>
        <input type="date" name="dueDate">

    </div>
    <div>
        <span>Writer</span>
        <input type="text" name="writer">
    </div>
    <div>
        <span>Finished</span>
        <input type="checkbox" name="finished">
    </div>
    <div>
<%--        <span>Submit</span>--%>
        <button type="submit">Submit</button>
    </div>

</form>

</body>
</html>
