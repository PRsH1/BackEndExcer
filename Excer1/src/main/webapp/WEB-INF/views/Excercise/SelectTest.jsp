<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  div.container { width: 600px; margin: 20px auto; }
  form div { margin-bottom: 10px; }
  select { width: 200px; padding: 4px; }
  button { padding: 0.4em 3em; margin-top: 10px; }
</style>
</head>
<body>
  <div class="container">
    <form method="post">
      <h1>시험대비</h1>

      <div>
        <select name="color">
        	<option value="yellow" ${ color == "yellow" ? "selected" : "" }>yellow</option>
        	<option value="green"${ color == "green" ? "selected" : "" }>green</option>
        	<option value="red"${ color == "red" ? "selected" : "" }>red</option>
        	<option value="blue"${ color == "blue" ? "selected" : "" }>blue</option>
        </select>
        <button type="submit">확인</button>
        
      </div>
      <p>color : ${result }</p>

   
      
     
     
    </form>
  </div>
</body>
</html>
