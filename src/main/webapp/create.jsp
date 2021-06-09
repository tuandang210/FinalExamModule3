<%--
  Created by IntelliJ IDEA.
  User: 233linhnam
  Date: 6/9/2021
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">
    <table class="table table-striped">
        <thead>
        <tr>
            <th hidden>id</th>
            <td></td>
        </tr>
        <tr>
            <th>name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>price</th>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <th>number</th>
            <td><input type="text" name="number"></td>
        </tr>
        <tr>
            <th>color</th>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <th>intro</th>
            <td><input type="text" name="intro"></td>
        </tr>
        <tr>
            <th>category</th>
            <td><input type="text" name="idCate"></td>
        </tr>
        <tr>
            <th colspan="2"></th>
        </tr>
        </thead>

    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>
