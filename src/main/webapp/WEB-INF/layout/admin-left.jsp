<%-- 
    Document   : admin-left
    Created on : Oct 14, 2021, 9:25:06 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/benhnhan-stats" />">Thống kê số lượng bệnh nhân theo tháng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/benhnhan-year-stats" />">Thống kê số lượng bệnh nhân theo năm</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/doanhthu-stats" />">Thống kê doanh thu theo thuốc</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/doanhthu-month-stats" />">Thống kê doanh thu theo tháng</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/doanhthu-year-stats" />">Thống kê doanh thu theo năm</a>
    </li>
  </ul>

</nav>
