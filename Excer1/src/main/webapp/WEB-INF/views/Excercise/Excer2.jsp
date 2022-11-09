<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  div.container { width: 600px; margin: 20px auto; }
  form div { margin-bottom: 10px; }
  div select {
  width: 300px;
  height:25px;
  }
  input { width: 200px; padding: 4px; }
  button { padding: 0.4em 3em; margin-top: 10px; }
</style>
</head>
<body>
  <div class="container">
    <form method="post">
      <h1>연습문제</h1>
      <div>
	      <select name="number1">
	              <option value="one" ${ number1 == "one" ? "selected" : "" }>one</option>
	              <option value="two" ${ number1 == "two" ? "selected" : "" }>two</option>
	              <option value="three" ${ number1 == "three" ? "selected" : "" }>three</option>
	      </select>
      </div>
      
      <div>
        <input type="text"  value="${number2}" readonly/>
        
      </div>
      <button type="submit">ok</button>
     
    </form>
  </div>
</body>
</html>
