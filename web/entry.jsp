<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: lubasha
  Date: 20.10.2018
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>ffggg</title>
</head>
<body>
<h2>counter</h2>
<%
    String name = (request.getAttribute("count")).toString();
    out.println(name);

%>
<a href="/database">Назад</a>
<table>
    <tr><th>id</th>
        <th>Town</th>
        <th>Represenation</th>
        <th>Route</th>
        <th>Address</th>
        <th>Goods</th>
        <th>Client</th>
        <th>Transport</th>
        <th>Store</th>
        <th>Status</th>


        <th></th>
    </tr>

    <c:forEach var="lg" items="${requestScope.logistics}">
        h
        <tr><td> ${lg.id}</td> </tr>
        <td>${lg.town}</td>
        <td>${lg.representation}</td>
        <td>${lg.route}</td>
        <td>${lg.address}</td>
        <td>${lg.good}</td>
        <td>${lg.client}</td>
        <td>${lg.transport}</td>
        <td>${lg.store}</td>
        <td>${lg.status}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
