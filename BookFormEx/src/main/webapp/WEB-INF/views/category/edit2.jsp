<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}common.css">
  <style>
    form { width: 700px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    form div { margin: 20px; }
    div.buttons label { margin-right: 20px; }
    button { margin: 10px; padding: 0.5em 2em; }
    ul { margin-top: 30px; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="bmodel">
    <div class="buttons">
        <form:radiobuttons path="categoryId1" itemValue="id" 
                           itemLabel="categoryName" items="${ categoryies }" />
                           <!-- path->모델로 들어감 itemValue->DTO에서 받아오는 값 Label->itemValue랑 일치하는 DTO단 Label
                           어디서 받아오나 items (이 경우엔 categoryies에서) -->
    </div>
    <div class="buttons">
        <form:radiobutton path="categoryId2" value="1" label="소설" />
        <form:radiobutton path="categoryId2" value="2" label="수필" />
        <form:radiobutton path="categoryId2" value="3" label="경제" />
        <form:radiobutton path="categoryId2" value="4" label="과학" />
        <form:radiobutton path="categoryId2" value="4" label="역사" />
    </div>
    <hr />
    <button type="submit">저장</button>
  </form:form>  
  
  <ul>
    <li>categoryId1 : ${ bmodel.categoryId1 }</li>  
    <li>categoryId2 : ${ bmodel.categoryId2 }</li>  
  </ul>  
</div>
</body>
</html>
