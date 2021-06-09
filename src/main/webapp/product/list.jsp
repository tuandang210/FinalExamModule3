
<%--
  Created by IntelliJ IDEA.
  User: 233linhnam
  Date: 6/9/2021
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
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
<div style="float:left;"><button style="background-color: lightskyblue"><a style="color: white" href="/products?action=create">+Add New Product</a></button></div>
<div style="float: right" class="search-container">
    <form method="post">
        <input type="text" placeholder="Search By Name" name="search">
        <button style="background-color: lightskyblue" type="submit"><i class="fa fa-search">Search</i></button>
    </form>
</div><br>

    <h3 style="clear: left">Product list</h3>


<p style="color: red"><c:out value="${message}"/></p>

 <form method="get">
     <table class="table">
         <thead>
         <tr>
             <th scope="col">#</th>
             <th scope="col">Name</th>
             <th scope="col">Price</th>
             <th scope="col">Number</th>
             <th scope="col">Intro</th>
             <th scope="col">Category id</th>
             <th scope="col" colspan="2">Action</th>
         </tr>
         </thead>
         <tbody>

         <c:forEach items="${products}" var="product">
             <tr>
                 <th scope="row"><c:out value="${product.id}"/></th>
                 <td><c:out value="${product.name}"/></td>
                 <td><c:out value="${product.price}"/></td>
                 <td><c:out value="${product.amount}"/></td>
                 <td><c:out value="${product.detail}"/></td>
                 <td><c:out value="${product.cat_id}"/></td>
                 <td><a href="/products?action=edit&id=${product.id}">Edit</a></td>
                 <td><a href="/products?action=delete&id=${product.id}">Delete</a></td>
             </tr>
         </c:forEach>
         </tbody>
     </table>
 </form>
</body>
</html>