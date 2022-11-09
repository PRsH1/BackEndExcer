<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { margin: 0 auto;}
  input { width: 200px; padding: 4px; }
  button { padding: 0.4em 2em; margin-top: 10px; }
  div.error { margin-top: 20px; color: red; }
</style>
</head>
<body>
<div class="container">
  <form method="post">
  	<div>
  		<input type="text" name="color1" value="${choice.color1}" />
  	</div>
    <div class="radio">
      <label><input type="radio" name="color2" value="yellow"  ${ choice.color2 == "yellow" ? "checked" : "" }  /> yellow</label>
      <label><input type="radio" name="color2" value="red" ${ choice.color2 == "red" ? "checked" : "" } /> red</label>
      <label><input type="radio" name="color2" value="blue" ${ choice.color2 == "blue" ? "checked" : "" } /> blue</label>
      
    
    </div>
    <div><button type="submit">확인</button></div>
<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
  </form>
</div>
</body>
</html>
