<%-- 
    Document   : nhanvien-detail
    Created on : Oct 7, 2021, 8:25:36 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<br>
<br>
<br>
<div class="row">
    <div class="col-md-6">
        <c:choose>
            <c:when test="${nhanvien.hinhanh != null && nhanvien.hinhanh.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="${nhanvien.hinhanh}" alt="${nhanvien.hinhanh}" />
            </c:when>
            <c:when test="${nhanvien.hinhanh == null || nhanvien.hinhanh.startsWith('https') == false}">
                <img class="card-img-top img-fluid" src="<c:url value="/images/employee/admin.png" />" alt="${nhanvien.tenNV}" />
            </c:when>
        </c:choose>
    </div>
    <div class="col-md-6">
        <h1>${nhanvien.tenNV}</h1>
        <h3>Ngày sinh: ${nhanvien.ngaysinh}</h3>
        <h3>Giới tính: ${nhanvien.gioitinh}</h3>
        <h3>Chức vụ: ${nhanvien.chucvu.tenchucvu}</h3>
        <h3>Địa chỉ: ${nhanvien.diachi}</h3>
        <h3>SDT: ${nhanvien.sdt}</h3>
        <h3>Email: ${nhanvien.emailNV}</h3>
        <h3>Lịch trực: ${nhanvien.lichtruc.ngaytruc}</h3>
        <a href="javascript:;" class="btn btn-danger" onclick="deleteNhanVien(${nhanvien.idNV})">Xóa</a>
        <a href="<c:url value="/admin/quanlynhanvien/?idNV=${nhanvien.idNV}" />" class="btn btn-info">Cập nhật</a>
        <br><br>
        <a href="<c:url value="/admin/nhanvien" />" class="btn btn-warning"><i class="fas fa-sync-alt"/>&ensp;Reload</i></a>
    </div> 
</div>

        
<script src="<c:url value="/js/main.js" />"></script>
