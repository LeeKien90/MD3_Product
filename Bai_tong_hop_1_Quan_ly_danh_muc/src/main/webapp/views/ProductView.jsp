<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/15/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Created</th>
        <th>Description</th>
        <th>Product Static</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listProduct}" var="pro">
            <tr>
                <td>${pro.productId}</td>
                <td>${pro.productName}</td>
                <td>${pro.price}</td>
                <td><fmt:formatDate value="${pro.created}" pattern="dd-MM-yyyy"/></td>
                <td>${pro.descriptions}</td>
                <td>${pro.productStatus?"Active":"Inactive"}</td>
                <td><a href="<%=request.getContextPath()%>/ProductServlet?productId=${pro.productId}&&action=update">Update</a></td>
                <td><a href="<%=request.getContextPath()%>/ProductServlet?productId=${pro.productId}&&action=delete">Delete</a></td>
            </tr>
        </c:forEach>

    </tbody>
</table>
<a href="views/Created.jsp">Create</a>
</body>
</html>
