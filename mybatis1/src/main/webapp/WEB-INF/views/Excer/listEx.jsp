<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>학과목록</h1>
  <a href="create" class="btn">교수조회,등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>교수이름</th>
        <th>소속학과</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="professor" items="${ professor }">
        <tr>
          <td>${ professorEx.id }</td>
          <td><a href="proEdit?id=${ professorEx.id }">${ professorEx.professorName }</a></td>
          <td>${ professorEx.departmentName }	</td>
          <td><a href="delete?id=${ professorEx.id }">삭제</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
