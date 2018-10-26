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
    <title>Entry</title>
</head>
<body>
=<%--<%--%>
    <%--String name = (request.getAttribute("count")).toString();--%>
    <%--out.println(name);--%>

<%--%>--%>
<a href="/database">Назад</a>
<form action="${pageContext.request.contextPath}/entry" method="post">

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
<tr>
        <td> ${lg.id}</td>
        <td> <input  name="town" value="${lg.town}"/></td>
        <td><input  id="representation" value="${lg.representation}"/></td>
        <td><input  id="route" value="${lg.route}"/></td>
        <td>

            <select name = "address">

                        <option value="${lg.address}" selected>${lg.address}</option>
                        <c:forEach items="${adrs}" var="adr">
                            <c:if test="${adr != lg.address}">
                                <option value="${adr}">${adr}</option>
                            </c:if>
                        </c:forEach>


            </select>
        </td>
        <%--<td>${lg.good}</td>--%>
    <td>

        <select name = "good">

            <option value="${lg.good}" selected>${lg.good}</option>
            <c:forEach items="${goods}" var="good">
                <c:if test="${good != lg.good}">
                    <option value="${good}">${good}</option>
                </c:if>
            </c:forEach>


        </select>
    </td>
        <%--<td>${lg.client}</td>--%>
    <td>

        <select name = "clients">

            <option value="${lg.client}" selected>${lg.client}</option>
            <c:forEach items="${clients}" var="client">
                <c:if test="${client != lg.client}">
                    <option value="${client}">${client}</option>
                </c:if>
            </c:forEach>


        </select>
    </td>
        <%--<td>${lg.transport}</td>--%>
    <td>

        <select name = "transport">

            <option value="${lg.transport}" selected>${lg.transport}</option>
            <c:forEach items="${transports}" var="tr">
                <c:if test="${tr != lg.transport}">
                    <option value="${tr}">${tr}</option>
                </c:if>
            </c:forEach>


        </select>
    </td>
        <%--<td>${lg.store}</td>--%>
    <td>

        <select name = "store">

            <option value="${lg.store}" selected>${lg.store}</option>
            <c:forEach items="${stores}" var="store">
                <c:if test="${store != lg.store}">
                    <option value="${store}">${store}</option>
                </c:if>
            </c:forEach>


        </select>
    </td>
        <%--<td>${lg.status}</td>--%>

    <td>

        <select name = "status">

            <option value="${lg.status}" selected>${lg.status}</option>
            <c:forEach items="${status}" var="stat">
                <c:if test="${stat != lg.status}">
                    <option value="${stat}">${stat}</option>
                </c:if>
            </c:forEach>


        </select>
    </td>

</tr>
    </c:forEach>
</table>
    <button type="submit" name="button" value="buttonEdit">Save</button>

</form>
</body>
</html>
