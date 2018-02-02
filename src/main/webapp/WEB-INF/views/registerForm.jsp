<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <h1>Register</h1>
    <sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
        First Name: <sf:input path="firstName" /><sf:errors path="firstName" /><br/>
        Last Name: <sf:input path="lastName" /><br/>
        Username: <sf:input path="username" /><sf:errors path="username" /><br/>
        Password: <sf:password path="password" /><br/>
        <label>Profile Picture</label>:
        <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
        <input type="submit" value="Register"/>
    </sf:form>
</body>
</html>
