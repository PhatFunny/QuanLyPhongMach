<%-- 
    Document   : lichkhambenhnhan
    Created on : Oct 20, 2021, 8:40:57 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<br>
<br>
<br>
<h1 class="text-center text-success">LỊCH KHÁM CÁ NHÂN</h1>

<table class="table">
        <tr>
            <th>Mã lịch khám</th>
            <th>Tên bệnh nhân</th>
            <th>Nhân viên khám</th>
            <th>Ngày hẹn khám</th>
            <th>Giờ khám</th>
            <th></th>
        </tr>
        <c:forEach items="dangkykham">
                <tr>
                    <td>${dangkykham.idLK}</td>
                    <td>${dangkykham.benhnhan.tenBN}</td>
                    <td>${dangkykham.nhanvien.tenNV}</td>  
                    <td>${dangkykham.ngaydangky}</td> 
                    <td>${dangkykham.giokham.giokham}</td>
                    <td>
                        <a href="javascript:;" class="btn btn-danger" onclick="deleteLichKham(${dangkykham.idLK})">Hủy lịch khám</a>
                    </td>
                </tr>
        </c:forEach>
</table>

<script src="<c:url value="/js/main.js" />"></script>


