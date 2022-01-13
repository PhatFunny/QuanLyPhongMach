<%-- 
    Document   : quanlynhanvien
    Created on : Oct 7, 2021, 8:44:31 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br>
<br>
<br>
<br>
<h1 class="text-center text-danger">QUẢN LÝ NHÂN VIÊN</h1>

<c:url value="/admin/quanlynhanvien" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="nhanvien">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-group">
        <label for="tenNV">Tên nhân viên</label>
        <form:input type="text" id="tenNV" 
                    path="tenNV" cssClass="form-control" />
        <form:errors path="tenNV" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="ngaysinh">Ngày sinh</label>
        <form:input type="date" id="ngaysinh" 
                    path="ngaysinh" cssClass="form-control" />
        <form:errors path="ngaysinh" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="gioitinh">Giới tính</label>
        <form:input type="text" id="gioitinh" 
                    path="gioitinh" cssClass="form-control" />
        <form:errors path="gioitinh" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="diachi">Địa chỉ</label>
        <form:input type="text" id="diachi" 
                    path="diachi" cssClass="form-control" />
        <form:errors path="diachi" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="sdt">Số điện thoại</label>
        <form:input type="text" id="sdt" 
                    path="sdt" cssClass="form-control" />
        <form:errors path="sdt" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="emailNV">Email</label>
        <form:input type="email" id="emailNV" 
                    path="emailNV" cssClass="form-control" />
        <form:errors path="emailNV" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="cate">Chức vụ</label>
        <br>
        <form:select id="cate" path="chucvu" cssClass="form-control">
            <c:forEach items="${chucvu}" var="cat">
                <option value="${cat.idchucvu}" >${cat.tenchucvu}</option>
            </c:forEach>
        </form:select>
        <form:errors path="chucvu" cssClass="text-danger" />
    </div>
    
    <br><br>
    <div class="form-group">
        <label for="cate">Lịch trực</label>
        <br>
        <form:select id="cate" path="lichtruc" cssClass="form-control">
            <c:forEach items="${lichtruc}" var="cat">
                <option value="${cat.idlichtruc}" >${cat.ngaytruc}</option>
            </c:forEach>
        </form:select>
        <form:errors path="lichtruc" cssClass="text-danger" />
    </div>
    

    
    <br><br>

    <div class="form-group">
        <form:hidden path="idNV"/>
        <c:if test="${nhanvien.idNV > 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="nhanvien.update" />" />
        </c:if>
            
        <c:if test="${nhanvien.idNV <= 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="nhanvien.add" />" />
        </c:if>
    </div>

</form:form>
