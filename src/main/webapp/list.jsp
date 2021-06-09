<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 233linhnam
  Date: 6/9/2021
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            text-align: center;
        }

        tr:hover {
            background-color: #e3f2fd;
        }

        a:hover {
            color: red;
        }

        b:hover {
            color: red;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        th {
            text-align: center;
        }

        button {
            margin-top: 14px;
            border: 0;
            margin-right: 10px;
            color: #9d9d9d;
            background-color: #222222;
        }

        button:hover {
            color: white;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<button style="background-color: aqua">Add new Product</button>
<table class="table table-striped">
    <thead>
    <tr>
        <th hidden>id</th>
        <th>name</th>
        <th>price</th>
        <th>number</th>
        <th>color</th>
        <th>intro</th>
        <th>category</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td hidden><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.number}"/></td>
            <td><c:out value="${product.color}"/></td>
            <td><c:out value="${product.intro}"/></td>
            <td><c:out value="${product.idCate}"/></td>
            <td style="background-color: yellow;color: black"><a href="/products?action=edit&id=${product.id}">Edit</a></td>
            <td style="background-color: red;color: black"><a href="/products?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
