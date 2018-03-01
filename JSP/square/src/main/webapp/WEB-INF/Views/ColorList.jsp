<%@ page import="mosipov.servlets.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="mosipov.servlets.UserVisitBean" %>


<%--
  Created by IntelliJ IDEA.
  User: mmx
  Date: 24.11.2017
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список Цветов - история закрвшивания</title>
</head>
<body>

<%String userName = (String) request.getSession().getAttribute("UserNameString").toString();%>
Пользователь : <%=(userName == null ? "Anonymous" : userName )%>

<form>
    <input type="button" value="Вернуться" onclick="history.back()">
    </input>
</form>

</br>
</br>
</br>

<table align=center border="1">
    <tr>
            <td>Пользователь</td>
            <td>Цвет</td>
            <td>Момент времени</td>
    </tr>



    <% List<UserVisitBean> lst = (List<UserVisitBean>) request.getAttribute("usersList");
        if (lst == null) { %>
            <br> <strong> null List object in Jsp - error </strong>
        <%} else {
            for (UserVisitBean uvb : lst) { %>
            <tr>
                <td><%=uvb.getUser()%></td>
                <td><%=uvb.getColor()%></td>
                <td><%=uvb.getDateOfColorChange()%></td>
            </tr>
            <% }
        } %>


</table>



</body>
</html>
