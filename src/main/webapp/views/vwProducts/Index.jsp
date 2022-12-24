<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--<jsp:useBean id="category" scope="request" type="com.ute.jee_tuthuchanh.beans.Category"/>--%>
<jsp:useBean id="products" scope="request" type="java.util.List<com.ute.jee_tuthuchanh.beans.Product>"/>

<t:main >
    <jsp:body>
        <div class="card">
            <div class="card-header">
                Products
            </div>
            <c:choose>
                <c:when test="${products.size()==0}">
                    <div class="card-body">
                        <p>Không có dữ liệu.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Product</th>
                                <th>Desciption</th>
                                <th class="text-right">Price</th>
                                <th class="text-right">Quantity</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${products}" var="c">
                                <tr>
                                    <td>${c.proID}</td>
                                    <td>${c.proName}</td>
                                    <td>${c.tinyDes}</td>
                                    <td class="text-right">
                                        <fmt:formatNumber value="${c.price}" type="number" />
                                    </td>
                                    <td class="text-right">${c.quantity}</td>
                                    <td class="text-right">
                                        <a class="btn btn-outline-primary" href="#" role="button">
                                            <i class="fa fa-pencil"aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</t:main>