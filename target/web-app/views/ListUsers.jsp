<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 24.11.2015
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список Пользователей</title>
</head>
<body>
<h1>Список пользователей</h1>
<a href="${pageContext.servletContext.contextPath}/">Back</a><br>
<table>
    <c:forEach items="${users}"  var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.pet.name}</td>
            <td><a href="/users/edit/?name=${user.name}">Редактировать</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
