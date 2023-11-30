<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Order was created</h1>
<form:form method="get" action="${pageContext.request.contextPath}/">
    <input type="submit" value="Return to home page">
</form:form>
<br>

</body>
</html>
