<%-- 
    Document   : doctor
    Created on : Aug 22, 2021, 8:58:15 AM
    Author     : Phat Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<br>
<br>
<br>
<br>
<!-- breadcrumb start-->
    <section class="breadcrumb_part breadcrumb_bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <div class="breadcrumb_iner_item">
                            <h2>doctors</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<!-- breadcrumb start-->

<!--::doctor_part start::-->
<section class="doctor_part single_page_doctor_part">
    <div class="container">
        

        
        <div class="row justify-content-center">
            <div class="col-xl-8">
                <div class="section_tittle text-center">
                    <h2> Experienced Doctors</h2>
                    <p>Face replenish sea good winged bearing years air divide wasHave night male also</p>
                </div>
            </div>
        </div>
        
<!--        Tim Kiem-->
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
                <c:forEach var="page" begin="1" end="${Math.ceil(nhanVienCounter/8)}">
                    <li class="page-item"><a class="page-link" href="<c:url value="/admin/nhanvien" />?page=${page}">${page}</a></li>
                </c:forEach>
            </ul>
        </div>
        
        
        <div class="row">           
            <c:forEach var="nv" items="${nhanvien}">
                <div class="card col-md-3 .bg-light">
                    <div class="card-body">
                        <a href="<c:url value="/admin/nhanvien/${nv.idNV}" />">
                            <c:if test="${nv.hinhanh.startsWith('https')}">
                                <img class="img-fluid" src="${nv.hinhanh}" alt="${nv.tenNV}" />
                            </c:if>
                            <c:if test="${!nv.hinhanh.startsWith('https')}">
                                <img class="img-fluid" src="<c:url value="/images/employee/admin.png" />" alt="${nv.hinhanh}" />
                            </c:if>
                        </a>
                    </div>
                    <div class="card-footer .bg-light">
                        <h4>${nv.tenNV}</h4>
                    </div>

                </div>
            </c:forEach>
        </div>
    </div>
    
    <br><br>
    <div>
        <a href="<c:url value="/admin/quanlynhanvien" />" class="btn btn-warning"><i class="fas fa-user-plus"/>&ensp;Thêm nhân viên</i></a>
    </div>
</section>
<!--::doctor_part end::-->
