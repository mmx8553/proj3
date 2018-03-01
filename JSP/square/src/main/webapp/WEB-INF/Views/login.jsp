<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 04.10.2017
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Первичная регистрация</title>
</head>
<body>
<br>

<form action = '<%= request.getContextPath()%>/login' method = 'post' align = center>
        Пользователь: <input type = "text" name = "name" ><br/>
        <input type = "submit" value = "Начать">
</form>
</body>
</html>
