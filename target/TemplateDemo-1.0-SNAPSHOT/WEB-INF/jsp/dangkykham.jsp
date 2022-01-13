<%-- 
    Document   : dangkykham
    Created on : Oct 16, 2021, 9:22:13 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<br>
<br>
<br>
<br>
<h1 class="text-center text-success">ĐĂNG KÝ KHÁM</h1>

<form:form method="post" action="${action}" modelAttribute="dangky" >
    
    <div class="form-group">
        <label for="hoten">Họ và tên</label>
        <form:input type="text" id="hoten" path="hoten" class="form-control" />
    </div>

    <div class="form-group">
        <label for="ngaydangky">Ngày hẹn khám</label>
        <form:input type="date" id="ngaydangky" path="ngaydangky" class="form-control" />
    </div>

    <div class="form-group">                
        <label for="cate">Giờ khám</label>
        <br>
        <form:select id="cate" path="giokham" cssClass="form-control">
            <c:forEach items="${giokham}" var="cat">
                <option value="${cat.idgiokham}" >${cat.giokham}</option>
            </c:forEach>
        </form:select>
        <form:errors path="giokham" cssClass="text-danger" />
    </div>

    <br><br>
    <div class="form-group">                
        <label for="cate">Chọn nhân viên khám</label>
        <br>
        <form:select id="cate" path="nhanvien" cssClass="form-control">
            <c:forEach items="${nhanvien}" var="cat">
                <option value="${cat.idNV}" >${cat.tenNV}</option>
            </c:forEach>
        </form:select>
        <form:errors path="nhanvien" cssClass="text-danger" />
    </div>

    <br><br>
    <div class="form-group">
        <input type="submit" value="Đăng ký khám" class="btn btn-danger" />
    </div>
</form:form>

