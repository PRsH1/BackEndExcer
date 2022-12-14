<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    form { width: 600px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    button { margin: 5px 0 20px 20px; }
  </style>
</head>
<body>
  <div class="container">
    <form method="post">
      <div class="title">교수 정보</div>
      <table>
        <tr>
          <td>id</td>
          <td><input type="text" value="${ professorEx.id }" readonly disabled /></td>
        </tr>
        <tr>
          <td>교수 이름</td>
          <td><input type="text" name="name" value="${ professorEx.name }" /></td>
        </tr>
      </table>
      <button type="submit" class="btn">저장</button>
       <c:if test="${ professorEx.id > 0 }">
        <a href="delete?id=${ professorEx.id }" class="btn">삭제</a>
      </c:if>
      
    </form>
 </div>
</body>
</html>
