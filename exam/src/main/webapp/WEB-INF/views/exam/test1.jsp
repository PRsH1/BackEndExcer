<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
	table { width: 200px; height: 20px; border-collapse: collapse;}
	td { border: 1px solid gray; }
</style>
</head>
<body>
    <form method="post">
    <table>
    	<tr>
    		<td>학번</td>
    		<td>${myNumber}</td>
    	</tr>
    	<tr>
    		<td>이름</td>
    		<td>${myName}</td>
    	</tr>
    </table>
   
    </form>
</body>
</html>
