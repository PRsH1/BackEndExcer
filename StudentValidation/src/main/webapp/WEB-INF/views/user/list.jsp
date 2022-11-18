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
  <h1>책 목록</h1>
  <a href="register" class="btn">회원 등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>사용자 아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>활성화</th>
        <th>사용자유형</th>
        <th>학과 ID</th>
        <th>학과명</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${ users }">
        <tr data-url="edit?id=${ user.id }">
          <td>${ user.id }</td>
          <td>${ user.userid }</td>
          <td>${ user.name }</td>
          <td>${ user.email}</td>
          <td>${ user.email }</td>
          <td>${ user.userType }</td>
          <td>${ user.departmentId }</td>
          <td>${ department	.departmentName }</td>
          
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
