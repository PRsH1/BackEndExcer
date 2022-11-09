<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 900px; margin: 50px auto; }
    thead th { background-color: #eee; }
    table{ border-collapse: collapse; width: 100%; text-align: center;}
    td, th { padding: 4px; border: 1px solid lightgray; }
    td:nth-child(4) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>교수 수업 리스트</h1>
  
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>교수 이름</th>
        <th>학과번호</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>연구실</th>
        <th>수업</th>
        <th>강의년도</th>
        <th>강의 학기</th>
        <th>강의실</th>
        <th>교수 번호</th>      
        </tr>
    </thead>
    <tbody>
      <c:forEach var="professor" items="${ professor }">
        <tr>
          <td>${ professor.name }</td>
          <td>${ professor.departmentId }</td>
          <td>${ professor.phone }</td>
          <td>${ professor.email }</td>
           <td>${ professor.office }</td>
           <td>${ professor.title }</td>
           <td>${ professor.year }</td>
           <td>${ professor.semester }</td>
           <td>${ professor.room }</td>
           <td>${ professor.professorId }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>