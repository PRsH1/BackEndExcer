<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 900px; margin: 50px auto; }
    thead th { background-color: #eee; }
    table{ border-collapse: collapse; width: 100%; }
    td, th { padding: 4px; border: 1px solid lightgray; }
    td:nth-child(4) { text-align: center; }
    input { padding: 5px; font-size: 10pt; }
    button { margin: 10px ; padding: 0.4em 2em; }
  </style>
</head>
<body>
<div class="container">
  <form method="post" modelAttribute="product">
    <label>카테고리</label>
    <input type="text" name="srchText" value="${ srchText }" />
    <button type="submit">조회</button>
  </form>
    
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>id</th>
        <th>제품명</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${ products }">
        <tr>
          <td>${ product.id }</td>
          <td>${ product.title }</td>
          <td>${ product.category.title }</td>
          <td>${ product.price }</td>
          <td>${ product.quantity }</td>
          
        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>

