<%-- 
    Document   : medicine-detail
    Created on : Sep 10, 2021, 8:30:44 AM
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
            <c:when test="${thuoc.hinhthuoc != null && thuoc.hinhthuoc.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="${thuoc.hinhthuoc}" alt="${thuoc.tenthuoc}" />
            </c:when>
            <c:when test="${thuoc.hinhthuoc == null || thuoc.hinhthuoc.startsWith('https') == false}">
                <img class="card-img-top img-fluid" src="<c:url value="/images/medicine/ThuocDauDau/panadol.png" />" alt="${thuoc.tenthuoc}" />
            </c:when>
        </c:choose>
    </div>
    <div class="col-md-6">
        <h1>${thuoc.tenthuoc}</h1>
        <h3>Công dụng: ${thuoc.congdung}</h3>
        <h3>Đơn giá: ${thuoc.dongia}</h3>
        <h3>Số lượng: ${thuoc.soluongcon}</h3>
        <h3>Ngày sản xuất: ${thuoc.ngaysx}</h3>
        <h3>Hạn sử dụng: ${thuoc.hansudung}</h3>
        <h3>Cách dùng: ${thuoc.cachdung}</h3>
        <a href="javascript:;" class="btn btn-danger" onclick="deleteThuoc(${thuoc.idthuoc})">Xóa</a>
        <a href="<c:url value="/admin/quanlythuoc/?thuocId=${thuoc.idthuoc}" />" class="btn btn-info">Cập nhật</a>
        <a href="#" class="btn btn-success" onclick="addToToaThuoc(${thuoc.idthuoc}, '${thuoc.tenthuoc}', ${thuoc.dongia}, '${thuoc.cachdung}')">Thêm vào toa thuốc</a><br><br>
        <a href="<c:url value="/admin/medicine" />" class="btn btn-warning"><i class="fas fa-sync-alt"/>&ensp;Reload</i></a>
    </div> 
    
</div>
        
<script src="<c:url value="/js/main.js" />"></script>
