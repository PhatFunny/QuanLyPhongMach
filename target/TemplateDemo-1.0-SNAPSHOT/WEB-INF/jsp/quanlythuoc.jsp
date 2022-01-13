<%-- 
    Document   : quanlythuoc
    Created on : Sep 8, 2021, 9:03:00 PM
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
<h1 class="text-center text-danger">QUẢN LÝ THUỐC</h1>

<c:url value="/admin/quanlythuoc" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="thuoc">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-group">
        <label for="tenthuoc">Tên thuốc</label>
        <form:input type="text" id="tenthuoc" 
                    path="tenthuoc" cssClass="form-control" />
        <form:errors path="tenthuoc" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="congdung">Công dụng</label>
        <form:input type="text" id="congdung" 
                    path="congdung" cssClass="form-control" />
        <form:errors path="congdung" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="dongia">Đơn giá</label>
        <form:input type="text" id="dongia" 
                    path="dongia" cssClass="form-control" />
        <form:errors path="dongia" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="soluongcon">Số lượng</label>
        <form:input type="number" id="soluongcon" 
                    path="soluongcon" cssClass="form-control" />
        <form:errors path="soluongcon" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="ngaysx">Ngày sản xuất</label>
        <form:input type="date" id="ngaysx" 
                    path="ngaysx" cssClass="form-control" />
        <form:errors path="ngaysx" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="HANSUDUNG">Hạn sử dụng</label>
        <form:input type="date" id="hansudung" 
                    path="hansudung" cssClass="form-control" />
        <form:errors path="hansudung" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="cate">Loại thuốc</label>
        <form:select id="cate" path="loaithuoc" cssClass="form-control">
            <c:forEach items="${loaithuoc}" var="cat">
                <option value="${cat.idloaithuoc}" >${cat.tenloaithuoc}</option>
            </c:forEach>
        </form:select>
        <form:errors path="loaithuoc" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        
        <label for="file">Ảnh thuốc</label>
        <form:input type="file" id="image" 
                    path="file" cssClass="form-control" />
    </div>
        
    <div class="form-group">
        <form:hidden path="idthuoc"/>
        <c:if test="${thuoc.idthuoc > 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="thuoc.update" />" />
        </c:if>
            
        <c:if test="${thuoc.idthuoc <= 0}">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="thuoc.add" />" />
        </c:if>
    </div>

</form:form>
 



