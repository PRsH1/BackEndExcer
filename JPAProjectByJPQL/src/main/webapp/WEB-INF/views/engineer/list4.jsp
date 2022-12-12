<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>매니저 목록</h1>
  <a href="create" class="btn">엔지니어 등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>이름</th>
        <th>휴대전화</th>
        <th>담당 프로젝트</th>
        <th>사무실</th>
        <th>이메일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="manager" items="${ managers }">
        <tr data-url="edit?id=${ manager.id }">
        <td>${ manager.id}</td>
          <td>${ manager.name}</td>
          <td>${ manager.phone }</td>
          <td var="project" items="${ manager.projects }">${ project.title }</td>
          <td>${ manager.office }</td>
          <td>${ manager.email }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
