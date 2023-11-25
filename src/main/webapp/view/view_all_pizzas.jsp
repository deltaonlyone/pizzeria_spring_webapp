<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%--    <style>--%>
<%--        /* Загальні стилі */--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f0f0f0;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--        }--%>

<%--        h1 {--%>
<%--            background-color: #333;--%>
<%--            color: #fff;--%>
<%--            padding: 10px;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        h2 {--%>
<%--            background-color: #333;--%>
<%--            color: #fff;--%>
<%--            padding: 10px;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        table {--%>
<%--            border-collapse: collapse;--%>
<%--            width: 100%;--%>
<%--            background-color: #fff;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            border: 1px solid #ddd;--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #333;--%>
<%--            color: #fff;--%>
<%--        }--%>

<%--        tr:nth-child(even) {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>

<%--        /* Кнопки */--%>
<%--        input[type="button"] {--%>
<%--            background-color: #333;--%>
<%--            color: #fff;--%>
<%--            padding: 10px 20px;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            margin: 10px;--%>
<%--        }--%>

<%--        input[type="button"]:hover {--%>
<%--            background-color: #555;--%>
<%--        }--%>

<%--        /* Лінки */--%>
<%--        a {--%>
<%--            text-decoration: none;--%>
<%--            color: #333;--%>
<%--        }--%>

<%--        a:hover {--%>
<%--            color: #555;--%>
<%--        }--%>
<%--    </style>--%>
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
        <c:forEach items="${allPizzas}" var="pizza">
            <tr>
                <td>${pizza.name}</td>
                <td>${pizza.description}</td>
                <td>${pizza.price}</td>
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
