<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 05.07.2019
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="DBSaveServlet" method="post">
        <p>First name: </p>
        <input type="text" name="firstName" width="50px" />
        <p>Last name: </p>
        <input type="text" name="lastName" width="50px" />
        <p>Phone number: </p>
        <input type="text" name="phoneNumber" width="50px" />
        </br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
