<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  div.container { width: 600px; margin: 20px auto; }
  form div { margin-bottom: 10px; }
  input { width: 200px; padding: 4px; }
  button { padding: 0.4em 3em; margin-top: 10px; }
</style>
</head>
<body>
  <div class="container">
    <form method="post">
      <h1>연습문제</h1>
      <div>
        <input type="text" name="parameter" value="${parameter} " readonly/>
        <button type="submit">++</button>
      </div>
     
    </form>
  </div>
</body>
</html>
