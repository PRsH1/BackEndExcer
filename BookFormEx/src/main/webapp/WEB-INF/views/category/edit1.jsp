<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <style>
    form { width: 700px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    form div { margin: 20px; }
    select { padding: 5px; width: 200px; }
    button { margin: 10px; padding: 0.5em 2em; }
    ul { margin-top: 30px; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="bmodel">
  <!-- modelAttribute의 이름은 model객체의 이름과 같아야 한다 (camelCase지킬것) -->
    <div>
        <form:select path="categoryId1" itemValue="id" itemLabel="categoryName" items="${ categoryies }" />
    </div>
    <div>
        <form:select path="categoryId2">
          <form:option value="0" label="카테고리를 선택하세요" />
          <form:options itemValue="id" itemLabel="categoryName" items="${ categoryies }" />
        </form:select>
    </div>
    <div>
        <form:select path="categoryId3">
          <form:option value="0" label="카테고리를 선택하세요" />
          <form:option value="1" label="소설" />
          <form:option value="2" label="수필" />
          <form:option value="3" label="경제" />
          <form:option value="4" label="과학" />
          <form:option value="5" label="역사" />
        </form:select>
    </div>
    <hr />
    <button type="submit">저장</button>
  </form:form>  
  
  <ul>
    <li>categoryId1 : ${ bmodel.categoryId1 }</li>  
    <li>categoryId2 : ${ bmodel.categoryId2 }</li>  
    <li>categoryId3 : ${ bmodel.categoryId3 }</li>  
    <!-- model class가 Bmodel이므로 이곳에선 bmodel로 적을 것 -->
  </ul>  
</div>
</body>
</html>