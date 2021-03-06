//Brooke Werner

import java.util.ArrayList;

import queue.*;
import stack.*;

public class InfixCalc {
	protected MyQueue<String> outputQueue;
	protected MyStack<String> operatorStack;
	protected ArrayList<String> inputArray;
	
	public InfixCalc(ArrayList<String> input) {
		outputQueue = new MyQueue<String>();
		operatorStack = new MyStack<String>();
		inputArray = input;
		
		convertInfixToPostfix(input);
		evaluatePostfixExp();
	}
	
	public String answer(){
		return operatorStack.peek();
	}
	
	//beginning of methods that convert from infix to postfix
	
	public void convertInfixToPostfix(ArrayList<String> input) {
		for (String s: input) {
			if (checkForOperator(s) && operatorStack.isEmpty()) {
				operatorStack.push(s);
			} else {
				readInput(s);
			}
		}
		
		popAllStackAndEnqueue();
		
		//after this the queue has the postfix expression for calculation
	}
	
	public boolean checkForOperator(String input) {
		if (input.equals(")") || input.equals("*") || input.equals("/") || input.equals("+") || input.equals("-") || input.equals("(")
				|| input.equals("<") || input.equals(">") || input.equals("=") || input.equals("&")
				|| input.equals("|") || input.equals("!") || input.equals("^") || input.equals("%")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void readInput(String input) {
		if (input.equals(" ")) { 
			
		} else if (!checkForOperator(input)) {
			outputQueue.enqueue(input);
		} else if (checkForOperator(input)) {
			if(operatorStack.isEmpty()) {
				operatorStack.push(input);
			} else {
				operatorToken(input);
			}
		}
	}
	
	public void operatorToken(String input) {
		if (input.equals("(")) {
			operatorStack.push(input);
		} else if (input.equals("!")){
			operatorStack.push(input);
		} else if ((operatorStack.peek()) == null) {
			operatorStack.push(input);
		} else if (operatorStack.isEmpty()) {
			operatorStack.push(input);
		} else if (input.equals("*") || input.equals("/") || input.equals("%")) {
			while (!(((operatorStack.peek()).equals("%") || (operatorStack.peek()).equals("+") || (operatorStack.peek()).equals("-") || (operatorStack.peek()).equals("*") || (operatorStack.peek()).equals("/") || operatorStack.isEmpty() || (operatorStack.peek()).equals("=") || (operatorStack.peek()).equals("&") || (operatorStack.peek()).equals("|") || (operatorStack.peek()).equals("(")))) {
			
				popFromStackAndEnqueue();
			}
			if (!operatorStack.isEmpty() && !(operatorStack.peek()).equals("(")) {

				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals("+") || input.equals("-")) {
			while (!(((operatorStack.peek()).equals("+") || (operatorStack.peek()).equals("-") || operatorStack.isEmpty() || (operatorStack.peek()).equals("=") || (operatorStack.peek()).equals("&") || (operatorStack.peek()).equals("|") || (operatorStack.peek()).equals("(")))) {
				popFromStackAndEnqueue();
			}
			if (!operatorStack.isEmpty() && !(operatorStack.peek()).equals("(")) {
				
				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals(">") || input.equals("<")) {
			while (!(((operatorStack.peek()).equals("=") || (operatorStack.peek()).equals("&") || (operatorStack.peek()).equals("|") || operatorStack.isEmpty() || (operatorStack.peek()).equals("(")))) {
				popFromStackAndEnqueue();
			}
			if (!(operatorStack.isEmpty() || !(operatorStack.peek()).equals("("))) {
				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals("=")) {
			while (!(((operatorStack.peek()).equals("&") || (operatorStack.peek()).equals("|") || operatorStack.isEmpty()) || (operatorStack.peek()).equals("("))) {
				popFromStackAndEnqueue();
			}
			if(operatorStack.peek().equals("(")) {
				operatorStack.pop();
			} else if (!(operatorStack.isEmpty() && !(operatorStack.peek()).equals("("))) {
				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals("&") || input.equals("|") ) {
			while (!(operatorStack.isEmpty() || (operatorStack.peek()).equals("("))) {
				popFromStackAndEnqueue();
			}
			if (!(operatorStack.isEmpty() || !(operatorStack.peek()).equals("("))) {
				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals("^")) {
			while (!(((operatorStack.peek()).equals("%") || (operatorStack.peek()).equals("/") || (operatorStack.peek()).equals("*") || (operatorStack.peek()).equals("+") || (operatorStack.peek()).equals("-") || (operatorStack.peek()).equals("*") || (operatorStack.peek()).equals("/") || operatorStack.isEmpty() || (operatorStack.peek()).equals("=") || (operatorStack.peek()).equals("&") || (operatorStack.peek()).equals("|") || (operatorStack.peek()).equals("(")))) {
				popFromStackAndEnqueue();
			}
			if (!operatorStack.isEmpty() && !(operatorStack.peek()).equals("(")) {
//				System.out.println("popping " + operatorStack.peek());
				popFromStackAndEnqueue();
			}
			operatorStack.push(input);
		} else if (input.equals(")")) {
				while ((!operatorStack.isEmpty() && !(operatorStack.peek().equals("(")))) {
					popFromStackAndEnqueue();
				}
				if (!operatorStack.isEmpty()) {
					operatorStack.pop();
				}
		}
//		else if (input.equals(")")) {
//			while (!(operatorStack.peek().equals("("))) {
//				popFromStackAndEnqueue();
//			}
//			operatorStack.pop();
//		}
	}
	
	public void popAllStackAndEnqueue() {
		while (!operatorStack.isEmpty()) {
			popFromStackAndEnqueue();
		}
	}
	
	public void popFromStackAndEnqueue() {
		outputQueue.enqueue(operatorStack.pop());
	}

	//end of methods that convert from infix to postfix
	
	//beginning of methods that evaluate postfix expression
	
	public void popAllStackAndDequeueAll() {
		while (!operatorStack.isEmpty()) {
			operatorStack.pop();
		}
		
		while (!outputQueue.isEmpty()) {
			outputQueue.dequeue();
		}
	}
	
	public void evaluatePostfixExp() {
		String frontOfQueue = outputQueue.dequeue();
		
		while (!(frontOfQueue == null)) {
			if (checkForOperator(frontOfQueue)) {
				if (frontOfQueue.equals("!")) {
					String operationPop = operatorStack.pop();
					
					double num = Double.valueOf(operationPop);
					
					if (num == 1) {
						operatorStack.push(Double.toString(0));
					} else {
						operatorStack.push(Double.toString(1));
					}
				} else if (frontOfQueue.equals("*")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					operatorStack.push("" + (one*two));
				} else if (frontOfQueue.equals("/")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one == 0) {
						popAllStackAndDequeueAll();
						operatorStack.push("Error. Division by zero.");
					} else {
						operatorStack.push("" +(two/one));
					}
				} else if (frontOfQueue.equals("-")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					operatorStack.push("" +(two-one));
				} else if (frontOfQueue.equals("+")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					operatorStack.push("" + (one+two));
				} else if (frontOfQueue.equals(">")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one < two) {
						operatorStack.push("" +(1));
					} else {
						operatorStack.push("" +(0));
					}
				} else if (frontOfQueue.equals("<")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one > two) {
						operatorStack.push("" +(1));
					} else {
						operatorStack.push("" +(0));
					}	
				} else if (frontOfQueue.equals("=")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one == two) {
						operatorStack.push("" +(1));
					} else {
						operatorStack.push("" +(0));
					}
				} else if (frontOfQueue.equals("&")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one == 1 && two == 1) {
						operatorStack.push("" +(1));
					} else {
						operatorStack.push("" +(0));
					}
					
				} else if (frontOfQueue.equals("|")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					if (one == 1 || two == 1) {
						operatorStack.push("" +(1));
					} else {
						operatorStack.push("" +(0));
					}
				} else if (frontOfQueue.equals("^")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					operatorStack.push("" + Math.pow(two, one));
				} else if (frontOfQueue.equals("%")) {
					String operationPopOne = operatorStack.pop();
					String operationPopTwo = operatorStack.pop();
					
					double one = Double.valueOf(operationPopOne);
					double two = Double.valueOf(operationPopTwo);
					
					operatorStack.push("" + (two%one));
				}
			} else {
				operatorStack.push(frontOfQueue);
			}
			
			frontOfQueue = outputQueue.dequeue();
		}
	}
}
