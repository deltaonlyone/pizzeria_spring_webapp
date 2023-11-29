<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<c:if test="${not empty cart}">
    <table border="1">
        <thead>
        <tr>
            <th>Назва</th>
            <th>Інгредієнти</th>
            <th>Ціна</th>
            <th>Кількість</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart.cartItems}" var="cartItem">
            <tr>
                <td>${cartItem.pizza.name}</td>
                <td>
                    <c:forEach var="ingredient" items="${cartItem.ingredients}">
                        <span>${ingredient.name},&nbsp;</span>
                    </c:forEach>
                </td>
                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${cartItem.price}"/></td>
                <td>${cartItem.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
            Загальна сума: ${cart.countTotalAmount()}
    </div>
    <form:form method="post" action="${pageContext.request.contextPath}/orders">

        <input type="submit" value="Create Order">
    </form:form>
</c:if>
<br>

</body>
</html>
