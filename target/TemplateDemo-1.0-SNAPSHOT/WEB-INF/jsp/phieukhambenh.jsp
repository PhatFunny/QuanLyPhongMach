<%-- 
    Document   : phieukhambenh
    Created on : Oct 10, 2021, 4:11:05 PM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<br>
<br>
<br>

           
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Nhập từ khóa để tìm" />
            
        </div>
        &ensp;<input type="submit" value="Search" class="btn btn-danger" />

    </div>
</form>

<div>
    <ul class="pagination">
        <c:forEach var="page" begin="1" end="${Math.ceil(phieuKhamBenhCounter/9)}">
            <li class="page-item"><a class="page-link" href="<c:url value="/phieukhambenh" />?page=${page}">${page}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="t" items="${phieukhambenh}">
        <div class="card col-md-3 .bg-light">
            <div class="card-body">
                <a href="<c:url value="/phieukhambenh/${t.idPKB}" />">
                    <c:if test="${t.hinhanh.startsWith('https')}">
                        <img class="img-fluid" src="${t.hinhanh}" alt="${t.tenPKB}" />
                    </c:if>
                    <c:if test="${!t.hinhanh.startsWith('https')}">
                        <img class="img-fluid" src="<c:url value="images/note.png" />" alt="${t.hinhanh}" />
                    </c:if>
                </a>
            </div>
            <div class="card-footer .bg-light">
                <h4>${t.tenPKB}</h4>
            </div>
 
        </div>
    </c:forEach>
</div>

<br><br>
<div>
    <a href="<c:url value="/quanlyphieukhambenh" />" class="btn btn-warning"><i class="fas fa-user-plus"/>&ensp;Thêm phiếu khám mới</i></a>
</div>