<%-- 
    Document   : header
    Created on : Aug 3, 2021, 4:05:27 PM
    Author     : Phat Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--::header part start::-->
<header class="main_menu home_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">

                    <a class="navbar-brand" href="index.jsp"> <img class="img-fluid" src="<c:url value="/images/logo.png" />" alt="logo"> </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse main-menu-item justify-content-center"
                        id="navbarSupportedContent">
                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item active">
                                <a class="nav-link" href="<c:url value="/" />">
                                    <i class="fas fa-home"></i>&ensp;Trang chủ
                                </a>
                            </li>
                            
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown"
                                    role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-stethoscope"></i>&ensp;Khám bệnh
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="<c:url value="/phieukhambenh" />"><i class="fas fa-notes-medical"></i>&ensp;
                                        Phiếu khám
                                    </a>
                                    <a class="dropdown-item" href="<c:url value="/toathuoc" />"><i class="far fa-clipboard"></i>&ensp;
                                        Kê toa thuốc
                                        <div class="badge badge-danger" id="toaThuocCounter">${toaThuocCounter}</div>
                                    </a>
                                    <a class="dropdown-item" href="<c:url value="/hoadonthuoc" />"><i class="fas fa-file-invoice-dollar"></i>&ensp;
                                        Hóa đơn thuốc
                                    </a>
                                    <a class="dropdown-item" href="<c:url value="/hosobenhnhan/?idBN=${currentUser.benhnhan.idBN}" />"><i class="fas fa-file-alt"></i>&ensp;
                                        Hồ sơ bệnh nhân
                                    </a>
                                    <a class="dropdown-item" href="<c:url value="/lichkhambenhnhan" />">
                                        <i class="far fa-calendar-alt"></i>&ensp;
                                        Lịch khám bệnh nhân
                                    </a>
                                    <a class="dropdown-item" href="<c:url value="/lichkhamcanhan/?idLK=${currentUser.benhnhan.idBN}" />">
                                        <i class="far fa-calendar-alt"></i>&ensp;
                                        Lịch khám cá nhân
                                    </a>
                                </div>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/medicine"  />"><i class="fas fa-capsules"></i>&ensp;
                                    Thuốc
                                </a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/nhanvien"  />">
                                    <i class="fas fa-user-nurse"></i>&ensp;Nhân viên
                                </a>
                            </li>

                            
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value="/login" />">
                                        <i class="fas fa-user" aria-hidden="true"></i>&ensp;Đăng nhập
                                    </a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value="/register" />">
                                        <i class="fas fa-check" aria-hidden="true"></i>&ensp;Đăng ký
                                    </a>
                                </li>
 
                            </c:if>
                                
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value="/" />">
                                        <c:if test="${currentUser.avatar != null}">
                                            <img style="width:25px;" src="${currentUser.avatar}" class="rounded-circle" />
                                        </c:if>
                                        <c:if test="${currentUser.avatar == null}">
                                            <i class="fas fa-user" aria-hidden="true"></i>
                                        </c:if>
                                        
                                        &ensp;${pageContext.request.userPrincipal.name}
                                    </a>
                                </li>
                                
                                                               
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                                </li>
                            </c:if>

          
                        </ul>
                    </div>
                    <a class="btn_2 d-none d-lg-block" href="<c:url value="/admin/benhnhan-stats" />">THỐNG KÊ</a>
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- Header part end-->
