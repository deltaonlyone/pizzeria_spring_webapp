<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pizza Ingredients</title>
</head>
<body>
<h1>Pizza (${pizzaId}) Ingredients</h1>
<table border="1">
    <!-- Table header -->
    <thead>
    <tr>
        <th>Назва</th>
        <th>Опис</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterating over each ingredient in the pizzaIngredients list -->
    <c:forEach items="${pizzaIngredients}" var="ingredient">
        <!-- Table row for each ingredient -->
        <tr>
            <td>${ingredient.name}</td>
            <td>${ingredient.description}</td>
            <!-- Form for removing the ingredient from the pizza -->
            <td>
                <form:form
                        action="${pageContext.request.contextPath}/pizzas/${pizzaId}/ingredients/${ingredient.id}/remove"
                        modelAttribute="cartItem" method="post">
                    <c:forEach var="ing" items="${pizzaIngredients}" varStatus="status">
                        <!-- Hidden fields for each remaining ingredient -->
                        <form:hidden path="ingredients[${status.index}].id" value="${ing.id}"/>
                    </c:forEach>
                    <!-- Submit button to remove the ingredient -->
                    <input type="submit" value="Remove">
                </form:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <script>
        function onSubmit() {
            const form = document.getElementById("addIngredientForm");
            const ingredientSelect = document.getElementById("addIngredientSelect");
            const ingredientId = ingredientSelect.options[ingredientSelect.selectedIndex].value;
            const url = '${pageContext.request.contextPath}/pizzas/${pizzaId}/ingredients/' + ingredientId + '/add';
            form.setAttribute('action', url);
            form.submit();
        }
    </script>
    <form:form id="addIngredientForm" modelAttribute="cartItem" method="post" onsubmit="onSubmit()">
        <label>Add Ingredient:
            <select id="addIngredientSelect">
                <c:forEach var="ingredient" items="${allIngredients}">
                    <option value="${ingredient.id}">${ingredient.name}</option>
                </c:forEach>
            </select>
            <c:forEach var="ingredient" items="${pizzaIngredients}" varStatus="status">
                <form:hidden path="ingredients[${status.index}].id" value="${ingredient.id}"/>
            </c:forEach>
        </label>
        <input type="submit" value="Add Ingredient">
    </form:form>
</div>

<div>
    <!-- Form for adding the pizza to the cart -->
    <form:form action="${pageContext.request.contextPath}/cart" modelAttribute="cartItem" method="post">
        <form:hidden path="pizzaId" value="${pizzaId}"/>

        <!-- Hidden fields for each ingredient of the pizza -->
        <c:forEach var="ingredient" items="${pizzaIngredients}" varStatus="status">
            <form:hidden path="ingredients[${status.index}].id" value="${ingredient.id}"/>
        </c:forEach>

        <!-- Submit button to add the pizza to the cart -->
        <input type="submit" value="Add to cart">
    </form:form>
</div>
<br>

</body>
</html>
