<%-- 
    Document   : toathuoc
    Created on : Oct 11, 2021, 10:13:02 AM
    Author     : Phat Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<br>
<br>
<br>
<h1 class="text-center text-danger">TOA THUỐC</h1>

<c:if test="${toathuocs == null}">
    <h4 class="text-danger">Không có thuốc nào trong toa</h4>
</c:if>
    
<c:if test="${toathuocs != null}">
    <table class="table">
        <tr>
            <th>Mã thuốc</th>
            <th>Tên thuốc</th>
            <th>Giá thuốc</th>
            <th>Số lượng cần dùng</th>
            <th>Cách dùng</th>
            <th></th>
        </tr>
        <c:forEach items="${toathuocs}" var="t">
            <tr id="toathuoc${t.idthuoc}">
                <td>${t.idthuoc}</td>
                <td>${t.tenthuoc}</td>  
                <td>${t.dongia} VND</td> 
                <td>
                    <div class="form-group">
                        <input type="number" 
                               onblur="updateToaThuoc(this, ${t.idthuoc})"
                               value="${t.quantity}" 
                               class="form-control" />
                    </div>
                </td>
                <td>${t.cachdung}</td> 
                <td>
                    <input type="button" 
                           value="Xóa" 
                           onclick="deleteToaThuoc(${t.idthuoc})"
                           class="btn btn-danger" />
                </td> 
            </tr>
        </c:forEach>
    </table>
    
    <div>
        <h2 class="text-info">Tổng tiền toa thuốc: <span id="amountToaThuoc">${toathuocStarts.amount} VND</span></h2>
    </div>
    
    <input type="button" onclick="thanhtoan()" value="Thanh toán" class="btn btn-danger" />
    <br><br>
</c:if>
    
<script src="<c:url value="/js/main.js" />"></script>

