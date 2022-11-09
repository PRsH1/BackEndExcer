<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { margin: 10px 10px 10px 10px;}
  input { width: 200px; padding: 4px; }
  label { margin-right: 5px; display: inline; padding: 1px;}
  button { padding: 0.4em 2em; margin-top: 10px; }
  div.error { margin-top: 20px; color: red; }
</style>
</head>
<body>
<div class="container">
  <form method="post">
  	<div>
  		<input type="text" name="color1" value="${color1}" />
  	</div>
    
      <label><input type="radio" name="color2" value="yellow" ${ color2 == "yellow" ? "checked" : "" } /> yellow</label>
      <label><input type="radio" name="color2" value="red" ${ color2 == "red" ? "checked" : "" } /> red</label>
      <label><input type="radio" name="color2" value="blue" ${ color2 == "blue" ? "checked" : "" } /> blue</label>
     
    <div><button type="submit">확인</button></div>
<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
  </form>
</div>
</body>
</html>
