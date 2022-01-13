<%-- 
    Document   : register
    Created on : Aug 26, 2021, 6:27:14 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br>
<br>
<br>
<br>

<h1 class="text-center text-danger">ĐĂNG KÝ</h1>


<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>

    <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <form:password id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" id="avatar" path="file" class="form-control" />
    </div>
    
    <div class="form-group">
        <input type="submit" value="Đăng ký" class="btn btn-danger" />
    </div>
</form:form>
