<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 600px; margin: 50px auto; }
    body { font-family: 굴림체; }
    table { width: 500px;  border-collapse: collapse; }
    table td:nth-child(1) { background-color: #eee; }
    td { padding: 5px; border: 1px solid lightgray; }   
  </style>
</head>
<body>

<div class="container">

<h1>영화</h1>

<table>
  <tr>
    <td>ID</td>
    <td>${ movie.id }</td>
  </tr>
  <tr>
    <td>제목</td>
    <td>${ movie.title }</td>
  </tr>  <tr>
    <td>감독</td>
    <td>${ movie.director }</td>
  </tr>
  <tr>
    <td>장르</td>
    <td>${ movie.genreName }</td>
  </tr>
  <tr>
    <td>년도</td>
    <td>${ movie.year }</td>
  </tr>
  <tr>
    <td>국가</td>
    <td>${ movie.country }</td>
  </tr>
 
</table>

</div>
</body>
</html>