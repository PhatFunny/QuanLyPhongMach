<%-- 
    Document   : doanhthu-month-stats
    Created on : Oct 15, 2021, 8:25:46 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-success">THỐNG KÊ DOANH THU THEO NĂM</h1>

<form action="">
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Báo cáo" class="btn btn-success" />
</form>

<div>
  <canvas id="myDoanhThuYearStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${doanhThuYearStats}" var="dt">
        <tr>
            <td>${dt[0]}</td>
            <td>${dt[1]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let doanhThuLabels=[], doanhThuInfo=[]
    <c:forEach items="${doanhThuYearStats}" var="dt">
        doanhThuLabels.push('${dt[0]}')
        doanhThuInfo.push(${dt[1]})
    </c:forEach>
    
    window.onload = function(){
        doanhThuYearStats("myDoanhThuYearStatsChart", doanhThuLabels, doanhThuInfo)
    }
</script>


