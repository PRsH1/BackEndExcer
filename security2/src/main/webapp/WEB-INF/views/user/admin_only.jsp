<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">
  <style>
    div.box { padding: 30px; }
  </style>
</head>
<body>
<div class="container">
  <div class="box">
    <h1>관리자 페이지 #2</h1>
    <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>로그인 아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>활성화 여부</th>
        <th>유저 타입</th>
        <th>학과번호</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${ users }">
        <tr>
          <td>${ user.id }</td>
          <td>${ user.loginName}</td>
          <td>${ user.name }</td>
          <td>${ user.email}</td>
          <td>${ user.enabled }</td>
          <td>${ user.userType }</td>
          <td>${ user.departmentId }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
    

    <a class="btn" href="${R}logout_processing">로그아웃</a>
    <a class="btn" href="${R}user/index">뒤로</a>
</div>
</div>
</body>
</html>
