<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="calculator" class="calc.Calculator" scope="request">
<jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">
	<div>
		<input type="text" name="number1" value="<%= calculator.getNumber1() %>" />
		<select name="operation">
			<option value="1" <%= calculator.operationSelectedMarker(1) %>>+</option>
			<option value="2" <%= calculator.operationSelectedMarker(2) %>>-</option>
			<option value="3" <%= calculator.operationSelectedMarker(3) %>>x</option>
			<option value="4" <%= calculator.operationSelectedMarker(4) %>>:</option>
		</select>
		<input type="text" name="number2" value="<%= calculator.getNumber2() %>" />
		<button name="action" value="calc">Поcчитать</button>
		<input type="text" name="res" readonly="readonly" value="<%= calculator.calculate() %>">
		<br><%= calculator.message() %>		

	</div>
</form>
</body>
</html>




