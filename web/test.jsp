<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19.10.18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = (String)request.getAttribute("status");
    out.println(name);
%>
</body>
</html>
