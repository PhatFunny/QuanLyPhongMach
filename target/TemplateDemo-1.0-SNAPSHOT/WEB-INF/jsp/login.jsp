<%-- 
    Document   : login
    Created on : Aug 25, 2021, 10:48:33 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br>
<br>
<br>
<br>

<c:url value="/login" var="action"/>

<h1 class="text-center text-danger">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra, vui lòng quay lại sau! 
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập!
    </div>
</c:if>

<form method="post" action="${action}">

    
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng nhập" class="btn btn-danger" />
    </div>
</form>