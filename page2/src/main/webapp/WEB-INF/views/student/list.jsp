<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
      form { margin-bottom: 5px; }
      a.btn { float: right; }
  </style>
</head>
<body>
<div class="container">
  <h1>학생 목록</h1>
  <form:form method="get" modelAttribute="pagination">
  <!--   이 폼의 submit 버튼이 클릭되면, 현재 URL이 get 방식으로 서버에 요청된다.
  즉 "student/list" URL이 get 방식으로 서버에 요청된다. -->
    <form:hidden path="pg" value="1" />
    <!--   이 확장 태그에서 의해서 다음과 같은 input 태그가 출력된다.
  <input type="hidden" name="pg" value="1" />
  폼이 submit 될 때, request parameter에 pg=1 값이 포함된다.
  조회 버튼을 누르면 현재 페이지는 언제나 1번으로 변경되어야 한다.
  get 방식 요청이므로, request parameter는 URL의 query string이 된다.
     -->
    <form:hidden path="sz" />
    <!-- 
      이 확장 태그는 아래의 구현과 동일하다.
    <input type="hidden" name="sz" value="${ pagination.sz }" />
  폼이 submit 될 때, request parameter에 sz=## 값이 포함된다.
  ## 부분은 pagination.sz 값이다.
  get 방식 요청이므로, request parameter는 URL의 query string이 된다.
     -->
    <form:select path="od">
      <form:option value="0">정렬 순서</form:option>
      <form:option value="1">학번 순서</form:option>
      <form:option value="2">이름 순서</form:option>
      <form:option value="3">학과명 순서</form:option>
    </form:select>
     
    <span>학과:</span>
    <form:select path="di">
      <form:option value="0">전체</form:option>
      <form:options itemValue="id" itemLabel="name" items="${ departments }" />
      <!-- 
      학과를 선택하기 위한 select 태그가 출력된다.
  	폼이 submit 될 때, request parameter에 di=## 값이 포함된다.
  	## 부분은 선택된 학과의 id 값이다.
  	get 방식 요청이므로, request parameter는 URL의 query string이 된다.
       -->
    </form:select>
    <button type="submit" class="btn">검색</button>
    <a href="create?${pagination.queryString}" class="btn">학생등록</a>
  </form:form>
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>학번</th>
        <th>이름</th>
        <th>학과</th>
        <th>성별</th>
        <th>전화</th>
        <th>이메일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="student" items="${ students }">
        <tr data-url="edit?id=${student.id}&${pagination.queryString}">
          <td>${ student.id }</td>
          <td>${ student.studentNo }</td>
          <td>${ student.name }</td>
          <td>${ student.departmentName }</td>
          <td>${ student.sex }</td>
          <td>${ student.phone }</td>
          <td>${ student.email }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }"
                 queryStringName="pg" />
</div>
</body>
</html>
	