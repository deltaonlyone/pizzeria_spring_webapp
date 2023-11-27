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
<c:if test="${not empty allPizzas}">
    <table>
        <thead>
        <tr>
            <th>Назва</th>
            <th>Опис</th>
            <th>Ціна</th>
        </tr>
        </thead>
        <tbody>
        <input type="button" value="Cart" onclick="window.location.href='/cart'">
        <c:forEach items="${allPizzas}" var="pizza">
            <c:url var="viewIngredients" value="/pizzas/ingredients">
                <c:param name="pizzaId" value="${pizza.id}"/>
            </c:url>
            <tr>
                <td>${pizza.name}</td>
                <td>${pizza.description}</td>
                <td>${pizza.price}</td>
                <td>
                    <input type="button" value="Show ingredients" onclick="window.location.href='${viewIngredients}'">
                </td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/cart" modelAttribute="cartItem" method="post">
                        <form:hidden path="pizzaId" value="${pizza.id}"/>
                        <c:forEach var="ingredient" items="${pizza.ingredients}" varStatus="status">
                            <form:hidden path="ingredients[${status.index}].id" value="${ingredient.id}" />
                        </c:forEach>
                        <input type="submit" value="Add to cart">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<br>

</body>
</html>
