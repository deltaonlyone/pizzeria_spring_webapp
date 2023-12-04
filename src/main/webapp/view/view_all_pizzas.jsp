<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Pizzas</title>
</head>
<body>
<h1>All Pizzas</h1>
<div>
    <div>
        <input type="button" value="Orders" onclick="window.location.href='${pageContext.request.contextPath}/orders'">

        <input type="button" value="Users" onclick="window.location.href='${pageContext.request.contextPath}/users'">
    </div>
</div>
<c:if test="${not empty allPizzas}">
    <table border="1">
        <thead>
        <tr>
            <th>Назва</th>
            <th>Опис</th>
            <th>Ціна</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allPizzas}" var="pizza">
            <tr>
                <td>${pizza.name}</td>
                <td>${pizza.description}</td>
                <td>${pizza.price}</td>
                <td>
                    <input type="button" value="View ingredients"
                           onclick="window.location.href='${pageContext.request.contextPath}/pizzas/${pizza.id}'">
                </td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/cart" modelAttribute="cartItem" method="post">
                        <form:hidden path="pizzaId" value="${pizza.id}"/>
                        <c:forEach var="ingredient" items="${pizza.ingredients}" varStatus="status">
                            <form:hidden path="ingredients[${status.index}].id" value="${ingredient.id}"/>
                        </c:forEach>
                        <input type="submit" value="Add to cart">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<div>
    <input type="button" value="Cart" onclick="window.location.href='${pageContext.request.contextPath}/cart'">
</div>

</body>
</html>
