<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
final int OPERATION_PLUS = 1;
final int OPERATION_MINUS = 2;
final int OPERATION_MULTIPLY =3;
final int OPERATION_DIVIDE = 4;

int selectedID = 1;

String n1 = "";
String n2 = "";
String result = "";

String operationSelectedMarker(int operationID){
	if (operationID == selectedID) return " selected"; 
	else return "";
}
%>

<%
	String action = request.getParameter("action");
		
	if ("calc".equals(action)) {
		selectedID = Integer.valueOf(request.getParameter("operation"));
		n1 = request.getParameter("number1");
		n2 = request.getParameter("number2");
		switch (selectedID){
		case OPERATION_PLUS: result = String.valueOf(Float.valueOf(n1) + Float.valueOf(n2)); break;
		case OPERATION_MINUS: result = String.valueOf(Float.valueOf(n1) - Float.valueOf(n2)); break;
 		case OPERATION_MULTIPLY: result = String.valueOf(Float.valueOf(n1) * Float.valueOf(n2)); break;
 		case OPERATION_DIVIDE: result = String.valueOf(Float.valueOf(n1) / Float.valueOf(n2)); break;
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Калькулятор JSP</title>
</head>
<body>
<form action="">
	<div>
		<input type="text" name="number1" value="<%= n1 %>" />
		<select name="operation">
			<option value="<%= OPERATION_PLUS %>" <%= operationSelectedMarker(OPERATION_PLUS) %>>+</option>
			<option value="<%= OPERATION_MINUS %>" <%= operationSelectedMarker(OPERATION_MINUS) %>>-</option>
			<option value="<%= OPERATION_MULTIPLY %>" <%= operationSelectedMarker(OPERATION_MULTIPLY) %>>x</option>
			<option value="<%= OPERATION_DIVIDE %>" <%= operationSelectedMarker(OPERATION_DIVIDE) %>>:</option>
		</select>
		<input type="text" name="number2" value="<%= n2 %>" />
		<button name="action" value="calc">Посчитать</button>
		<input type="text" name="res" readonly="readonly" value="<%= result %>">
		
	</div>
</form>
<br>
<a href="../index.jsp">На главную</a>
</body>
</html>