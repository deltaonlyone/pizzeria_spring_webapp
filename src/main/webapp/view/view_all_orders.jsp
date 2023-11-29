<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Orders</title>
</head>
<body>

<h2>Orders</h2>

<table border="1">
    <thead>
    <tr>
        <th>Order ID</th>
        <th>User</th>
        <th>Status</th>
        <th>Total Amount</th>
        <th>Date Time</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${allOrders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.user.username}</td>
            <td>${order.status}</td>
            <td>${order.totalAmount}</td>
            <td><fmt:formatDate value="${order.dateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
