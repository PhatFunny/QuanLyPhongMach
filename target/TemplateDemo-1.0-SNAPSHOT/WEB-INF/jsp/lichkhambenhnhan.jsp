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
<h1 class="text-center text-success">LỊCH KHÁM BỆNH NHÂN</h1>

<table class="table">
        <tr>
            <th>Mã lịch khám</th>
            <th>Tên bệnh nhân</th>
            <th>Nhân viên khám</th>
            <th>Ngày hẹn khám</th>
            <th>Giờ khám</th>
            <th></th>
        </tr>
        <c:forEach items="${dangky}" var="dk">
            <tr>
                <td>${dk.idLK}</td>
                <td>${dk.hoten}</td>
                <td>${dk.nhanvien.tenNV}</td>  
                <td>${dk.ngaydangky}</td> 
                <td>${dk.giokham.giokham}</td>
                <td>
                    <a href="<c:url value="/guimail" />" class="btn btn-success">Gửi mail</a>
                </td>
            </tr>
        </c:forEach>
</table>


