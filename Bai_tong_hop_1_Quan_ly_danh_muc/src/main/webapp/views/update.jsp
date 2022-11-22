<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/17/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
    <table border="1px solid">
        <tr>
            <th>Product ID</th>
            <td colspan="2"><input type="number" name="productId" value="${productUpdate.productId}" readonly></td>
        </tr>
        <tr>
            <th>Product Name</th>
            <td colspan="2"><input type="text" name="productName" value="${productUpdate.productName}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td colspan="2"><input type="number" name="price" value="${productUpdate.price}"></td>
        </tr>
        <tr>
            <th>Created</th>
            <td colspan="2"><input type="date" name="created" value="${productUpdate.created}"></td>
        </tr>
        <tr>
            <th>Descriptions</th>
            <td colspan="2"><input type="text" name="descriptions" value="${productUpdate.descriptions}"></td>
        </tr>
<%--        <tr>--%>
<%--            <th>Status</th>--%>
<%--            <td>--%>
<%--                <c:when test="${productUpdate.productStatus}">--%>
<%--                     <input type="radio" name="productStatus" id="active" value="true" checked/><label for="active">Active</label>--%>
<%--                     <input type="radio" name="productStatus" id="inactive" value="false"/><label for="inactive">Inactive</label>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <input type="radio" name="productStatus" id="active" value="true"/><label for="active">Active</label>--%>
<%--                    <input type="radio" name="productStatus" id="inactive" value="false" checked/><label for="inactive">Inactive</label>--%>
<%--                </c:otherwise>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <%--    <button>Create Book</button>--%>
            <td colspan="3" align="center"><input type="submit" value="Update" name="action"></td>
        </tr>
    </table>
</form>

<a href="<%=request.getContextPath()%>/ProductServlet">Trở lại</a>
</body>
</html>
