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
  <form method="post" modelAttribute="jumoon">
    <label>판매사원명</label>
    <input type="text" name="srchText" value="${ srchText }" />
    <button type="submit">조회</button>
  </form>
    
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>주문id</th>
        <th>제품id</th>
        <th>제품명</th>
        <th>고객id</th>
        <th>고객이름</th>
        <th>주문수량</th>
        <th>판매사원id</th>
        <th>판매사원명</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="jumoon" items="${ jumoons }">
        <tr>
          <td>${ jumoon.id }</td>
          <td>${ jumoon.product.id}</td>
          <td>${ jumoon.product.title }</td>
          <td>${ jumoon.customer.id}</td>
          <td>${ jumoon.customer.name }</td>
          <td>${ jumoon.quantity }</td>
          <td>${ jumoon.customer.salesman.id}</td>
          <td>${ jumoon.customer.salesman.name}</td>
          
        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>
