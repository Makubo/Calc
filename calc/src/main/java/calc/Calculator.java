package calc;

public class Calculator {
	private float number1;
	private float number2;
	private int operation;
	private StringBuilder message = new StringBuilder("");
	
	public Calculator(){
		number1 = 0;
		number2 = 0;
	}
	
	public String calculate(){
		float result = 0;
		
		switch (operation) {
		case 1:{
			result = number1+number2;
			break;
		}
		case 2:{
			result = number1-number2;
			break;
		}
		case 3:{
			result = number1*number2;
			break;
		}
		case 4:{
			result = number1/number2;
			break;
		}
			
		}
		return String.valueOf(result).replaceAll("\\.?0*$", "");
	}
	
	public void setNumber1(String num1){
		try {
			number1 = Float.valueOf(num1);
		} catch (NumberFormatException e){
			message.insert(0, "»спользован неправильный формат первого числа<br>");
		}
	}
	
	public void setNumber2(String num2){
		try {
			number2 = Float.valueOf(num2);
		} catch (NumberFormatException e){
			message.append("»спользован неправильный формат второго числа<br>");
		}
	}
	
	public void setOperation(String oper){
		operation = Integer.valueOf(oper);
	}
	
	public String getNumber1(){
		return String.valueOf(number1).replaceAll("\\.?0*$", "");
	}
	
	public String getNumber2(){
		return String.valueOf(number2).replaceAll("\\.?0*$", "");
	}
	
	public String operationSelectedMarker(int operationID){
		if (operationID == operation) return "selected";
		else return "";
	}
	
	public String message(){
		return message.toString();
	}
	
}
