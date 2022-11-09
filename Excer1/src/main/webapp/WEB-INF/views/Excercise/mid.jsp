<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  div.container { width: 600px; margin: 20px auto; }
 
  input { width: 200px; padding: 4px; }
  button { padding: 0.4em 3em; margin-top: 10px; }
  table tr td{
   border: solid 1px gray; width:300px;  height: 20px; border-collapse: collapse; padding: 0px;
  }
</style>
</head>
<body>
  <div class="container">
    <form method="post">
      <h1>연습문제</h1>
      <div>
        <input type="text" name="number1" value="${number1}"/>
        <button type="submit">단</button>
      </div>
      <table>
      	<tr>
      		<td>${number1}x${number2}=${result2}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number3}=${result3}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number4}=${result4}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number5}=${result5}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number6}=${result6}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number7}=${result7}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number8}=${result8}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number9}=${result9}</td>
      	</tr>
      	<tr>
      		<td>${number1}x${number10}=${result10}</td>
      	</tr>
      	
      </table>
     
    </form>
  </div>
</body>
</html>
