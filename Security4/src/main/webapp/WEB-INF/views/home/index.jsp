<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">  
  <style>
    div.box { padding: 50px; width: 300px; }
  </style>  
</head>
<body>
<div class="container">
  <div class="box">
    <h1>첫 페이지</h1>
  
    <sec:authorize access="not authenticated">  
      <a class="btn" href="${R}login">로컬 로그인</a>
      <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
      <a href="/oauth2/authorization/naver" class="btn btn-secondary active" role="button">Naver Login</a>
      <a href="signUp" class="btn">회원 가입</a>                  
    </sec:authorize>
    <sec:authorize access="authenticated">
      <a class="btn" href="${R}user/index">사용자 페이지</a>
      <a class="btn" href="${R}logout_processing">로그아웃</a>
    </sec:authorize>
  </div>        
</div>
</body>
</html>
