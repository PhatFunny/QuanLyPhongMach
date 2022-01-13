<%-- 
    Document   : phieukhambenh-detail
    Created on : Oct 10, 2021, 4:13:31 PM
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
            <c:when test="${phieukhambenh.hinhanh != null && phieukhambenh.hinhanh.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="${phieukhambenh.hinhanh}" alt="${phieukhambenh.hinhanh}" />
            </c:when>
            <c:when test="${phieukhambenh.hinhanh == null || phieukhambenh.hinhanh.startsWith('https') == false}">
                <img class="card-img-top img-fluid" src="<c:url value="images/note.png" />" alt="${phieukhambenh.tenPKB}" />
            </c:when>
        </c:choose>
    </div>
    <div class="col-md-6">
        <h1>${phieukhambenh.tenPKB}</h1>
        <h3>Tên bệnh nhân: ${phieukhambenh.tenbenhnhan}</h3>
        <h3>Tên nhân viên khám: ${phieukhambenh.nhanvien.tenNV}</h3>
        <h3>Triệu chứng: ${phieukhambenh.trieuchung}</h3>
        <h3>Chuẩn đoán: ${phieukhambenh.chandoan}</h3>
        <h3>Ngày khám: ${phieukhambenh.ngaykham}</h3>
        <h3>Lịch hẹn: ${phieukhambenh.lichhen}</h3>
        <h3>Ghi chú: ${phieukhambenh.ghichu}</h3>
        <a href="javascript:;" class="btn btn-danger" onclick="deletePhieuKhamBenh(${phieukhambenh.idPKB})">Xóa</a>
        <a href="<c:url value="/quanlyphieukhambenh/?idPKB=${phieukhambenh.idPKB}" />" class="btn btn-info">Cập nhật</a>
        <br><br>
        <a href="<c:url value="/phieukhambenh" />" class="btn btn-warning"><i class="fas fa-sync-alt"/>&ensp;Reload</i></a>
    </div> 
</div>
    
<script src="<c:url value="/js/main.js" />"></script>

