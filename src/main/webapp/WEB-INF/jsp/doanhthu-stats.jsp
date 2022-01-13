<%-- 
    Document   : doanhthu-stats
    Created on : Oct 14, 2021, 8:33:22 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-justify">THỐNG KÊ DOANH THU THEO THUỐC</h1>

<form action="">
    <div class="form-group">
        <label>Nhập từ khóa</label>
        <input type="text" name="kw" class="form-control" />
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success" />
</form>

<br><br>
<div>
  <canvas id="myDoanhThuStatsChart"></canvas>
</div>

<br><br>
<table class="table">
    <tr>
        <th>Mã thuốc</th>
        <th>Tên thuốc</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${doanhThuStats}" var="dt">
        <tr>
            <td>${dt[0]}</td>
            <td>${dt[1]}</td>
            <td>${dt[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let doanhThuLabels=[], doanhThuInfo=[]
    <c:forEach items="${doanhThuStats}" var="dt">
        doanhThuLabels.push('${dt[1]}')
        doanhThuInfo.push(${dt[2]})
    </c:forEach>
    
    window.onload = function(){
        doanhThuStats("myDoanhThuStatsChart", doanhThuLabels, doanhThuInfo)
    }
</script>
