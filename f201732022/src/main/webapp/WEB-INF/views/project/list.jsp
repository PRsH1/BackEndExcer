<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>프로젝트 목록</h1>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>제목</th>
        <th>매니저 이름</th>
        <th>매니저 전화</th>
        <th>진척도</th>
        <th>우선순위</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="manager" items="${ managers }">
        <tr>
          <td>${ manager.id }</td>
          <td>${ manager.project.title}</td>
          <td>${ manager.name }</td>
          <td>${ manager.phone}</td>
          <td>${ manager.project.progress }</td>
          <td>${ manager.project.priority }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>