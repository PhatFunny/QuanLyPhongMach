<%-- 
    Document   : benhnhan-stats
    Created on : Oct 14, 2021, 9:29:20 AM
    Author     : Phat Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN THEO NĂM</h1>

<div>
  <canvas id="myBenhNhanYearStatsChart"></canvas>
</div>

<br><br>
<table class="table">
    <tr>
        <th>Năm</th>
        <th>Số lượng bệnh nhân</th>
    </tr>
    <c:forEach items="${benhNhanYearStats}" var="dt">
        <tr>
            <td>${dt[0]}</td>
            <td>${dt[1]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let benhnhanLabels=[], benhnhanInfo=[]
    <c:forEach items="${benhNhanYearStats}" var="dt">
        benhnhanLabels.push('${dt[0]}')
        benhnhanInfo.push(${dt[1]})
    </c:forEach>
    
    window.onload = function(){
        benhNhanYearStats("myBenhNhanYearStatsChart", benhnhanLabels, benhnhanInfo)
    }
</script>