<%--
  Created by IntelliJ IDEA.
  User: 233linhnam
  Date: 6/9/2021
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        table {
            border: 1px solid darkgray;
        }
    </style>
</head>
<body>

<button style="background-color: lightskyblue"><a style="color: white" href="/products">Back To Product List</a></button>
    <h3>Edit Product</h3>
    <p style="color: red"><c:out value="${message}"/></p>
    <form method="post">

        <table class="table">
            <thead class="thead-light">
            <tr>
                <th style="text-align: right" scope="col">Property</th>
                <th scope="col">Data</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td></td>
                <td><input type="hidden" name="id" value="${product.id}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Name:</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Price:</td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Number:</td>
                <td><input type="text" name="amount" value="${product.amount}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Intro:</td>
                <td><input type="text" name="detail" value="${product.detail}"></td>
            </tr>
            <tr>
                <th style="text-align: right">Category :</th>
                <td><select style="height: 30px; width: 203px" name="cat_id">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}"><c:out value="${category.name}"/></option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" style="width: 100px; height: 30px" class="btn btn-success">Edit</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>