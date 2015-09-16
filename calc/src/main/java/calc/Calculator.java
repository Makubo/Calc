package calc;

public class Calculator {
	private float number1;
	private float number2;
	private int operation;
	private StringBuilder message = new StringBuilder("");
	int[] error = {0,0};// коды ошибок, 1-й элемент - ошибка в первомм числе, 2-й элемент ошибка во втором числе
						// 0 - все хорошо
						// 1 - неправильный формат
						// 2 - переполнение
						// 3 - отрицательное переполнение
						// 4 - деление на ноль
	
	public Calculator(){
		number1 = 0;
		number2 = 0;
	}
	
	public String calculate(){
		double result = 0;
		
		switch (operation) {
		case 1:{
			result = (double)number1+number2;
			break;
		}
		case 2:{
			result = (double)number1-number2;
			break;
		}
		case 3:{
			result = (double)number1*number2;
			break;
		}
		case 4:{
			if (number2 == 0) {
				error[1] = 4;
				return "";
			} else result = (double)number1/number2;
			break;
		}			
		}
		
		if (!String.valueOf(result).contains("E")){
			return String.valueOf(result).replaceAll("\\.?0*$", "");
		} else return String.valueOf(result);
	}
	
	public void setNumber1(String num1){
		try {
			number1 = Float.valueOf(num1);
			if (Float.POSITIVE_INFINITY == number1) {
				error[0] = 2;
				number1 = Float.MAX_VALUE;
			} else if (Float.NEGATIVE_INFINITY == number1) {
				error[0] = 3;
				number1 = Float.MAX_VALUE*(-1);
			}
		} catch (NumberFormatException e){
			error[0] = 1;
			number1 = 0;
			
		}
	}
	
	public void setNumber2(String num2){
		try {
			number2 = Float.valueOf(num2);
			if (Float.POSITIVE_INFINITY == number2) {
				error[1] = 2;
				number2 = Float.MAX_VALUE;
			} else if (Float.NEGATIVE_INFINITY == number2) { 
				error[1] = 3;
				number2 = Float.MAX_VALUE*(-1);
			}
		} catch (Exception e){
			error[1] = 1;
			number2 = 0;
		}
	}
	
	public void setOperation(String oper){
		operation = Integer.valueOf(oper);
	}
	
	public String getNumber1(){
		String num1 = String.valueOf(number1);
                if (!num1.contains("E")) {
			return num1.replaceAll("\\.?0*$", ""); // удаляем лишние нули после точки
		} else return num1;
	}
	
	public String getNumber2(){
		String num2 = String.valueOf(number2);
                
		if (!num2.contains("E")) {
			return num2.replaceAll("\\.?0*$", "");
		} else return num2;
	}
	
	public String operationSelectedMarker(int operationID){
		if (operationID == operation) return "selected";
		else return "";
	}
	
	public String message(){
		String[] n = new String[2];
		
		switch (operation){
		case 1:{
			n[0] = "первого слогаемого";
			n[1] = "второго слогаемого";
			break;
		}
		case 2:
			n[0] = "уменьшаемого";
			n[1] = "вычитаемого";
			break;
		case 3:
			n[0] = "первого множетеля";
			n[1] = "второго множетеля";
			break;
		case 4:
			n[0] = "делимого";
			n[1] = "делителя";
			break;
		}
		
		for (int i = 0; i < error.length; i++){
			switch (error[i]){
			case 0:{
				break;
			}
			case 1:{
				message.append("Использован неправильный формат ").append(n[i]).append("<br>");
				break;
			}
			case 2:{
				message.append("Положительное переполнение ").append(n[i]).append("<br>");
				break;
			}
			case 3:{
				message.append("Отрицательное переполнение ").append(n[i]).append("<br>");
				break;
			}
			case 4:{
				message.append("Деление на ноль");
			}
			}
		}
		return message.toString();
	}
	
	
}
