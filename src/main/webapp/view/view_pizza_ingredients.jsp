<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Ingredients</title>
</head>
<body>
<h1>All Ingredients</h1>
<c:if test="${not empty pizzaIngredients}">
    <table>
        <thead>
        <tr>
            <th>Назва</th>
            <th>Опис</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pizzaIngredients}" var="ingredient">
             <tr>
                <td>${ingredient.name}</td>
                <td>${ingredient.description}</td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/pizzas/ingredients/remove?pizzaId=${pizzaId}" modelAttribute="cartItem" method="post">
                        <c:forEach var="leftIngredient" items="${pizzaIngredients}" varStatus="status">
                            <c:if test="${ingredient.id != leftIngredient.id}">
                                <form:hidden path="ingredients[${status.index}].id" value="${leftIngredient.id}" />
                            </c:if>
                        </c:forEach>
                        <input type="submit" value="Remove">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="${pageContext.request.contextPath}/cart" modelAttribute="cartItem" method="post">
        <form:hidden path="pizzaId" value="${pizzaId}"/>
        <c:forEach var="ingredient" items="${pizzaIngredients}" varStatus="status">
            <form:hidden path="ingredients[${status.index}].id" value="${ingredient.id}" />
        </c:forEach>
        <input type="submit" value="Add to cart">
    </form:form>
</c:if>
<br>

</body>
</html>
