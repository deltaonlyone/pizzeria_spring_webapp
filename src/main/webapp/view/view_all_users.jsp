<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h1>All Users</h1>
<c:if test="${not empty allUsers}">
    <table border="1">
        <thead>
        <tr>
            <th>Назва</th>
            <th>Пароль</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<br>

</body>
</html>
