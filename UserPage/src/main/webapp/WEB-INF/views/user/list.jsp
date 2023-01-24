<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <style>
      a.btn { float: right; margin: -20px 0 5px 0; }
  </style>
</head>
<body>
<div class="container">
  <h1>학생 목록</h1>
  <a href="create?${pagination.queryString}" class="btn">유저등록</a>
  <!-- 모든 URL의 queryString에 pagination 정보가 들어가 있어야 한다 -->
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>유저 번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>활성화 여부</th>
        <th>유저 타입</th>
        <th>소속 학과</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${ users }">
        <tr data-url="edit?id=${user.id}&${pagination.queryString}">
          <td>${ user.id }</td>
          <td>${ user.userid }</td>
          <td>${ user.name }</td>
          <td>${ user.email }</td>
          <td>${ user.enabled > 0 ? "활성화됨" : "비활성화됨" }</td>
          <td>${ user.userType }</td>
          <td>${ user.departmentName }</td>
          <!-- single valued association 속성 사용 안함
          따라서 user.departmentName 사용 -->
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
                 <!-- sz:페이지 크기 recordCount:학생 레코드 수
                 페이지 수=레코드 수/ 페이지 크기 -->
</div>
</body>
</html>
