<%-- 
    Document   : quanlynhanvien
    Created on : Oct 7, 2021, 8:44:31 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br>
<br>
<br>
<br>
<h1 class="text-center text-danger">QUẢN LÝ PHIẾU KHÁM BỆNH</h1>

<c:url value="/quanlyphieukhambenh" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="phieukhambenh">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-group">
        <label for="tenPKB">Tên phiếu khám</label>
        <form:input type="text" id="tenPKB" 
                    path="tenPKB" cssClass="form-control" />
        <form:errors path="tenPKB" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="tenbenhnhan">Tên bệnh nhân</label>
        <form:input type="text" id="tenbenhnhan" 
                    path="tenbenhnhan" cssClass="form-control" />
        <form:errors path="tenbenhnhan" cssClass="text-danger" />
    </div>

    <div class="form-group">                
        <label for="cate">Nhân viên khám</label>
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
        <label for="trieuchung">Triệu chứng</label>
        <form:input type="text" id="trieuchung" 
                    path="trieuchung" cssClass="form-control" />
        <form:errors path="trieuchung" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="chandoan">Chẩn đoán</label>
        <form:input type="text" id="chandoan" 
                    path="chandoan" cssClass="form-control" />
        <form:errors path="chandoan" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="ghichu">Ghi chú</label>
        <form:input type="text" id="chandoan" 
                    path="ghichu" cssClass="form-control" />
        <form:errors path="ghichu" cssClass="text-danger" />
    </div>

    <div class="form-group">
        <label for="file">Hình ảnh</label>
        <form:input type="file" id="image" 
                    path="file" cssClass="form-control" />
    </div>
    
    <div class="form-group">
        <label for="ngaykham">Ngày khám</label>
        <form:input type="date" id="ngaykham" 
                    path="ngaykham" cssClass="form-control" />
        <form:errors path="ngaykham" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="lichhen">Lịch hẹn</label>
        <form:input type="date" id="lichhen" 
                    path="lichhen" cssClass="form-control" />
        <form:errors path="lichhen" cssClass="text-danger" />
    </div>
      
    
    <div class="form-group">
        <form:hidden path="idPKB"/>
        <c:if test="${phieukhambenh.idPKB > 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="phieukhambenh.update" />" />
        </c:if>
            
        <c:if test="${phieukhambenh.idPKB <= 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="phieukhambenh.add" />" />
        </c:if>
    </div>

</form:form>
