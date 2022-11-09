<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { width: 400px; margin: 20px auto; }
  div.radio label { margin-right: 20px; }
  button { padding: 0.4em 2em; margin-top: 10px; }
</style>
</head>
<body>
<div class="container">

  <form method="post">
    <h3>checkbox</h3>
    <div>
      <label>
        <input type="checkbox" name="checkbox1" value="true" ${ checkbox1 ? "checked" : ""} /> 
        <!-- 파라미터는 체크박스 1 value는 true를 서버로 전송 단 체크박스가 체크되어 있지 않고 submit버튼을 눌렀을 경우 아무런 값도 전달되지 않는다 -->
        동의하십니까?
      </label>
    </div>
    <hr />

    <h3>radio - 성별은?</h3>
    <div class="radio">
      <label><input type="radio" name="radio1" value="남" ${ radio1 == "남" ? "checked" : "" } /> 남자</label>
      <label><input type="radio" name="radio1" value="여" ${ radio1 == "여" ? "checked" : "" } /> 여자</label>
    </div>      
    <hr />

    <h3>radio - 혈액형은?</h3>
    <div class="radio">
      <label><input type="radio" name="radio2" value="A" ${ radio2 == "A" ? "checked" : "" } /> A형</label>
      <label><input type="radio" name="radio2" value="B" ${ radio2 == "B" ? "checked" : "" } /> B형</label>
      <label><input type="radio" name="radio2" value="AB" ${ radio2 == "AB" ? "checked" : "" } /> AB형</label>
      <label><input type="radio" name="radio2" value="O" ${ radio2 == "O" ? "checked" : "" } /> O형</label>
    </div>
    <div>
      <button type="submit">확인</button>
    </div>
  </form>
</div>
</body>
</html>
