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
    <title>Добавить пользователя</title>
</head>
<body>
    <a href="${pageContext.servletContext.contextPath}/">Back</a>
    <h1>Добавить пользователя</h1>
    <form action="${pageContext.servletContext.contextPath}/users/add" method="post">
        <input type="text" name="name">
        <input type="text" name="pet">
        <input type="submit">
    </form>
    <p>${result}</p>
</body>
</html>
