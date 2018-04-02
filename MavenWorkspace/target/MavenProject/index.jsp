<%--
  Created by IntelliJ IDEA.
  User: zdh
  Date: 4/1/18
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book System</title>
</head>
<body>
    <form action="/book/appoint" method="POST" enctype="application/json">
        <input type="text" id="studentId" name="studentId"/>
        <input type="text" id="bookId" name="bookId"/>
        <input type="submit" id="book"/>
    </form>
</body>
</html>
