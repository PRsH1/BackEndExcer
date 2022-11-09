<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>
    div.container { width: 600px; margin: auto; }
    form { box-shadow: 0 0 4px lightgray, 2px 2px 4px gray;
      overflow: auto; font-size: 10pt; }      
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    input { padding: 4px; }
    button { padding: 0.4em 2em; margin: 5px 0 20px 20px; }
    div.message { border-radius: 10px; padding: 12px; margin: 10px; 
      background-color: #ffa; border: 1px solid #cc0; }
  </style>
</head>
<body>
  <div class="container">
    <form method="post">
      <div class="title">학생 정보</div>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name="name" value="${ student.name }" /></td>
        </tr>
        <tr>
          <td>학번</td>
          <td><input type="text" name="studentNumber" value="${ student.studentNumber }" /></td>
        </tr>
        <tr>
          <td>birthday</td>
          <fmt:formatDate pattern="yyyy-MM-dd" value="${ student.birthday }" var="b" />
          <td><input type="date" name="birthday" value="${ b }" /></td>
        </tr>
      </table>
      <button type="submit">저장</button>

      <c:if test="${ not empty message }">
        <div class="message">
          ${ message }
        </div>
      </c:if>
    </form>    
 </div>
</body>
</html>
	