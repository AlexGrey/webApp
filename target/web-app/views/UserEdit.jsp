<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 24.11.2015
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta lang="ru">
    <title>Редактирование пользователя</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/">Back</a><br>

<form action="${pageContext.servletContext.contextPath}/users/edit/?name=${user.name}" method="post">
    <input type="text" value="${user.name}">
    <input type="submit" value="Изменить">
</form>
<a href="${pageContext.servletContext.contextPath}/users/edit/?name=${user.name}&command=removeUser">Удалить пользователя</a><br>

<form action="${pageContext.servletContext.contextPath}/users/edit/?name=${user.name}" method="post">
    <input type="text" value="${user.pet.name}" name="petName">
    <input type="submit" value="Изменить">
</form>
<a href="${pageContext.servletContext.contextPath}/users/edit/?name=${user.name}&command=removePet">Удалить животного</a><br>


</table>
</body>
</html>
