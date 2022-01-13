<%-- 
    Document   : base
    Created on : Aug 3, 2021, 4:01:27 PM
    Author     : Phat Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles"
           uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
                 
    <link rel="icon" href="<c:url value="/images/favicon.png" />">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
    <!-- animate CSS -->
    <link rel="stylesheet" href="<c:url value="/css/animate.css" />">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="<c:url value="/css/owl.carousel.min.css" />">
    <!-- themify CSS -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="<c:url value="/css/flaticon.css" />">
    <!-- magnific popup CSS -->
    <link rel="stylesheet" href="<c:url value="/css/magnific-popup.css" />">
    <!-- nice select CSS -->
    <link rel="stylesheet" href="<c:url value="/css/nice-select.css" />">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="<c:url value="/css/slick.css" />">
    <!-- style CSS -->
    <link rel="stylesheet" href="<c:url value="/css/style.css" />">
    


    <!-- jquery plugins here-->

    <script src="<c:url value="/js/jquery-1.12.1.min.js" />"></script>
    <!-- popper js -->
    <script src="<c:url value="/js/popper.min.js" />"></script>
    <!-- bootstrap js -->
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <!-- owl carousel js -->
    <script src="<c:url value="/js/owl.carousel.min.js" />"></script>
    <script src="<c:url value="/js/jquery.nice-select.min.js" />"></script>
    <!-- contact js -->
    <script src="<c:url value="/js/jquery.ajaxchimp.min.js" />"></script>
    <script src="<c:url value="/js/jquery.form.js" />"></script>
    <script src="<c:url value="/js/jquery.validate.min.js" />"></script>
    <script src="<c:url value="/js/mail-script.js" />"></script>
    <script src="<c:url value="/js/contact.js" />"></script>
    <!-- custom js -->
    <script src="<c:url value="/js/custom.js" />"></script> 
    
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        
    </head>
    <body>
        <h1 class="text-center text-info">TRANG THỐNG KÊ - BÁO CÁO</h1>
        
        <div class="text-center">
            <a class="btn_2 d-none d-lg-block" style="margin-left: 600px; margin-right: 600px"  href="<c:url value="/" />">
                <i class="far fa-hand-point-left" style="font-size: 20px"></i>&ensp;TRỜ VỀ TRANG CHỦ
            </a>
        </div>
        
        <br>
        <div class="container">

            
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <!-- HEADER -->
                    <tiles:insertAttribute name="left" />
                </div>
                <div class="col-md-8 col-xs-12">
                    <!-- CONTENT -->
                    <tiles:insertAttribute name="content" />
                </div>
            </div>

            <!-- FOOTER -->
            <tiles:insertAttribute name="footer" />
        </div>
        
        <script src="<c:url value="/js/stats.js" />"></script> 
    </body>
</html>
