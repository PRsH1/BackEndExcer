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
  <h1>영화 등록</h1>
  <div>
    <label>제목</label>
    <input type="text" name="title" value="${ movieEdit.title }" />
  </div>
  <div>
    <label>감독</label>
    <input type="text" name="director" value="${ movieEdit.director }" />
  </div>
  <div>
    <label>장르</label>
    <select name="genre">
      <option value="1" ${ movieEdit.genre == 1 ? "selected" : "" }>SF</option>
      <option value="2" ${ movieEdit.genre == 2 ? "selected" : "" }>액션</option>
      <option value="3" ${ movieEdit.genre == 3 ? "selected" : "" }>드라마</option>
      <option value="4" ${ movieEdit.genre == 4 ? "selected" : "" }>뮤지컬</option>
    </select>
  </div>
  <div>
    <label>년도</label>
    <input type="text" name="year"  value="${ movieEdit.year }"/>
  </div>
  <div>
    <label>국가</label>
    <input type="text" name="country"  value="${ movieEdit.country }"/>
  </div>
  <button type="submit" class="btn">회원가입</button>
</form>

<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
</div>
</body>
</html>
