<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Add Page</title>
</head>
<body>
	<form:form action="/create_ninja" method="post" modelAttribute="ninjas">
	    <p>
	        <form:label path="dojo">Dojo:</form:label>
	        <form:errors path="dojo"/>
	        <form:select path="dojo">
	        <c:forEach items="${dojoList}" var="list">
	        	<form:option value="${list.id}" label="${list.name}"/>
	        </c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    <p>
	    	<form:label path="age">Age:</form:label>
	    	<form:errors path="age"/>
	    	<form:input path="age"/>
    	</p>
	    
	    <input type="submit" value="Create"/>
	</form:form>  
</body>
</html>