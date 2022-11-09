<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--  taglib="태그 라이브러리 사용함 --> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  div.container { width: 600px;  color:blue;}

</style>
</head>
<body>
  <div class="container">

    <p> <fmt:formatDate pattern = "HH:mm:ss" value = "${ now }" /> </p>
   
  </div>
</body>
</html>
