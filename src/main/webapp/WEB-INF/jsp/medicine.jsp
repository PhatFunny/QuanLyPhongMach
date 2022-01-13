<%-- 
    Document   : medicine
    Created on : Sep 4, 2021, 10:40:39 AM
    Author     : Phat Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br>
<br>
<br>
<br>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <c:forEach var="cat" items="${loaithuoc}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/medicine/?loaiThuocId=${cat.idloaithuoc}" />">${cat.tenloaithuoc}</a>
            </li>
        </c:forEach>
    </ul>
    
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link " href="<c:url value="/admin/medicine" />">
                <i class="fas fa-sync-alt"/>&ensp;Reload</i>
            </a>
        </li>
    </ul>
    
</nav>
           
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Nhap tu khoa de tim" />
            
        </div>
        &ensp;<input type="submit" value="Search" class="btn btn-danger" />

    </div>
</form>

<div>
    <ul class="pagination">
        <c:forEach var="page" begin="1" end="${Math.ceil(thuocCounter/9)}">
            <li class="page-item"><a class="page-link" href="<c:url value="/admin/medicine" />?page=${page}">${page}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="t" items="${thuoc}">
        <div class="card col-md-3 .bg-light">
            <div class="card-body">
                <a href="<c:url value="/thuoc/${t.idthuoc}" />">
                    <c:if test="${t.hinhthuoc.startsWith('https')}">
                        <img class="img-fluid" src="${t.hinhthuoc}" alt="${t.tenthuoc}" />
                    </c:if>
                    <c:if test="${!t.hinhthuoc.startsWith('https')}">
                        <img class="img-fluid" src="<c:url value="/images/medicine/ThuocDauDau/panadol.png" />" alt="${t.hinhthuoc}" />
                    </c:if>
                </a>
            </div>
            <div class="card-footer .bg-light">
                <h4>${t.tenthuoc}</h4>
            </div>
 
        </div>
    </c:forEach>
</div>
                
                <br><br>
<div>
    <a href="<c:url value="/admin/quanlythuoc" />" class="btn btn-warning"><i class="fas fa-user-plus"/>&ensp;Thêm thuốc mới</i></a>
</div>
