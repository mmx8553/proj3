<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 27.09.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color of square</title>
</head>
<body>
<%String userName = (String) request.getSession().getAttribute("UserNameString").toString();%>
Пользователь : <%=(userName == null ? "Anonymous" : userName )%>
<h1 align="center"> ЦВЕТ #<%=request.getAttribute("color").toString()%></h1>

<table align = center>

    <tr align = center>
        <td  width = 150px height = 150px  bgcolor="#<%=request.getAttribute("color").toString()%>">NoName Text</td>  </tr>
    </table >
<form action = '<%= request.getContextPath()%>/' method = 'post' align = center>
colour = #<input type = 'text' name = 'color'   />
    <input type = 'submit' value = " установить цвет " >
</form>

</br>
</br>
</br>

<form action = '<%= request.getContextPath()%>/listing' method = 'post' align = center>
    Список закрашиваний : <input type = 'submit'  value = " перейти " >
</form>



</body>
</html>
