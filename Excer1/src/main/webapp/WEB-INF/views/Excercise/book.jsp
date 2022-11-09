<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { width: 400px; margin: 20px auto; }
  form div { margin-bottom: 20px; }
  label { display: block; }   
  input, select { width: 200px; padding: 5px; }
  button { padding: 0.4em 1.5em; }
  div.error { margin-top: 20px; color: red; }
</style>
</head>
<body>

<div class="container">


<form method="post">
  <h1>책 정보</h1>
  <div>
    <label>제목</label>
    <input type="text" name="title" value="${ book.title }" />
  </div>
  <div>
    <label>저자</label>
    <input type="text" name="name" value="${ book.name }" />
  </div>
  <div>
    <label>출판사</label>
    <input type="text" name="bookMaker"  value="${ book.bookMaker }"/>
  </div>
  <div>
    <label>종류</label>
    <select name="value">
      <option value="0" ${book.value == 0 ? "selected" : ""}>책을 선택하세요</option>
      <option value="1" ${ book.value == 1 ? "selected" : "" }>소설</option>
      <option value="2" ${ book.value == 2 ? "selected" : "" }>수필</option>
      <option value="3" ${ book.value == 3 ? "selected" : "" }>과학</option>
      <option value="4" ${ book.value == 4 ? "selected" : "" }>인문</option>
    </select>
  </div>
  <button type="submit" class="btn">저장</button>
</form>

<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
</div>
</body>
</html>
