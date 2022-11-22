<%--
  Created by IntelliJ IDEA.
  User: askih
  Date: 11/16/2022
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
    <table border="1px solid">
        <tr>
            <th>Product ID</th>
            <td colspan="2"><input type="number" name="productId"></td>
        </tr>
        <tr>
            <th>Product Name</th>
            <td colspan="2"><input type="text" name="productName"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td colspan="2"><input type="number" name="price"></td>
        </tr>
        <tr>
            <th>Created</th>
            <td colspan="2"><input type="date" name="created"></td>
        </tr>
        <tr>
            <th>Descriptions</th>
            <td colspan="2"><input type="text" name="descriptions"></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="radio" name="productStatus" id="active" value="true" checked><label for="active">Active</label></td>
            <td><input type="radio" name="productStatus" id="inactive" value="false"><label for="inactive">Inactive</label></td>
        </tr>
        <tr>
            <%--    <button>Create Book</button>--%>
            <td colspan="3" align="center"><input type="submit" value="Create" name="action"></td>
        </tr>
    </table>
</form>

<a href="<%=request.getContextPath()%>/ProductServlet">Trở lại</a>
</body>
</html>
