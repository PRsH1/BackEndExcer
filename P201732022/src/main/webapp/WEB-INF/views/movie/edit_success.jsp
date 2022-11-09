<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { width: 310px; margin: 20px auto; }
  table { width: 300px; border-collapse: collapse; }
  thead tr { background-color: #eee; }
  td, th { border: 1px solid #aaa; padding: 5px; }
  td:nth-child(1) { background-color: #eee; }
</style>  
</head>
<body>

<div class="container">

<h1>영화</h1>

<table>
  <tr>
    <td>ID</td>
    <td>${ movieEdit.id }</td>
  </tr>
  <tr>
    <td>제목</td>
    <td>${ movieEdit.title }</td>
  </tr>
    <tr>
    <td>장르ID</td>
    <td>${ movieEdit.genre }</td>
  </tr>
  <tr>
    <td>감독</td>
    <td>${ movieEdit.director }</td>
  </tr>
  <tr>
    <td>년도</td>
    <td>${ movieEdit.year }</td>
  </tr>
  <tr>
    <td>국가</td>
    <td>${ movieEdit.country }</td>
  </tr>  
</table>

</div>
</body>
</html>
