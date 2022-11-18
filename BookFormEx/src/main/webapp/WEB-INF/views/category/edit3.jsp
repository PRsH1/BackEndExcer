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
        <form:checkboxes path="categoryId4" itemValue="id"
                         itemLabel="categoryName" items="${ categoryies }" />
    </div>
    <div class="buttons">
        <form:checkbox path="categoryId5" value="1" label="소설" />
        <form:checkbox path="categoryId5" value="2" label="수필" />
        <form:checkbox path="categoryId5" value="3" label="경제" />
        <form:checkbox path="categoryId5" value="4" label="역사" />
        <form:checkbox path="categoryId5" value="5" label="과학" />
    </div>
    <div>
        <form:checkbox path="enabled" value="true" label="활성화" />
    </div>
    <hr />
    <button type="submit">저장</button>
  </form:form>  
  
  <ul>
    <li>categoryId4 : 
        <c:forEach var="i" items="${bmodel.categoryId4}" >
            ${i}
        </c:forEach>
    </li>  
    <li>categoryId5 : 
        <c:forEach var="i" items="${bmodel.categoryId5}" >
            ${i}
        </c:forEach>
    </li>  
    <li>enabled: ${ bmodel.enabled }</li>  
  </ul>  
</div>
</body>
</html>
