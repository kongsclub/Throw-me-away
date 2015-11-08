package com.example.java;

public class CalculatorEngine {
	private final int NUMBER     = 0;
	private final int NUM_OP_NUM = 1;
	
	private int state; // NUMBER or NUM_OP_NUM
	
	private double num1, num2;
	private String op;
	
	public CalculatorEngine() {
		state = NUMBER;
		num1 = 0;
	}
	
	public double numberToDisplay() {
		if (state == NUMBER)
			return num1;
		else // state == NUM_OP_NUM
			return num2;
	}
	
	public void Enter(String word) {
		if (state == NUMBER) {
			if ( word.length() == 1) {
				switch( word.charAt(0) ) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					num1 = num1 * 10 + (word.charAt(0)-'0');
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					state = NUM_OP_NUM;
					op = word;
					num2 = 0;
					break;
				case '=':
					break;
				case 'C':
					num1 = 0;
					break;
				}
			}
		}
		else { // state == NUM_OP_NUM
			if ( word.length() == 1) {
				switch( word.charAt(0) ) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					num2 = num2 * 10 + (word.charAt(0)-'0');
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					doCalc();
					op = word;
					num2 = 0;
					break;
				case '=':
					doCalc();
					state = NUMBER;
					break;
				case 'C':
					num2 = 0;
					break;
				}
			}
		}
	}
	
	private void doCalc() { // In state NUM_OP_NUM
		switch(op.charAt(0)) {
		case '+':
			num1 = num1 + num2;
			break;
		case '-':
			num1 = num1 - num2;
			break;
		case '*':
			num1 = num1 * num2;
			break;
		case '/':
			num1 = num1 / num2;
		}
	}
	
	public static void main(String[] args) {
		CalculatorEngine ce = new CalculatorEngine();
		ce.Enter("4");
		ce.Enter("1");
		ce.Enter("+");
		ce.Enter("5");
		ce.Enter("=");
		if (ce.numberToDisplay() != 46)
			System.err.println("Something wrong in the calculator engine");
	}

}
